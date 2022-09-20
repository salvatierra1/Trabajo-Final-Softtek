package com.sofftektp.trabajofinal.auth.controller;

import com.sofftektp.trabajofinal.auth.dto.AuthenticationRequest;
import com.sofftektp.trabajofinal.auth.dto.AuthenticationResponse;
import com.sofftektp.trabajofinal.auth.model.RoleForm;
import com.sofftektp.trabajofinal.auth.model.UserEntity;
import com.sofftektp.trabajofinal.auth.service.JwtUtils;
import com.sofftektp.trabajofinal.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    private UserDetailsCustomService userDetailsService;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtTokenUtil;

    public UserAuthController(@Autowired @Lazy UserDetailsCustomService userDetailsService, AuthenticationManager authenticationManager, JwtUtils jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signUp(@RequestBody UserEntity dto) throws Exception {
        this.userDetailsService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> signIn(@Valid @RequestBody AuthenticationRequest authReq) throws Exception {

        UserDetails userDetails;
        try {

            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
            userDetails = (UserDetails) auth.getPrincipal();
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/update/role/{id}")
    public ResponseEntity<String> addRoleToUser(@PathVariable Long id, @RequestBody @Valid RoleForm role, HttpServletRequest request) {
        return ResponseEntity.ok(userDetailsService.updateUserRol(id, role.getName(), request));
    }

}
