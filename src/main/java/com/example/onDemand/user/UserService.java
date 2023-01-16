package com.example.onDemand.user;

import com.example.onDemand.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserResponseView addUsers(UserProfileRequestView userProfileRequestView)
    {
        UserResponseView userResponseView =  new UserResponseView();
        UserId userIDStore = new UserId(UUID.randomUUID());
        User userStore = new User();
        userStore.setUserId(userIDStore);
        userStore.setUserName(userProfileRequestView.getUserName());
        User userResponse = userRepository.saveAndFlush(userStore);
        userResponseView.setUserID(userResponse.getUserId().getValue());
        userResponseView.setUserName(userResponse.getUserName());
        return userResponseView;
    }

    public List<UserResponseView> getAllUserData()
    {
        List<User> userList = userRepository.findAll();
        return userDetailsAggregator(userList);
    }

    public List<UserResponseView> userDetailsAggregator(List<User> userList)
    {
        List<UserResponseView> userResponseViewList = new ArrayList<>();
        for (User user : userList)
        {
            UserResponseView userResponseView = new UserResponseView();
            userResponseView.setUserName(user.getUserName());
            userResponseView.setUserID(user.getUserId().getValue());
            userResponseViewList.add(userResponseView);
        }
        return userResponseViewList;
    }

    public List<UserResponseView> getAllUserDataByName(String userName)
    {
        List<User> userList = userRepository.getUserDataByName(userName);
        return userDetailsAggregator(userList);
    }
}
