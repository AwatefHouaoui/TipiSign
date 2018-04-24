package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.dao.UserRoleRepository;
import com.example.entities.UserRole;

@RestController
public class UserRoleService {
	@Autowired
	private UserRoleRepository userRoleRepository;

	@RequestMapping(value = "/UserRole", method = RequestMethod.POST)
	public UserRole saveUserRole(@RequestBody UserRole a) {
		return userRoleRepository.save(a);
	}

	@RequestMapping(value = "/getUserRole", method = RequestMethod.GET)
	public List<UserRole> listUserRole() {
		return userRoleRepository.findAll();
	}

	public Page<UserRole> findAllUserRole(@RequestParam(name = "num", defaultValue = "0") int num,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		return userRoleRepository.findAll(new PageRequest(num, size));
	}

}
