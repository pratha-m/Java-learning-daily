package com.springbootdemo.api.service;
import com.springbootdemo.api.apiResponse.ApiResponse;
import com.springbootdemo.api.entity.User;
import com.springbootdemo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public ResponseEntity<?> updateUser(Long userId,User user){
        User userFind=userRepository.findById(userId).orElse(null);

        if(userFind==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false,null,"User Not Found with given id"));

        userFind.setName(user.getName());
        userFind.setEmail(user.getEmail());

        userRepository.save(userFind);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true,userFind,null));
    }

    public ResponseEntity<?> deleteUser(Long userId){
        User userFind=userRepository.findById(userId).orElse(null);

        if(userFind==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false,null,"User Not Found with given id"));

        userRepository.deleteById(userId);

        return ResponseEntity.ok().body(new ApiResponse(true,userFind,"User deleted successfully"));
    }
}
