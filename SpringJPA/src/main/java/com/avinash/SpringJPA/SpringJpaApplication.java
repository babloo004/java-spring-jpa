package com.avinash.SpringJPA;

import com.avinash.SpringJPA.model.Student;
import com.avinash.SpringJPA.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//SpringJPA stands for the Java Persistence API.
//SpringJPA makes our work easy in interacting with the database
//main reason in using the JPA is even if we change our database manager later, there is no need to change the much code
//we don't write queries by ourselves
// we just define methods in the repository in Domain Specific Language(DSL)
//remaining work will be done by the JPA
//in JPA we call the model as Entity
//to link our Entity with table in(mapping) we use Annotation @Entity above our model
//we will use the JPA in the Repository layer
//more details in the StudentRepo

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		System.out.println("Working...!");

		//creating Student object
		ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
		Student s1 = context.getBean(Student.class);
		s1.setRoll(322250);
		s1.setFname("Rajesh");
		s1.setLname("Mannepalli");
		s1.setMarks(77);

		//creating StudentRepo object
		StudentRepo repo = context.getBean(StudentRepo.class);

		//repo.save(s1);
//		System.out.println(repo.findAll());
		System.out.println(repo.findByfname("Avinash"));
		System.out.println(repo.findBymarks(95));
	}


}
