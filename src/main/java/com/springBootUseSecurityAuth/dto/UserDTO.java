package com.springBootUseSecurityAuth.dto;

import com.springBootUseSecurityAuth.vo.UserVO;

import lombok.Data;
@Data
public class UserDTO {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String passWord;
}
