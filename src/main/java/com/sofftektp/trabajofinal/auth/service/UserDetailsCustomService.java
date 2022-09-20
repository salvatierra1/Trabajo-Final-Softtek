package com.sofftektp.trabajofinal.auth.service;


import com.sofftektp.trabajofinal.auth.model.Role;
import com.sofftektp.trabajofinal.auth.model.UserEntity;
import com.sofftektp.trabajofinal.exception.BadRequestException;
import com.sofftektp.trabajofinal.exception.NotFoundException;
import com.sofftektp.trabajofinal.model.Manager;
import com.sofftektp.trabajofinal.model.Seller;
import com.sofftektp.trabajofinal.repository.ManagerRepository;
import com.sofftektp.trabajofinal.repository.RoleRepository;
import com.sofftektp.trabajofinal.repository.SellerRepository;
import com.sofftektp.trabajofinal.repository.UserRepository;
import io.vavr.control.Try;
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

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;


@Service
public class UserDetailsCustomService implements UserDetailsService {


    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SellerRepository sellerRepository;


    public UserDetailsCustomService(@Autowired @Lazy PasswordEncoder passwordEncoder, @Autowired @Lazy UserRepository userRepository ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;

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


    public String updateUserRol(Long id, String roleName, HttpServletRequest request) {
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("No existe user con el id"));
        if(user.getRole()!= null) {
            if( roleName.equals(user.getRole().getName()))
                throw new BadRequestException("Usted ya cuenta con el rol");
        }

        if(roleRepository.findByName(roleName) == null){
            throw new NotFoundException("no existe el rol");
        }
        user.setRole(roleRepository.findByName(roleName));
        userRepository.save(user);

        Manager manager = managerRepository.findByUserEntity(user);
        Seller seller = sellerRepository.findByUserEntity(user);
        if(manager != null) managerRepository.delete(manager);
        if(seller != null) sellerRepository.delete(seller);
        if(user.getRole().getName().equals("ROLE_MANAGER")) managerRepository.save(new Manager(null,false, user, null));
        if(user.getRole().getName().equals("ROLE_SELLER")) sellerRepository.save(new Seller(null,false, user, null));
        return "Nuevo usuario";
    }
}