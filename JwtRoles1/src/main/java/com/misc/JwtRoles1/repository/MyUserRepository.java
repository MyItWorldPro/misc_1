package com.misc.JwtRoles1.repository;

import com.misc.JwtRoles1.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    Optional<MyUser> findByMyusername(String username);

}
