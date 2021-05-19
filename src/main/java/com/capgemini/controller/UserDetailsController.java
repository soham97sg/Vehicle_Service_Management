package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.UserDetails;
import com.capgemini.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/user/")
public class UserDetailsController {
	
	@Autowired
	private UserDetailsServiceImpl userdetailserviceimpl;
	
	@PostMapping("/")
	public String create(@RequestBody UserDetails userdetails) {
		return userdetailserviceimpl.createUserDetails(userdetails);
	}
	
	@PutMapping("/{user_id}")
	public String update(@PathVariable int user_id,@RequestBody UserDetails userdetails) {
			return userdetailserviceimpl.updateUserDetails(user_id, userdetails);
		}
	@GetMapping("/{user_id}")
	public UserDetails findById(@PathVariable int user_id) {
		return userdetailserviceimpl.findUserDetailsById(user_id);
	}
	
	@GetMapping("/")
	public List<UserDetails> getRequest(){
		return userdetailserviceimpl.getRequest();
	}
	
	@DeleteMapping("/{user_id}")
	public String deleteUser(@PathVariable int user_id) {
		return userdetailserviceimpl.deleteUserDetails(user_id);
	}

}
