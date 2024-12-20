package com.sportseventapplication.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(name= "USER_ID",sequenceName = "user_id_sequence",initialValue = 101,allocationSize = 1)
	private long id;
	private String firstName;
	private String lastName;
	private String password;
	private String gender;
	private int age;
	private String city;
	@Column(unique = true)
	private String email;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	   @PrePersist
	    public void setDefaultPassword() {
	        if (this.password == null || this.password.isEmpty()) {
	            // Set default password and encode it (if using Spring Security)
	           
	            this.password = "123";
	        }
	    }
	
	
}
