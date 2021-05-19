package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.ServiceRequestDetail;
import com.capgemini.service.AdminServiceImpl;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@PostMapping("/generatedetail")
	public String generateRequestdetail(@RequestBody ServiceRequestDetail servicerequestdetail) {
     return adminServiceImpl.generateRequestDetails(servicerequestdetail);
	}
	
}
