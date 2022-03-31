package com.example.demo.Controller;

import com.example.demo.Entity.AuthorEntity;
import com.example.demo.Entity.JwtRequest;
import com.example.demo.Entity.JwtResponse;
import com.example.demo.Exception.CustomException;
import com.example.demo.Helper.JwtUtil;
import com.example.demo.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class JwtController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest){
        int a = 10;
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

        }
        catch(UsernameNotFoundException e){
            throw new CustomException(HttpStatus.BAD_REQUEST, "Bad credentials");
        }
        catch (BadCredentialsException e){
            throw new CustomException(HttpStatus.BAD_REQUEST, "Bad credentials 1");
        }
        catch(Exception e){
            throw new CustomException(HttpStatus.BAD_REQUEST, "Bad credentials 2");
        }

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
