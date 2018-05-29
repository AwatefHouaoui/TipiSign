package org.side.service;

import java.util.List;

import org.side.dao.UserToUserRequestRepository;
import org.side.entities.UserToUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserToUserRequestService {
	@Autowired
	UserToUserRequestRepository userToUserRequestRepository;

	@RequestMapping(value = "/UserToUser", method = RequestMethod.POST)
	public UserToUserRequest saveUserToUserRequest(@RequestBody UserToUserRequest u) {
		return userToUserRequestRepository.save(u);
	}

	@RequestMapping(value = "/getUserToUser", method = RequestMethod.GET)
	public List<UserToUserRequest> listUserToUserRequest() {
		return userToUserRequestRepository.findAll();
	}
	
	@RequestMapping(value = "/getRequestsApproved", method = RequestMethod.GET)
	public int requestApproved (@RequestParam(name="idUser") String idUser) {
		return userToUserRequestRepository.requestApproved(idUser).size();
	}
	
	@RequestMapping(value = "/getRequestsDisapproved", method = RequestMethod.GET)
	public int requestDisapproved(@RequestParam(name="idUser") String idUser) {
		return userToUserRequestRepository.requestDisapproved(idUser).size();
	}

}
