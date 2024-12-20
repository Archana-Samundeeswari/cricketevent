package com.sportseventapplication.auth.service;

import java.util.Collections;
import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.sportseventapplication.entity.User;
@Service
public class JWTService {

	private String secretKey = "suva";

	public String createToken(User user) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + 3600000);// one hour validation
		Algorithm algorithm = Algorithm.HMAC256(secretKey);
		return JWT.create().withSubject(user.getEmail())
				.withIssuedAt(now)
				.withExpiresAt(validity)
				.sign(algorithm);
	}

	public DecodedJWT getDecodeJWT(String token) {
		Algorithm algorithm = Algorithm.HMAC256(secretKey);
		JWTVerifier verifier = JWT.require(algorithm).build();
		DecodedJWT decoded = verifier.verify(token);
		return decoded;

	}
	
	public Authentication getAuthentication(String token) {
		DecodedJWT decoded = getDecodeJWT(token);
		
		User user = new User();
		user.setEmail(decoded.getSubject());
		
		return new UsernamePasswordAuthenticationToken( user,null,Collections.emptyList());
	}
	
	public String getUsername(String token) {
		DecodedJWT decoded = getDecodeJWT(token);
		return decoded.getSubject(); 		
	}

}
