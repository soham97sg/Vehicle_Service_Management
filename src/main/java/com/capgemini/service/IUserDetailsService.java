package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.UserDetails;

public interface IUserDetailsService {
String createUserDetails(UserDetails userDetails);
String updateUserDetails(int user_id,UserDetails userDetails);
UserDetails findUserDetailsById(int user_id);
List<UserDetails> getRequest();
String deleteUserDetails(int user_id);
}
