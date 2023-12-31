package com.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dto.UserDto;
import com.model.Agen;
import com.service.AgenService;
//import com.dto.master.MsUserDto;
import com.service.UserService;

@Controller
public class AuthController {
	
	@Autowired
	UserService userService;

	    @Autowired
    AgenService agenService;


	@GetMapping({ "/", "/login" })
    public String login(){
        return "login";
    }
	
	@GetMapping("/index")
    public String home(){
        return "index";
    }
	
	@PostMapping({"/login" })
   public String loginApp(@ModelAttribute("user") UserDto dto, HttpSession session){
		
		boolean isValid = true;
		// try {
		// 	String username = dto.getUsername();
		// 	String password = dto.getPassword();
			
		// 	MsUserDto dto2 = msUserSvc.findOne(username, password);
			
		// 	if(dto2.getUsername()!=null) {
		// 		isValid = true;
		// 	}
			
		// }catch(Exception e) {
		// 	e.printStackTrace();
		// }
		session.setAttribute("username", dto.getEmail());

		System.out.println("hu "+dto.getEmail());
		if(isValid) {
	        return "dashboard";			
		}
       return "login";
		
   }
	
	@GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session){

		try {
                
                List<Agen> data = agenService.findAll();
                model.addAttribute("totalAgen", data.size());
                
            }catch(Exception e) {
                e.printStackTrace();
            }
        return "dashboard";
    }

}
