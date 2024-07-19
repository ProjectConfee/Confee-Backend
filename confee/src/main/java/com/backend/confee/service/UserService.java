package com.backend.confee.service;

import com.backend.confee.dto.UserDTO;
import com.backend.confee.entity.User;
import com.backend.confee.repo.UserRepo;
import com.backend.confee.util.VarList;
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

    public String saveUser(UserDTO userDTO){
        if (userRepo.existsById(userDTO.getId())){
            return VarList.RSP_DUPLICATED;
        }else {
            userRepo.save(modelMapper.map(userDTO, User.class));
            return VarList.RSP_SUCCESS;
        }

    }
    public List<UserDTO> getAllUsers(){
        List<User> users = userRepo.findAll();
        return modelMapper.map(users, new TypeToken<List<UserDTO>>() {}.getType());
    }
    public String updateUser(UserDTO userDTO){
        if (userRepo.existsById(userDTO.getId())){
            userRepo.save(modelMapper.map(userDTO, User.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public UserDTO searchUser(Integer id){
        if (userRepo.existsById(id)){
            User user = userRepo.findById(id).orElse(null);
            return  modelMapper.map(user,UserDTO.class);
        }else {
            return null;
        }
    }
    public String deleteUser(int userId){

        if (userRepo.existsById((userId))){
            userRepo.deleteById(userId);
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
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
