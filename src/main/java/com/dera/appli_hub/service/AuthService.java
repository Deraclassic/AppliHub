package com.dera.appli_hub.service;

import com.dera.appli_hub.payload.request.LoginRequest;
import com.dera.appli_hub.payload.request.RegisterRequest;
import com.dera.appli_hub.payload.response.ApiResponse;

public interface AuthService {
    ApiResponse<?> register(RegisterRequest registerRequest);
    ApiResponse<?> login(LoginRequest loginRequest);
}
