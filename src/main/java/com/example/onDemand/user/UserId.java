package com.example.onDemand.user;

import lombok.Builder;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Builder
@Embeddable
public class UserId implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID value;



}
