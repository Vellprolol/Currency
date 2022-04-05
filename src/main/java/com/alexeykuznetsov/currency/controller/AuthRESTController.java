package com.alexeykuznetsov.currency.controller;

import com.alexeykuznetsov.currency.model.Role;
import com.alexeykuznetsov.currency.model.User;
import com.alexeykuznetsov.currency.model.UserRoleEnum;
import com.alexeykuznetsov.currency.pojo.JwtResponse;
import com.alexeykuznetsov.currency.pojo.LoginRequest;
import com.alexeykuznetsov.currency.pojo.MessageResponse;
import com.alexeykuznetsov.currency.pojo.SignupRequest;
import com.alexeykuznetsov.currency.repository.RoleRepository;
import com.alexeykuznetsov.currency.repository.UserRepository;
import com.alexeykuznetsov.currency.security.jwt.JwtUtils;
import com.alexeykuznetsov.currency.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthRESTController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/sign-in")
    public ResponseEntity<?> authUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {

        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is exist"));
        }

        User user = new User(signupRequest.getUsername(),
                passwordEncoder.encode(signupRequest.getPassword()));

        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository
                .findByName(UserRoleEnum.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error, Role USER is not found"));
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User CREATED"));
    }
}
