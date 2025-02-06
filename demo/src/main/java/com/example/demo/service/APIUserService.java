package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.APIUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class APIUserService {
    private final APIUserMapper apiUserMapper;
    private final PasswordEncoder passwordEncoder;

    public void signup(UserDTO userDTO) {
        String encodedPw = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPw);
        if (userDTO != null) {
            userDTO.setEnabled(true);
        }
        // 사용자 등록
        apiUserMapper.save(userDTO);
        // 권한 등록
        apiUserMapper.insertUserRole(userDTO.getId(),1);
    }
}
