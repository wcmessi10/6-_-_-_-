package com.care.root.mybatis.members;

import com.care.root.members.dto.MembersDTO;

public interface MembersMapper {
	public MembersDTO userCheck(String id);
	public int register(MembersDTO dto);
}
