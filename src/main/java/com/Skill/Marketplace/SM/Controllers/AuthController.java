package com.Skill.Marketplace.SM.Controllers;
import com.Skill.Marketplace.SM.DTO.userDTO.CreateUserDTO;
import com.Skill.Marketplace.SM.DTO.userDTO.LoginDTO;
import com.Skill.Marketplace.SM.DTO.userDTO.ResponseToUser;
import com.Skill.Marketplace.SM.Entities.UserModel;
import com.Skill.Marketplace.SM.Security.JWTUtil;
import com.Skill.Marketplace.SM.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtService;
    private final UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser (@Valid @RequestBody CreateUserDTO request){

        UserModel user = userService.createNewUser(request);
        return ResponseEntity.ok(
                new ResponseToUser(
                        user.getId(),
                        user.getUsername(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getUserType()
                )
        );
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
        return jwtService.generateToken(user);
    }
}

