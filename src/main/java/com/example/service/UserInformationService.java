package com.example.service;

import com.example.entities.UserInformation;
import com.example.metier.UserInformationMetier;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInformationService {
	@Autowired
	private UserInformationMetier userInformationMetier;

	@RequestMapping(value = "/UserInfo", method = RequestMethod.POST)
	public UserInformation saveUserInformation(@RequestBody UserInformation u) {
		String userName = u.getUserName();
		u.setUserName(userName.toLowerCase());
		return userInformationMetier.saveUserInformation(u);
	}

	@RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
	public List<UserInformation> listUserInformation() {
		return userInformationMetier.listUserInformation();
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public Page<UserInformation> findUserByName(@RequestParam(name = "userName") String userName,
			@RequestParam(name = "numPage", defaultValue = "0") int numPage,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		return userInformationMetier.findUserByName("%" + userName + "%", new PageRequest(numPage, size));
	}

}
