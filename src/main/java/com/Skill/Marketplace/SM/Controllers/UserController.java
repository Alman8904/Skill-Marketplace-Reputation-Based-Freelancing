package com.Skill.Marketplace.SM.Controllers;
import com.Skill.Marketplace.SM.DTO.userDTO.CreateUserDTO;
import com.Skill.Marketplace.SM.DTO.userDTO.ResponseToUser;
import com.Skill.Marketplace.SM.DTO.userDTO.UpdateUserDTO;
import com.Skill.Marketplace.SM.DTO.userDTO.UserMapper;
import com.Skill.Marketplace.SM.Entities.UserModel;
import com.Skill.Marketplace.SM.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/public/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<ResponseToUser> createUser (@RequestBody CreateUserDTO request){

        UserModel user = new UserModel();

        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setUserType(request.getUserType());

        UserModel newUser=userService.createNewUser(user);

        return ResponseEntity.ok(userMapper.toResponse(newUser));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseToUser> updateUser(@PathVariable Long id, @RequestBody UpdateUserDTO updates){
        UserModel updatedUser = userService.updateUser(id,updates);
        return ResponseEntity.ok(userMapper.toResponse(updatedUser));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseToUser> searchUser(@PathVariable Long id){
        UserModel user = userService.getUserById(id);
        return ResponseEntity.ok(userMapper.toResponse(user));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<ResponseToUser> searchUserByUsername(@PathVariable String username){
        UserModel user = userService.getUserByUsername(username);
        return ResponseEntity.ok(userMapper.toResponse(user));
    }

    @GetMapping("/admin")
    public ResponseEntity<List<ResponseToUser>> getAllUsers(){
        List<UserModel> users = userService.getAllUsers();
        List<ResponseToUser> response = users.stream()
                .map(userMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }


}
