package com.example.MCardSpring.Service;

import com.example.MCardSpring.Exception.UserNotFoundException;
import com.example.MCardSpring.MainModel.User;
import com.example.MCardSpring.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) throws ParseException {
        return userRepository.save(user);

    }

    public void deleteUser(Long id) {

        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new UserNotFoundException(id);
        }
    }

    public List<User> listUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public void updateUser(User newUser, Long id) throws ParseException {
        User user = userRepository.findById(id).get();

        user.setUsername(newUser.getUsername());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }
}
