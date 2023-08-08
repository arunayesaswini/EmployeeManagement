package com.greatlearning.EmployeeManagementApi.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {
	// Handling Error Page
		@RequestMapping("/403")
		public String accessDenied1(Principal user) {
			if (user != null) {
				return user.getName() + " You donot have permission to access this page";
			} else
				return "You donot have permission to access this page";
		}
		
		@RequestMapping("/404")
		public String accessDenied2(Principal user) {
			if (user != null) {
				return user.getName() + " Page Not found";
			} else
				return "Page Not Found";
		}

		@RequestMapping("/500")
		public String accessDenied3(Principal user) {
			if (user != null) {
				return user.getName() + " You donot have permission to access this page";
			} else
				return "You donot have permission to access this page";
		}
		

}
