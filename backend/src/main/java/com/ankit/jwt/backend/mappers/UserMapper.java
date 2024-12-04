package com.ankit.jwt.backend.mappers;

import com.ankit.jwt.backend.dtos.SignUpDto;
import com.ankit.jwt.backend.dtos.UserDto;
import com.ankit.jwt.backend.entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "login", target = "login")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "id", target = "id")
    UserDto toUserDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "login", target = "login")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}




// package com.ankit.jwt.backend.mappers;

// import com.ankit.jwt.backend.dtos.SignUpDto;
// import com.ankit.jwt.backend.dtos.UserDto;
// import com.ankit.jwt.backend.entites.User;
// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;

// @Mapper(componentModel = "spring")
// public interface UserMapper {

//     @Mapping(source = "login", target = "login")
//     @Mapping(source = "firstName", target = "firstName")
//     @Mapping(source = "lastName", target = "lastName")
//     @Mapping(source = "id", target = "id")
//     @Mapping(target = "token", ignore = true)  // Ignoring token as it's not present in User
//     UserDto toUserDto(User user);

//     @Mapping(target = "id", ignore = true)
//     @Mapping(source = "login", target = "login")
//     @Mapping(source = "firstName", target = "firstName")
//     @Mapping(source = "lastName", target = "lastName")
//     @Mapping(target = "password", ignore = true)
//     // @Mapping(target = "token", ignore = true)
//     User signUpToUser(SignUpDto signUpDto);
// }







// package com.ankit.jwt.backend.mappers;

// import com.ankit.jwt.backend.dtos.SignUpDto;
// import com.ankit.jwt.backend.dtos.UserDto;
// import com.ankit.jwt.backend.entites.User;
// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;

// @Mapper(componentModel = "spring")
// public interface UserMapper {

//     @Mapping(source = "login", target = "login")
//     @Mapping(source = "firstName", target = "firstName")
//     @Mapping(source = "lastName", target = "lastName")
//     @Mapping(source = "id", target = "id")
//     @Mapping(target = "token", ignore = true)  // Ignoring token as it's not present in User
//     UserDto toUserDto(User user);

//     @Mapping(target = "id", ignore = true)
//     // @Mapping(target = "token", ignore = true)
//     @Mapping(source = "login", target = "login")
//     @Mapping(source = "firstName", target = "firstName")
//     @Mapping(source = "lastName", target = "lastName")
//     @Mapping(target = "password", ignore = true)
//     User signUpToUser(SignUpDto signUpDto);
// }
