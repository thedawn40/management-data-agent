package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.model.Agen;
import com.service.AgenService;

@Controller
public class DashboardController {

    @Autowired
    AgenService agenService;

    // @GetMapping({ "/dashboard"})
    // public String getData(Model model){
    //         try {
                
    //             List<Agen> data = agenService.findAll();
    //             model.addAttribute("totalAgen", data.size());
                
    //         }catch(Exception e) {
    //             e.printStackTrace();
    //         }
    //     return "dashboard";
    // }
    
}
