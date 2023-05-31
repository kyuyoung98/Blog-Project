package com.kyuyoung.backend.controller;

import com.kyuyoung.backend.dto.ResponseDto;
import com.kyuyoung.backend.dto.SignInDto;
import com.kyuyoung.backend.dto.SignInResponseDto;
import com.kyuyoung.backend.dto.SignUpDto;
import com.kyuyoung.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
        ResponseDto<?> result = authService.signUp(requestBody);
        return result;
    }

    @PostMapping("/signIn")
    public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody) {
        ResponseDto<SignInResponseDto> result = authService.signIn(requestBody);
        return result;
    }
}
