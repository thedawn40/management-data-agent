package com.controller;

import java.util.List;

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
    public String getData(Model model){
            try {
                
                List<Agen> data = agenService.findAll();
                model.addAttribute("data", data);
                
            }catch(Exception e) {
                e.printStackTrace();
            }
        return "agen";
    }
}