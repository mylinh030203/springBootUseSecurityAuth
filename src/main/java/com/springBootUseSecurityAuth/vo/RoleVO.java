package com.springBootUseSecurityAuth.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class RoleVO implements Serializable{
    private Long id;

    private String name;

}
