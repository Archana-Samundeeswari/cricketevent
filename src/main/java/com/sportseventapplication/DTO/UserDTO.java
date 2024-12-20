package com.sportseventapplication.DTO;

import com.sportseventapplication.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UserDTO  {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private int age;
	private String city;
	private Role role;
	private String token;
	public UserDTO(long id, String firstName, String lastName, String email, String gender, int age, String city,
			Role role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.city = city;
		this.role = role;
	}

		
	
}
