package com.example.onDemand.experiment;

import com.example.onDemand.user.UserProfileRequestView;
import com.example.onDemand.user.UserResponseView;
import com.example.onDemand.user.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListOperationController {

    @Autowired
    ListOperationService listOperationService;

    @Autowired
    UserService userService;

    @Operation(description = "this is a List service")
    @GetMapping(path = "/v1/alert/details", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(ListOperationView.Views.V1.class)
    public ResponseEntity<ListOperationView> getDataValues() {
        ListOperationView listOperationView = listOperationService.getDataList();
        return ResponseEntity.ok(listOperationView);
    }

    @Operation(description = "This is to end User information")
    @PostMapping(path = "v1/userData", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(UserResponseView.Views.V1.class)
    public ResponseEntity<UserResponseView> postUserData(@RequestBody UserProfileRequestView userProfileRequestView) {
        UserResponseView userResponseView = userService.addUsers(userProfileRequestView);
        return ResponseEntity.ok(userResponseView);
    }

    @Operation(description = "This API to get all userdata")
    @GetMapping(path = "v1/getAllUserData", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(UserResponseView.Views.V1.class)
    public ResponseEntity<List<UserResponseView>> getAllUserData() {
        List<UserResponseView> userResponseViewList = userService.getAllUserData();
        return ResponseEntity.ok(userResponseViewList);
    }


    @Operation(description = "This API to get all userdata based on user name")
    @GetMapping(path = "v1/getAllUserData/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(UserResponseView.Views.V1.class)
    public ResponseEntity<List<UserResponseView>> getAllUserDataByName(String userName) {
        List<UserResponseView> userResponseViewList = userService.getAllUserDataByName(userName);
        return ResponseEntity.ok(userResponseViewList);
    }
}
