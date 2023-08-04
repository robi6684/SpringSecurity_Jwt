package com.monocept.studentcrudrest.service;

import com.monocept.studentcrudrest.payload.LoginDto;
import com.monocept.studentcrudrest.payload.RegisterDto;

public interface AuthService {
	String login(LoginDto loginDto);
	String register(RegisterDto registerDto);

}
