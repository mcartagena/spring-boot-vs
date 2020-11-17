package com.loc8r.accessingdatamongodb;

import com.loc8r.accessingdatamongodb.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner{

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
    repository.save(new User("Marcelo Cartagena", "marcecarta@hotmail.com"));
		repository.save(new User("Leonor Cartagena", "marcelocartagenaorellana@gmail.com"));
		
		// fetch all users
		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");
		
		for (User user : repository.findAll()) {
      System.out.println(user);
    }
    System.out.println();

    // fetch an individual user
    System.out.println("User found with findByEmail('marcecarta@hotmail.com'):");
    System.out.println("--------------------------------");
		System.out.println(repository.findByEmail("marcecarta@hotmail.com"));
		System.out.println();

    System.out.println("Users found with findByName('Marcelo Cartagena'):");
    System.out.println("--------------------------------");
    for (User user : repository.findByName("Marcelo Cartagena")) {
      System.out.println(user);
    }
		System.out.println();

    System.out.println("Users found with findByNameEndingWith('Cartagena'):");
    System.out.println("--------------------------------");
    for (User user : repository.findByNameEndingWith("Cartagena")) {
      System.out.println(user);
    }

	}

}
