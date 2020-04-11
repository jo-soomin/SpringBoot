package com.login.Security.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.login.Security.dto.boardDto;

@Repository
public interface boardMapper {
	
	public int write(boardDto dto);
	public List<boardDto> selectlist(String username);
	
	public List<boardDto> selectAll();
}
