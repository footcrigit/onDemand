package com.example.onDemand.user;

import com.example.onDemand.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, UserId>, JpaSpecificationExecutor<User>
{
    @Modifying
    @Query("select u from User u where userName like %:userName%")
    List<User> getUserDataByName(@Param("userName") String userName);
}
