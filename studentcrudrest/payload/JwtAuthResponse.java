package com.monocept.studentcrudrest.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class JwtAuthResponse {
	
	private String accessToken;
	private String tokenType = "Bearer";
}
