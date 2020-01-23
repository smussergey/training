package ua.training.system_what_where_when.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.training.system_what_where_when.dto.UserRegistrationDTO;
import ua.training.system_what_where_when.exception.EntityNotFoundException;
import ua.training.system_what_where_when.model.Role;
import ua.training.system_what_where_when.model.User;
import ua.training.system_what_where_when.repository.UserRepository;

import java.util.Collections;
import java.util.List;


@Slf4j
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User register(UserRegistrationDTO userRegistrationDto) {

        User user = new User();
        user.setNameUa(userRegistrationDto.getNameUa());
        user.setNameEn(userRegistrationDto.getNameEn());
        user.setEmail(userRegistrationDto.getEmail());

        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.setRole(Role.ROLE_PLAYER);

        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }


    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }


    public User findUserByEmail(String email) {
        User result = userRepository.findByEmail(email);
        log.info("IN findByEmail - user: {} found by email: {}", result, email);
        return result;
    }

// TODO redo
    public User findUserById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        log.info("IN findById - user: {} found by id: {}", result, id);
        return result;
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted", id);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = findUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + email + " not found");
        }

        log.info("IN loadUserByUsername - user with username: {} successfully loaded", email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.singleton(user.getRole()));
    }

    public List<User> findAllUsersByRole(Role role) {
        return userRepository.findByRole(role).orElseThrow(() -> new EntityNotFoundException("Can not fond users with role: " + role.name()));
    }

    public User findLoggedIndUser() {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        return findUserByEmail(username);
    }
}
