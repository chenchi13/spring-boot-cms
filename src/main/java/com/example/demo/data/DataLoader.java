package com.example.demo.data;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.example.demo.model.MainMenu;
import com.example.demo.model.Page;
import com.example.demo.model.Post;
import com.example.demo.model.Role;
import com.example.demo.model.SubMenu;
import com.example.demo.model.User;
import com.example.demo.repository.MainMenuRepository;
import com.example.demo.repository.PageRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.SubMenuRepository;
import com.example.demo.repository.UserRepository;

@Component
public class DataLoader {

	private UserRepository userRepository;
	private PageRepository pageRepository;
	private PostRepository postRepository;
	private MainMenuRepository mainMenuRepository;
	private SubMenuRepository subMenuRepository;
	
	private Page homePage;
	private Page aboutPage;
	private Page contactPage;
	
	private MainMenu mainMenu;

    @Autowired
    public DataLoader(UserRepository userRepo, 
    		PageRepository pageRepo, 
    		PostRepository postRepo, 
    		MainMenuRepository mainMenuRepo, 
    		SubMenuRepository subMenuRepo) {
        this.userRepository = userRepo;
        this.pageRepository = pageRepo;
        this.postRepository = postRepo;
        this.mainMenuRepository = mainMenuRepo;
        this.subMenuRepository = subMenuRepo;
        
        loadData();
    }

    public void loadData() {
    	loadUsers();
        loadPages();
        loadPosts();
        loadMainMenu();
        loadSubMenu();
    }
    
    public void loadUsers() {
        userRepository.save(new User("solujic", "1", true, Arrays.asList(new Role("USER"), new Role("ADMIN"))));
        userRepository.save(new User("admin", "1", true, Arrays.asList(new Role("USER"), new Role("ADMIN"))));
        userRepository.save(new User("korisnik", "1", false, Arrays.asList(new Role("USER"))));
    }
    
	private void loadPages() {
		homePage = new Page("Home", "Greetings this is my home page");
		aboutPage = new Page("About", "This is my about page");
		contactPage = new Page("Contact", "This is my contact page");
		
		pageRepository.save(homePage);
		pageRepository.save(aboutPage);
		pageRepository.save(contactPage);
		
		pageRepository.save(new Page("Page 1", "Page 1"));
		pageRepository.save(new Page("Page 2", "Page 2"));
		pageRepository.save(new Page("Page 3", "Page 3"));
		pageRepository.save(new Page("Page 4", "Page 4"));
	}
	
	private void loadPosts() {
		// Home posts:
    	postRepository.save(new Post("Spring Boot",  // title
    			"Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can just run.", // text 	
    			userRepository.findByUsername("solujic"),  // user
    			pageRepository.findByTitle("Home")));	   // page 

    	postRepository.save(new Post("What is Thymeleaf?", "Thymeleaf is a Java library. It is an XML/XHTML/HTML5 template engine able to apply a set of transformations to template files in order to display data and/or text produced by your applications.\r\n" + 
    			"\r\n" + 
    			"It is better suited for serving XHTML/HTML5 in web applications, but it can process any XML file, be it in web or in standalone applications.\r\n" + 
    			"\r\n" + 
    			"The main goal of Thymeleaf is to provide an elegant and well-formed way of creating templates. In order to achieve this, it is based on XML tags and attributes that define the execution of predefined logic on the DOM (Document Object Model), instead of explicitly writing that logic as code inside the template.\r\n" + 
    			"\r\n" + 
    			"Its architecture allows a fast processing of templates, relying on intelligent caching of parsed files in order to use the least possible amount of I/O operations during execution.\r\n" + 
    			"\r\n" + 
    			"And last but not least, Thymeleaf has been designed from the beginning with XML and Web standards in mind, allowing you to create fully validating templates if that is a need for you.", 
    			userRepository.findByUsername("solujic"), pageRepository.findByTitle("Home")));

    	postRepository.save(new Post("Spring Data", "Spring Data’s mission is to provide a familiar and consistent, Spring-based programming model for data access while still retaining the special traits of the underlying data store. \r\n" + 
    			"\r\n" + 
    			"It makes it easy to use data access technologies, relational and non-relational databases, map-reduce frameworks, and cloud-based data services. This is an umbrella project which contains many subprojects that are specific to a given database. The projects are developed by working together with many of the companies and developers that are behind these exciting technologies.", 
    			userRepository.findByUsername("solujic"), pageRepository.findByTitle("Home")));
    	
    	// About posts:
    	postRepository.save(new Post("About",  
    			"This is a simple Spring Boot CMS web application made by solujic.", 			
    			userRepository.findByUsername("solujic"),  
    			pageRepository.findByTitle("About")));	   
    	
    	// Contact posts:
    	postRepository.save(new Post("Contact Information",  
    			"email: olujic.slaven@gmail.com, solujic@racunarstvo.hr", 			
    			userRepository.findByUsername("solujic"),  
    			pageRepository.findByTitle("Contact")));	   
	}

	private void loadMainMenu() {
		mainMenu = new MainMenu("Home", pageRepository.findByTitle("Home"));
		mainMenuRepository.save(mainMenu);
		mainMenu = new MainMenu("About", pageRepository.findByTitle("About"));
		mainMenuRepository.save(mainMenu);
		mainMenu = new MainMenu("Contact", pageRepository.findByTitle("Contact"));
		mainMenuRepository.save(mainMenu);
	}
	
	private void loadSubMenu() {
		subMenuRepository.save(new SubMenu("Sub Page 1", mainMenuRepository.findByLabel("Home"), pageRepository.findByTitle("Page 1")));
		subMenuRepository.save(new SubMenu("Sub Page 2", mainMenuRepository.findByLabel("Home"), pageRepository.findByTitle("Page 2")));
		subMenuRepository.save(new SubMenu("Sub Page 3", mainMenuRepository.findByLabel("Home"), pageRepository.findByTitle("Page 3")));
		
		subMenuRepository.save(new SubMenu("Sub Page 4", mainMenuRepository.findByLabel("About"), pageRepository.findByTitle("Page 4")));
	}

}
