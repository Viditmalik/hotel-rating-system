package com.micro.user.repository;


import com.micro.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {

}
