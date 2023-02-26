package com.misc.JwtRoles1.controller;

import com.misc.JwtRoles1.dto.MyAuthRequest;
import com.misc.JwtRoles1.service.MyJwtService;
import com.misc.JwtRoles1.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class MyAuthController {

    @Autowired
    private MyJwtService myJwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserService myUserService;

    @GetMapping("/helloworld")
    public String helloworld() {
        return "Hello World is not a secured endpoint. Anyone can access it !!!";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome is not a secured endpoint. Anyone can access it !!!";
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody MyAuthRequest myAuthRequest) {
        //existing users should not be allowed to signup again
        if (!myUserService.isUserNameAlreadyExists(myAuthRequest.getMyusername())) {
            String token = myJwtService.generateTokenFromMyUsername(myAuthRequest.getMyusername());
            return new ResponseEntity<>(myUserService.saveMyUser(myAuthRequest, token), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User already exists. Please Sign In.", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody MyAuthRequest myAuthRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                myAuthRequest.getMyusername(), myAuthRequest.getMypassword()));
        if (authentication.isAuthenticated()) {
            return myJwtService.generateTokenFromMyUsername(myAuthRequest.getMyusername());
        } else {
            throw new UsernameNotFoundException("Invalid User 1!!");
        }
    }

}
