package com.board.test.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.board.test.dto.boardDto;

@Repository
public interface boardMapper {
	
	
	public boardDto board();
	
	public List<boardDto> boardList();
	
	public int write(boardDto dto);
	
	public int delete(String id);
	
	public boardDto one(String id);
	
	public int update(boardDto dto);

}
