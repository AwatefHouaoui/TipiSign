package com.example.metier;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entities.UserInformation;

public interface UserInformationMetier {
	public UserInformation saveUserInformation(UserInformation u);

	public List<UserInformation> listUserInformation();

	public Page<UserInformation> findUserByName(String userName, Pageable pageable);
}
