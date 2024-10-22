package com.springbootdemo.api.controller;
import com.springbootdemo.api.apiResponse.ApiResponse;
import com.springbootdemo.api.entity.User;
import com.springbootdemo.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User createdUser=userService.createUser(user);
            return ResponseEntity.ok().body(new ApiResponse(true,createdUser,null));
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body(new ApiResponse(false,null,e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        try{
            List<User> users=userService.getAllUsers();

            return ResponseEntity.ok().body(new ApiResponse(true,users,null));
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(false,null,e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        try{
            User userFind=userService.getUserById(id);

            if(userFind==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false,null,"User Not Found with given id"));

            return ResponseEntity.ok().body(new ApiResponse(true,userFind,null));
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body(new ApiResponse(false,null,e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody User user){
        try {
            ResponseEntity<?> updatedUser = userService.updateUser(id, user);

            return updatedUser;
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body(new ApiResponse(false,null,e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try{
             ResponseEntity<?> deletedUser=userService.deleteUser(id);

            return deletedUser;
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(new ApiResponse(false,null,e.getMessage()));
        }
    }

}
