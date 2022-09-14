package com.sofftektp.trabajofinal.seeder;

import com.sofftektp.trabajofinal.auth.model.Role;
import com.sofftektp.trabajofinal.auth.model.UserEntity;
import com.sofftektp.trabajofinal.model.Manager;
import com.sofftektp.trabajofinal.repository.ManagerRepository;
import com.sofftektp.trabajofinal.repository.RoleRepository;
import com.sofftektp.trabajofinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserSeeder implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUser();
    }

    private void loadUser() {
        if(userRepository.count() == 0){
            loadUserEntity();
        }
    }

    private void loadUserEntity() {
        Role role = null;
        if (roleRepository.count() == 0) {
            role = new Role(
                    "ROLE_MANAGER");
            roleRepository.save(role);
        }
        createUser("Victor","admin@mail.com", "12345678", role);
        createUserManager(userRepository.findByUsername("admin@mail.com"));
    }
    private void createUser(String name, String username, String password, Role role) {
        UserEntity user = new UserEntity(
                name,
                username,
                passwordEncoder.encode(password),
                role
        );
        userRepository.save(user);
    }

    private void createUserManager(UserEntity user) {
        Manager manager = new Manager(null,
                user
        );
        managerRepository.save(manager);
    }

}
