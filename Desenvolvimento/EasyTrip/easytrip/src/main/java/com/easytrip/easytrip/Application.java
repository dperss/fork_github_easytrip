package com.easytrip.easytrip;


import com.easytrip.easytrip.domain.User;
import com.easytrip.easytrip.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class Application implements CommandLineRunner {



	@Autowired
	private IService<User> serviceUser;
	/*@Autowired
	private IService<Travel> serviceTravel;*/




	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



			User user = new User(
					"diogo" ,
					"123",
					"Diogo Ramos",
					"teste",
					"https://o7planning.org/templates/o7planning/resources/icons/triceratops.png",
					"ADMIN",
					true,
					true,
					true,
					true
					);

			//Travel travel= new Travel("origin"+ i,  "destiny",  "01-02-2018",  "01-02-2018",  "accommodation",  "transportation");

			//serviceTravel.saveOrUpdate(travel);
			serviceUser.saveOrUpdate(user);





	}

}

