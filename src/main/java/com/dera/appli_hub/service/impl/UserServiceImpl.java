package com.dera.appli_hub.service.impl;

import com.dera.appli_hub.domain.entity.User;
import com.dera.appli_hub.payload.request.UpdateRequest;
import com.dera.appli_hub.payload.response.ApiResponse;
import com.dera.appli_hub.payload.response.UserResponse;
import com.dera.appli_hub.repository.UserRepository;
import com.dera.appli_hub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public ApiResponse<?> viewUser() {
        String email = getLoginUser();
        User user = userRepository.findByEmail(email).get();
        UserResponse response = UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dateOfBirth(user.getDateOfBirth())
                .email(user.getEmail())
                .build();
        return ApiResponse.builder()
                .status("success")
                .message("Review user details")
                .data(response)
                .statusCode(HttpStatus.OK)
                .build();
    }

    @Override
    public ApiResponse<?> updateUser(UpdateRequest updateRequest) {
        String email = getLoginUser();
        User user = userRepository.findByEmail(email).get();
        if (updateRequest.getFirstName() != null) user.setFirstName(updateRequest.getFirstName());
        if (updateRequest.getLastName() != null) user.setLastName(updateRequest.getLastName());
        if (updateRequest.getDateOfBirth() != null) user.setDateOfBirth(updateRequest.getDateOfBirth());
        if (updateRequest.getEmail() != null) user.setEmail(updateRequest.getEmail());

        User savedUser = userRepository.save(user);

        UserResponse response = UserResponse.builder()
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .dateOfBirth(savedUser.getDateOfBirth())
                .email(savedUser.getEmail())
                .build();

        return ApiResponse.builder()
                .status("success")
                .message("User details updated successfully")
                .data(response)
                .build();
    }

    @Override
    public ApiResponse<?> deleteUser() {
        String email = getLoginUser();
        User user = userRepository.findByEmail(email).get();
        userRepository.delete(user);
        return ApiResponse.builder()
                .status("success")
                .message("User deleted successfully")
                .statusCode(HttpStatus.NO_CONTENT)
                .build();
    }

    public static String getLoginUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails){
            return ((UserDetails)principal).getUsername();
        } else{
            return principal.toString();
        }
    }
}
