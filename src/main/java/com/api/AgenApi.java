package com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.GenerateUUID;
import com.common.ResponseHandler;
import com.dto.AgenDto;
import com.model.Agen;
import com.service.AgenService;

@RestController
@RequestMapping("/api")
public class AgenApi {

    @Autowired
    AgenService agenService;

    @GetMapping("/agen/get-no-user")
    public ResponseEntity<Object> findAllWithNoUser(){
        List<Agen> list = agenService.findAllWithNoUser();

        return ResponseHandler.generateResponse("success", HttpStatus.OK, list);
    }

    @PostMapping(value= "/agen/save")
    public String deleteAgen(@RequestBody AgenDto dto){
            try {
                
                System.out.println("++++++++++++");
                System.out.println(dto.getNama());
                System.out.println(dto.getAlamat());
                System.out.println(dto.getStatus());
                System.out.println(dto.getTglPendaftaran());
                System.out.println(dto.getEmail());
                System.out.println("++++++++++++");
                if(dto.getId()==null){
                    dto.setId(new GenerateUUID().generateUuid());
                }
                agenService.save(dto);
                
            }catch(Exception e) {
                e.printStackTrace();
            }
        return "agen";
    }

    @PostMapping(value= "/agen/delete/{id}")
    public String deleteAgen(@PathVariable("id") String id){
            try {
                
                System.out.println("++++++++++++");
                System.out.println(id);
                System.out.println("++++++++++++");
                agenService.deleteById(id);
                
            }catch(Exception e) {
                e.printStackTrace();
            }
        return "agen";
    }
    
}
