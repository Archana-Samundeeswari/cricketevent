package com.sportseventapplication.service;

import java.util.List;
import java.util.Optional;

import com.sportseventapplication.DTO.UserDTO;
import com.sportseventapplication.entity.User;

public interface IUserService {
	public UserDTO createUser(User user);
	public List<User> getAllUser();
	public User getUser(Long id);
	public UserDTO updateUser(User user, Long id);
	public void deleteUser(Long id);
	public Optional<User> findByEmail(String email);

}
