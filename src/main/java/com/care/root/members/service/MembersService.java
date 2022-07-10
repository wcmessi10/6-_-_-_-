package com.care.root.members.service;

import javax.servlet.http.HttpServletRequest;

import com.care.root.members.dto.MembersDTO;

public interface MembersService {
	public int userCheck(HttpServletRequest request);
	public int register(MembersDTO dto);
}
