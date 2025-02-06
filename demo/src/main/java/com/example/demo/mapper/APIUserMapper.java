package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface APIUserMapper {

    void save(UserDTO userDTO);
    void insertUserRole(@Param("userId") int userId, @Param("roleId") int roleId);

}
