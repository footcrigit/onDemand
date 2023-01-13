package com.example.onDemand.user;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.UUID;

@Data
public class UserResponseView {

    @JsonView(Views.V1.class)
    private UUID userID;

    @JsonView(Views.V1.class)
    private String userName;

    public static class Views {
        public static class V1 {
        }
    }
}
