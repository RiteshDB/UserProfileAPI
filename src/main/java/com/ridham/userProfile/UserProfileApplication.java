package com.ridham.userProfile;

import com.ridham.userProfile.dao.UserDao;
import com.ridham.userProfile.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UserProfileApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(UserProfileApplication.class, args);
		System.out.println("Application is running");

		UserDao userDao = context.getBean(UserDao.class);
		User user = new User(1, "Ritesh","Dattatraya", "Bhandari", "20-05-1998", 25, 'M',"NTD");

		User savedUser = userDao.save(user);

		System.out.println(savedUser.toString());

		User user2 = new User(2, "Ritika","Dattatraya", "Bhandari", "15-11-2002", 21, 'F',"NTD");
		savedUser = userDao.save(user2);
		System.out.println(savedUser.toString());
	}

}
