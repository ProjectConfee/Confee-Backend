package com.backend.confee.service;

import com.backend.confee.dto.AllUserDTO;
import com.backend.confee.dto.UserProfileDTO;
import com.backend.confee.entity.AllUsers;
import com.backend.confee.entity.UserProfile;
import com.backend.confee.repo.AllUsersRepo;
import com.backend.confee.repo.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UsersManagementService {
    @Autowired
    private AllUsersRepo usersRepo;
    private UserProfileRepo profileRepo;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public AllUserDTO register(AllUserDTO registrationRequest){
        AllUserDTO resp = new AllUserDTO();

        try {
            AllUsers allUser = new AllUsers();
            allUser.setEmail(registrationRequest.getEmail());
            allUser.setRole(registrationRequest.getRole());
            allUser.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            AllUsers ourUsersResult = usersRepo.save(allUser);
            if (ourUsersResult.getId()>0) {
                resp.setAllUsers((ourUsersResult));
                resp.setMessage("User Saved Successfully");
                resp.setStatusCode(200);
            }

        }catch (Exception e){
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }


    public AllUserDTO login(AllUserDTO loginRequest){
        AllUserDTO response = new AllUserDTO();
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword()));
            var user = usersRepo.findByEmail(loginRequest.getEmail()).orElseThrow();
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRole(user.getRole());
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hrs");
            response.setMessage("Successfully Logged In");

        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

//    public UserProfile completeProfile(Integer userId, UserProfileDTO profileDto) {
//
//        Optional<AllUsers> userOpt = usersRepo.findById(userId);
//        if (userOpt.isEmpty()) {
//            throw new IllegalArgumentException("User not found!");
//        }
//
//        AllUsers user = userOpt.get();
//
//        UserProfile profile = profileRepo.findByUserId(userId)
//                .orElseThrow(() -> new IllegalArgumentException("Profile not found for this user!"));
//
//        profile.setFName(profileDto.getFName());
//        profile.setLName(profileDto.getLName());
//        profile.setIsComplete(true);
//
//        return profileRepo.save(profile);
//    }
//
//    public Optional<AllUsers> findUserById(Integer userId) {
//        return usersRepo.findById(userId);
//    }
//
//    public Optional<UserProfile> findProfileByUserId(Integer userId) {
//        return profileRepo.findByUserId(userId);
//    }


    public AllUserDTO refreshToken(AllUserDTO refreshTokenReqiest){
        AllUserDTO response = new AllUserDTO();
        try{
            String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
            AllUsers users = usersRepo.findByEmail(ourEmail).orElseThrow();
            if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
                var jwt = jwtUtils.generateToken(users);
                response.setStatusCode(200);
                response.setToken(jwt);
                response.setRefreshToken(refreshTokenReqiest.getToken());
                response.setExpirationTime("24Hr");
                response.setMessage("Successfully Refreshed Token");
            }
            response.setStatusCode(200);
            return response;

        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            return response;
        }
    }


    public AllUserDTO getAllUsers() {
        AllUserDTO reqRes = new AllUserDTO();

        try {
            List<AllUsers> result = usersRepo.findAll();
            if (!result.isEmpty()) {
                reqRes.setAllUsersList(result);
                reqRes.setStatusCode(200);
                reqRes.setMessage("Successful");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("No users found");
            }
            return reqRes;
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred: " + e.getMessage());
            return reqRes;
        }
    }


    public AllUserDTO getUsersById(Integer id) {
        AllUserDTO reqRes = new AllUserDTO();
        try {
            AllUsers usersById = usersRepo.findById(id).orElseThrow(() -> new RuntimeException("User Not found"));
            reqRes.setAllUsers(usersById);
            reqRes.setStatusCode(200);
            reqRes.setMessage("Users with id '" + id + "' found successfully");
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred: " + e.getMessage());
        }
        return reqRes;
    }


    public AllUserDTO deleteUser(Integer userId) {
        AllUserDTO reqRes = new AllUserDTO();
        try {
            Optional<AllUsers> userOptional = usersRepo.findById(userId);
            if (userOptional.isPresent()) {
                usersRepo.deleteById(userId);
                reqRes.setStatusCode(200);
                reqRes.setMessage("User deleted successfully");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for deletion");
            }
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while deleting user: " + e.getMessage());
        }
        return reqRes;
    }

    public AllUserDTO updateUser(Integer userId, AllUsers updatedUser) {
        AllUserDTO reqRes = new AllUserDTO();
        try {
            Optional<AllUsers> userOptional = usersRepo.findById(userId);
            if (userOptional.isPresent()) {
                AllUsers existingUser = userOptional.get();
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setRole(updatedUser.getRole());

                // Check if password is present in the request
                if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                    // Encode the password and update it
                    existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
                }

                AllUsers savedUser = usersRepo.save(existingUser);
                reqRes.setAllUsers(savedUser);
                reqRes.setStatusCode(200);
                reqRes.setMessage("User updated successfully");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for update");
            }
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while updating user: " + e.getMessage());
        }
        return reqRes;
    }


    public AllUserDTO getMyInfo(String email){
        AllUserDTO reqRes = new AllUserDTO();
        try {
            Optional<AllUsers> userOptional = usersRepo.findByEmail(email);
            if (userOptional.isPresent()) {
                reqRes.setAllUsers(userOptional.get());
                reqRes.setStatusCode(200);
                reqRes.setMessage("successful");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for update");
            }

        }catch (Exception e){
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while getting user info: " + e.getMessage());
        }
        return reqRes;

    }
}
