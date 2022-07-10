package com.care.root.members.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.members.dto.MembersDTO;
import com.care.root.mybatis.members.MembersMapper;

@Service
public class MembersServiceImpl implements MembersService {
	
	@Autowired 
	MembersMapper mappers;
	@Override
	public int userCheck(HttpServletRequest request) {
		MembersDTO dto = mappers.userCheck(request.getParameter("mid"));
		//계정 정보를 받아야 하니까 dto타입 mappers의 메소드 생성
		//pk인 아이디로 확인하기 위해 String 객체를 하나 넘기도록 해야한다.
		if(dto !=null) {
			return 0; //로그인 성공이라는 의미인 0을 MembersController로 반납
		}
		return 1;//아니면 실패라는 의미인 0이 아닌 수를  MembersController로 반납
	}
	@Override
	public int register(MembersDTO dto) {
		
		return mappers.register(dto);
	}

}
