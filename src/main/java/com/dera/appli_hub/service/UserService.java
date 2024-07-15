package com.dera.appli_hub.service;

import com.dera.appli_hub.payload.request.UpdateRequest;
import com.dera.appli_hub.payload.response.ApiResponse;

public interface UserService {

    ApiResponse<?> viewUser();
    ApiResponse<?> updateUser(UpdateRequest updateRequest);
    ApiResponse<?> deleteUser();
}
