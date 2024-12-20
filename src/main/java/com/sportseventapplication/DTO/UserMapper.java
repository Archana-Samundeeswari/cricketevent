package com.sportseventapplication.DTO;

import com.sportseventapplication.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	 UserDTO toUserDTO(User user);

}
