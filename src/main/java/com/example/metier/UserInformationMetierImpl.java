package com.example.metier;

import java.util.List;

import com.example.dao.UserInformationRepository;
import com.example.entities.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserInformationMetierImpl implements UserInformationMetier {

	@Autowired
	private UserInformationRepository userInformationRepository;

	@Override
	public UserInformation saveUserInformation(UserInformation u) {
		return userInformationRepository.save(u);
	}

	@Override
	public List<UserInformation> listUserInformation() {
		return userInformationRepository.findAll();
	}

	@Override
	public Page<UserInformation> findUserByName(String userName, Pageable pageable) {
		return userInformationRepository.findUserByName(userName, pageable);
	}

}
