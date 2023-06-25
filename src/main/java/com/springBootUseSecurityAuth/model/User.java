package com.springBootUseSecurityAuth.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
	@Id
	 @Column(name = "id", nullable = false)
//    @PrimaryKeyJoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "userName", nullable = false)
	private String userName;
	@Column(name = "passWord", nullable = false)
	private String passWord;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

}
