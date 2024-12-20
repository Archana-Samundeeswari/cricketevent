package com.sportseventapplication.service;

import java.util.List;
import java.util.Optional;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sportseventapplication.entity.*;

import com.sportseventapplication.DTO.CredentialDto;
import com.sportseventapplication.DTO.UserDTO;
import com.sportseventapplication.DTO.UserMapper;
import com.sportseventapplication.auth.service.JWTService;
import com.sportseventapplication.entity.User;
import com.sportseventapplication.exception.UsernameAlreadyExistsException;
import com.sportseventapplication.repository.PlayerRepository;
import com.sportseventapplication.repository.UserRepository;
import com.sportseventapplication.response.ResponseApi;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserService implements IUserService {
	
	
	@Autowired
	private JWTService jwtService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PlayerRepository playRepository;
	
	@Autowired
	private AuthenticationManager authManager;

	@Override
	public UserDTO createUser(User user) {
		
		
	 return	Optional.of(user).filter(u-> !userRepository.existsByEmail(user.getEmail())).map(req->{
			
			User newUser =userRepository.save(user);
			Player player = new Player();
			
			if(newUser.getRole()==Role.PLAYER)
			{		
				player.setUser(newUser);
				player.setPlayerName(newUser.getFirstName()+" "+newUser.getLastName() );
				player.setEmail(newUser.getEmail());
				player.setAge(newUser.getAge());
				//user.setPassword(passwordEncoder.encode(user.getPassword()));	
				playRepository.save(player);
				
			}
			user.setPassword(passwordEncoder.encode(user.getPassword()));

			return userMapper.toUserDTO(userRepository.save(newUser));
			
		}).orElseThrow(()->{throw new UsernameAlreadyExistsException("User Email "+user.getEmail()+" already exists");});
		
		
		
	}

	@Override 
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public UserDTO updateUser(User user, Long id) {
		user.setId(id);
		User updatedUser = userRepository.save(user);
		return convertToDTO(updatedUser);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}
	public UserDTO convertToDTO(User user) {
		return new UserDTO(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getGender(),user.getAge(),user.getCity(),user.getRole());
	}

	@Override
	public Optional<User> findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	public UserDTO verify(CredentialDto credential) {
		// TODO Auto-generated method stub
		
		Authentication authentication = authManager.authenticate
				(new UsernamePasswordAuthenticationToken(
				credential.email(), credential.password(),Collections.emptyList()));
		UserDTO userDto = new UserDTO();
		
		if(authentication.isAuthenticated()) {
			System.err.println("succ");
			User user = userRepository.findByEmail(credential.email()).get();
			userDto = userMapper.toUserDTO(user);
			userDto.setToken(jwtService.createToken(user));
		}
		else {
			System.err.println("Access Denied");
		}
		return userDto;
	}
	
	
	public boolean usernameExists(String email)
	{
		return userRepository.existsByEmail(email);
	}

	public User getProfile(HttpServletRequest request) {
	
		String email =  (String) request.getAttribute("email");
		 if(email!=null) {
			 return userRepository.findByEmail(email).get();
		 }
		 return null;
		
	}

}
