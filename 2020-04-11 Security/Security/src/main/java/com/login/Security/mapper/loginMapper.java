package com.login.Security.mapper;

import org.springframework.stereotype.Repository;

import com.login.Security.dto.loginDto;

@Repository
public interface loginMapper {
	
	public int signup(loginDto dto);
	
	public loginDto selectOne(String username);

}
