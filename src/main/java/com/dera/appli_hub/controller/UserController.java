package com.dera.appli_hub.controller;

import com.dera.appli_hub.service.StorageService;
import com.dera.appli_hub.payload.request.UpdateRequest;
import com.dera.appli_hub.payload.response.ApiResponse;
import com.dera.appli_hub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final StorageService storageService;

    @GetMapping("/view")
    public ResponseEntity<ApiResponse<?>> viewUser(){
        ApiResponse<?> response = userService.viewUser();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<?>> updateUser(@RequestBody UpdateRequest updateRequest){
        ApiResponse<?> response = userService.updateUser(updateRequest);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<?>> deleteuser(){
        ApiResponse<?> response = userService.deleteUser();

        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file) throws IOException {
        String response = storageService.uploadFile(file);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{file}")
    public ResponseEntity<?> downloadFile(@PathVariable String file) throws IOException {
        byte[] response = storageService.downloadFile(file);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
