package com.springBootUseSecurityAuth.vo;

import java.io.Serializable;

import com.springBootUseSecurityAuth.model.Role;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements Serializable{
	private static final long serialVersionUID = 1L;
	@NotNull(message = "userName can not null")
	private String userName;
	@NotNull(message = "passWord can not null")
	private String passWord;
}
