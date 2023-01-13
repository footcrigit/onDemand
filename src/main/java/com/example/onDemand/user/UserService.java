package com.example.onDemand.user;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    public UserResponseView getUserName(UserProfileRequestView userProfileRequestView)
    {
        UserResponseView userResponseView =  new UserResponseView();
        userResponseView.setUserID(UUID.randomUUID());
        userResponseView.setUserName(userProfileRequestView.getUserName());
        return userResponseView;
    }
}
