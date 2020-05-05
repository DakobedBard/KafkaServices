package org.mddarr.users.api;


import org.mddarr.users.bean.UserDTO;
import org.mddarr.users.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")

public class UsersAPI {

    @Autowired
    private UserService userService;

    @Autowired
    private InteractiveQueryService interactiveQueryService;

    @RequestMapping("/login/")
    @PostMapping("/post/")
    public String login(@RequestParam(value="email") String email, @RequestParam(value="password") String password)
    {
        return "order";
    }

    @RequestMapping("/register/")
    @PostMapping("/post/")
    public String postOrder(@RequestParam(value="name") String name, @RequestParam(value="email") String email,
                            @RequestParam(value="password")  String password)
    {
        UserDTO user = new UserDTO(name,email, password);
        this.userService.registerUser(user);
        return "order";
    }


    @RequestMapping("/register2/")
    @PostMapping("/post/")
    public String postOrdera(@RequestParam(value="name") String name, @RequestParam(value="email") String email,
                            @RequestParam(value="password")  String password)
    {
        UserDTO user = new UserDTO(name,email, password);
        this.userService.registerUser(user);
        return "order";
    }

}
