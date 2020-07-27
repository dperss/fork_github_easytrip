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
	private IService<User> servicePerson;
	/*@Autowired
	private IService<Travel> serviceTravel;*/



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=1; i<=10; i++) {


			User user = new User("email@email.com" + i,"password","Diogo Ramos" + i,"teste","https://randomuser.me/api/portraits/med/men/67.jpg");
			//Travel travel= new Travel("origin"+ i,  "destiny",  "01-02-2018",  "01-02-2018",  "accommodation",  "transportation");

			//serviceTravel.saveOrUpdate(travel);
			servicePerson.saveOrUpdate(user);




		}
	}

}

