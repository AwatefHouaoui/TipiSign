package org.side.service;

import java.util.List;

import org.side.dao.NotificationRepository;
import org.side.entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationService {
	@Autowired
	private NotificationRepository notificationRepository;

	@RequestMapping(value = "/Notification", method = RequestMethod.POST)
	public Notification saveNotification(@RequestBody Notification n) {
		return notificationRepository.save(n);
	}

	@RequestMapping(value = "/getNotification", method = RequestMethod.GET)
	public List<Notification> listNotification() {
		return notificationRepository.findAll();
	}

}
