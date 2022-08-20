package com.edusol.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edusol.user.model.User;
import com.edusol.user.repository.UserRepository;



@Service
public class UserService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
	private UserRepository userrepository;
	
	public User addUser(User user) {
		userrepository.save(user);
		logger.info(user.toString());
      	return user;
	}

	public List<User> getUsers() {
		
		List<User>users = userrepository.findAll();
		logger.info(users.toString());
	   return users;
	}

	public String updateUser(User user) {
		logger.info(user.toString());
		 userrepository.save(user);
		 logger.info("Record Updated Successfully");
		 return "Record Updated Successfully";
	}

	public String deleteUser(int id) {
		logger.info("Deleting user by:"+id);
		String message = "";
		try {
			User user = userrepository.getOne(id);
			userrepository.deleteById(id);
			logger.info("Record deleted successfully");
			message = "Record deleted successfully"+id;
		}catch (Exception e) {
			logger.error("Record not found");
			message = "Record not found"+id;
		}
		return message;
	}

	public List<User> getUsersByCity( String city) {
		logger.info("Deleting user by:"+city );
		List<User>users= userrepository.findByCity(city);
		return users;
	}

	public List<User> getUsersByEmail(String email) {
		logger.info("Deleting user by:"+email );
		List<User>users= userrepository.findByEmail(email);
		return users;
		
		
		
	}

	
  
}
