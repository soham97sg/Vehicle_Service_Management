package com.capgemini.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.UserDetails;
import com.capgemini.repository.UserDetailsRepository;
@Service
public class UserDetailsServiceImpl implements IUserDetailsService {
	@Autowired
	private UserDetailsRepository userdetailrepository;
	@Override
	public UserDetails createUserDetails(UserDetails userDetails) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		userDetails.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		userDetails.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		userdetailrepository.save(userDetails);
		return userDetails;
	}

	@Override
	public String updateUserDetails(int user_id, UserDetails userDetails) {
		UserDetails dbUser=userdetailrepository.findById(user_id).get();
		if(dbUser!=null) {
			dbUser.setUser_name(userDetails.getUser_name());
			dbUser.setUser_email(userDetails.getUser_email());
			dbUser.setUser_mobile(userDetails.getUser_mobile());
			dbUser.setUser_password(userDetails.getUser_password());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			userDetails.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		}
			userdetailrepository.save(dbUser);
			return "User Details Updated!!!";
	}

	@Override
	public UserDetails findUserDetailsById(int user_id) {
		UserDetails dbUser=userdetailrepository.findById(user_id).get();
		System.out.println(dbUser);
		return(dbUser);
	}

	@Override
	public List<UserDetails> getRequest() {
		return userdetailrepository.findAll();
	}

	@Override
	public String deleteUserDetails(int user_id) {
		UserDetails dbUser=userdetailrepository.findById(user_id).get();
		if(dbUser.isDeleted == false) {
			dbUser.isDeleted = true;
			userdetailrepository.save(dbUser);
		}
		return "User Details Deleted";
	}
	
	

}
