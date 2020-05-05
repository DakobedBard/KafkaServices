package org.mddarr.users.service.impl;

import org.mddarr.users.dao.UserRepository;
import org.mddarr.users.model.User;
import org.mddarr.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fan.jin on 2016-10-15.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username ) throws UsernameNotFoundException {
        User u = userRepository.findByUsername( username );
        return u;
    }

//    public User findById( Long id ) throws AccessDeniedException {
//        User u = userRepository.findOne(id);
//        return u;
//    }

    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }
}
