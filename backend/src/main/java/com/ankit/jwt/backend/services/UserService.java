package com.ankit.jwt.backend.services;

import com.ankit.jwt.backend.dtos.CredentialsDto;
import com.ankit.jwt.backend.dtos.SignUpDto;
import com.ankit.jwt.backend.dtos.UserDto;
import com.ankit.jwt.backend.entites.User;
import com.ankit.jwt.backend.exceptions.AppException;
import com.ankit.jwt.backend.mappers.UserMapper;
import com.ankit.jwt.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.getLogin())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {
        Optional<User> optionalUser = userRepository.findByLogin(userDto.getLogin());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

}



// package com.ankit.jwt.backend.services;

// import com.ankit.jwt.backend.dtos.CredentialsDto;
// import com.ankit.jwt.backend.dtos.SignUpDto;
// import com.ankit.jwt.backend.dtos.UserDto;
// import com.ankit.jwt.backend.entites.User;
// import com.ankit.jwt.backend.exceptions.AppException;
// import com.ankit.jwt.backend.mappers.UserMapper;
// import com.ankit.jwt.backend.repositories.UserRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.HttpStatus;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import java.nio.CharBuffer;
// import java.util.Optional;

// @RequiredArgsConstructor
// @Service
// public class UserService {

//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;
//     private final UserMapper userMapper;

//     public UserDto login(CredentialsDto credentialsDto) {
//         User user = userRepository.findByLogin(credentialsDto.getLogin())
//                 .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

//         if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
//             UserDto userDto = userMapper.toUserDto(user);
//             userDto.setToken(generateTokenForUser(user)); // Set token separately
//             return userDto;
//         }
//         throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
//     }

//     public UserDto register(SignUpDto signUpDto) {
//         Optional<User> optionalUser = userRepository.findByLogin(signUpDto.getLogin());

//         if (optionalUser.isPresent()) {
//             throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
//         }

//         User user = userMapper.signUpToUser(signUpDto);
//         user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDto.getPassword())));

//         User savedUser = userRepository.save(user);
//         UserDto userDto = userMapper.toUserDto(savedUser);
//         userDto.setToken(generateTokenForUser(savedUser)); // Set token separately

//         return userDto;
//     }

//     public UserDto findByLogin(String login) {
//         User user = userRepository.findByLogin(login)
//                 .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
//         UserDto userDto = userMapper.toUserDto(user);
//         userDto.setToken(generateTokenForUser(user)); // Set token separately
//         return userDto;
//     }

//     // Method to generate token for user
//     private String generateTokenForUser(User user) {
//         // Implement token generation logic here
//         return "generated-token"; // Placeholder implementation
//     }
// }