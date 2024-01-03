package com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;
import com.service.TxSellHdrService;
import com.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService msUserSvc;
	
	@GetMapping({ "/user"})
   public String getData(Model model, HttpSession session){
		try {
			
			List<User> data = msUserSvc.findAll();
	        model.addAttribute("data", data);
			model.addAttribute("emailUser", session.getAttribute("email"));
			model.addAttribute("roleUser", session.getAttribute("role"));
		
		}catch(Exception e) {
			e.printStackTrace();
		}
       return "user";
   }
	
//	@PostMapping({ "/penjualan"})
//    public String getDataInsert(@RequestParam Map<String,Object> map){
//		try {
//			
//			System.out.println("++++++++++++");
//			System.out.println(map.get("customerName").toString());
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//        return "penjualan";
//    }

}
