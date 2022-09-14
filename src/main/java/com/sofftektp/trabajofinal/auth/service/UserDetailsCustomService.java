package com.sofftektp.trabajofinal.auth.service;


import com.sofftektp.trabajofinal.auth.dto.UserDTO;
import com.sofftektp.trabajofinal.auth.model.UserEntity;
import com.sofftektp.trabajofinal.model.Manager;
import com.sofftektp.trabajofinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    //private EmailService emailService;

    public UserDetailsCustomService(@Autowired @Lazy PasswordEncoder passwordEncoder, @Autowired @Lazy UserRepository userRepository ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        //this.emailService = emailService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var foundUser = userRepository.findByUsername(username);
        Collection<GrantedAuthority> authorities =  Collections.singleton(new SimpleGrantedAuthority(foundUser.getRole().getName()));
        return new User(
                foundUser.getUsername(),
                foundUser.getPassword(),
                authorities
        );
    }

    public boolean save(UserEntity userEnt){
       UserEntity userEntity = new UserEntity();
       userEntity.setName(userEnt.getName());
       userEntity.setUsername(userEnt.getUsername());
       userEntity.setPassword(passwordEncoder.encode(userEnt.getPassword()));
       userEntity = this.userRepository.save(userEntity);
       return userEntity != null;
    }

}