package org.mddarr.users.services;

import org.mddarr.users.bean.UserDTO;
import org.mddarr.users.dao.UserEntityRepository;

import org.mddarr.users.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserEntityRepository userRepository;

    public String registerUser(UserDTO usersDTO){
        UUID uuid =  UUID.randomUUID();
        UserEntity user = new UserEntity(uuid.toString(), usersDTO.getName(),usersDTO.getEmail(), usersDTO.getPassword());
        userRepository.save(user);
        return uuid.toString();
    }



}
