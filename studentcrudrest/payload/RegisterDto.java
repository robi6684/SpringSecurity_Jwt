package com.monocept.studentcrudrest.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterDto {
	
	private String username;
	private String password;

}
