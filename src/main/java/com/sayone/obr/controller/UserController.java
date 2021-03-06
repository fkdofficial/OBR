package com.sayone.obr.controller;

import com.sayone.obr.model.request.UserDetailsRequestModel;
import com.sayone.obr.model.response.UserRestModel;
import com.sayone.obr.service.UserService;
import com.sayone.obr.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public UserRestModel createUser(@RequestBody UserDetailsRequestModel userDetails) {

        UserRestModel returnValue = new UserRestModel();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(userDto, returnValue);

        return returnValue;
    }
}
