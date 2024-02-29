package com.FTI.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.FTI.App.models.User;
import com.FTI.App.repositories.UserRepository;

@SpringBootApplication
public class AppApplication implements CommandLineRunner{

	private final UserRepository userRepository;

	@Autowired
	public AppApplication(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		
		if(userRepository.findAll().isEmpty()){

			userRepository.save(new User("Alice","Smith"));
			userRepository.save(new User("Bob","Smith"));
		}

		for(User user : userRepository.findAll()){
			System.out.println(user);
		}
	}
 }
