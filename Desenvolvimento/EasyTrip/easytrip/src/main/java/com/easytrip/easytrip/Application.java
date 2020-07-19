package com.easytrip.easytrip;



import com.easytrip.easytrip.domain.Person;
import com.easytrip.easytrip.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {



	@Autowired
	private IService<Person> servicePerson;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=1; i<=10; i++) {


			Person person = new Person("email@email.com" + i,"password","Diogo Ramos" + i,"teste",1,2);

			servicePerson.saveOrUpdate(person);



		}
	}

}

