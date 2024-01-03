package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.model.Agen;
import com.model.User;
import com.service.AgenService;

/**
 * AgenController
 */
@Controller
public class AgenController {

    @Autowired
    AgenService agenService;

    @GetMapping({ "/agen"})
    public String getData(Model model, HttpSession session){
            try {
                
                List<Agen> data = agenService.findAll();
                model.addAttribute("data", data);
				model.addAttribute("emailUser", session.getAttribute("email"));
                model.addAttribute("roleUser", session.getAttribute("role"));
                
            }catch(Exception e) {
                e.printStackTrace();
            }
        return "agen";
    }
}