package com.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dao.ProductDao;
import com.dao.TxSellHdrDao;
import com.dto.UserDto;
import com.model.Agen;
import com.model.TxSellHdr;
import com.model.User;
import com.service.AgenService;
//import com.dto.master.MsUserDto;
import com.service.UserService;

@Controller
public class AuthController {
	
	@Autowired
	UserService userService;

	@Autowired
    AgenService agenService;

	@Autowired
	ProductDao productDao;

	@Autowired
	TxSellHdrDao sellHdrDao;


	@GetMapping({ "/", "/login" })
    public String login(){
        return "login";
    }
	
	@GetMapping("/index")
    public String home(){
        return "index";
    }
	
	@PostMapping({"/login" })
   public String loginApp(@ModelAttribute("user") UserDto dto, HttpSession session, Model model){
		
		boolean isValid = false;
		try {
			String email = dto.getEmail();
			String password = dto.getPassword();
			
			User user = userService.findOne(email, password);
			session.setAttribute("email", user.getEmail());
			session.setAttribute("role", user.getRole().toUpperCase());

			isValid = true;
			if(isValid) {
                model.addAttribute("totalAgen", agenService.findAll().size());
                model.addAttribute("totalPendapatan", "Rp. "+getTotalPendapatan(sellHdrDao.findAll()));
                model.addAttribute("totalProduk", productDao.findAll().size());
                model.addAttribute("totalTransaksi", sellHdrDao.findAll().size());
                model.addAttribute("emailUser", user.getEmail());
                model.addAttribute("roleUser", user.getRole().toUpperCase());
                model.addAttribute("listPendapatan", getListTotalPendapatan());
				return "dashboard";			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
       return "login";
		
   }
	
	@GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session){

		try {
                
                model.addAttribute("totalAgen", agenService.findAll().size());
                model.addAttribute("totalPendapatan", "Rp. "+getTotalPendapatan(sellHdrDao.findAll()));
                model.addAttribute("totalProduk", productDao.findAll().size());
                model.addAttribute("totalTransaksi", sellHdrDao.findAll().size());
				model.addAttribute("emailUser", session.getAttribute("email"));
                model.addAttribute("roleUser", session.getAttribute("role"));
				model.addAttribute("listPendapatan", getListTotalPendapatan());


            }catch(Exception e) {
                e.printStackTrace();
            }
        return "dashboard";
    }

	Long getTotalPendapatan(List<TxSellHdr> list){
		Long result = Long.valueOf(0);
		for(int i =0; i < list.size(); i++){
			result = result + Long.valueOf(list.get(i).getTotalPrice());
		}

		return result;
	}

	List<Long> getListTotalPendapatan(){
		List<Long> result = new ArrayList<>();
		String month[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String currentYear = sdf.format(new Date());
		for(int i = 0 ; i < month.length; i++){
			String param = currentYear+"-"+month[i]+"%";
			List<TxSellHdr> list = sellHdrDao.listByMonth(param);
			Long total = Long.valueOf(0);
			if(list.size()>0){
				for(int j = 0; j < list.size(); j++){
					total = total + Long.valueOf(list.get(j).getTotalPrice());
				}
			}
			result.add(total);
		}
		return result;
	}

}
