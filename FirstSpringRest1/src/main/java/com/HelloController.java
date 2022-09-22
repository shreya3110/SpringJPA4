package com;

		import org.springframework.web.bind.annotation.RequestMapping;
		import org.springframework.web.bind.annotation.RestController;

		@RestController
		public class HelloController {

			@RequestMapping 
			public String Hello() {
				System.out.println("Welcome to String Rest");
				return "Welcome to String Rest";
			}
		}

	


