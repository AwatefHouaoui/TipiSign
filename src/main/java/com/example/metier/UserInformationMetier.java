package com.example.metier;

import java.util.List;

import com.example.entities.UserInformation;

public interface UserInformationMetier {
	public UserInformation saveUserInformation(UserInformation u);

	public List<UserInformation> listUserInformation();

}
