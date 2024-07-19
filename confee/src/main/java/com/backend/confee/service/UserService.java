package com.backend.confee.service;

import com.backend.confee.dto.UserDTO;
import com.backend.confee.entity.User;
import com.backend.confee.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
    public List<UserDTO> getAllUsers(){
        List<User> users = userRepo.findAll();
        return modelMapper.map(users, new TypeToken<List<UserDTO>>() {}.getType());
    }
    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

    public UserDTO getUserByUserId(String userId){
        User user=userRepo.getUserByUserID(userId);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO getUserByUserIdAndAddress(String userId, String address){
        User user=userRepo.getUserByIDAndAddress(userId,address);
        return modelMapper.map(user, UserDTO.class);
    }
}
