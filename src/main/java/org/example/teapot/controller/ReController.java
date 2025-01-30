package org.example.teapot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReController {
String damaged="navigation";

    @GetMapping("/status")
    public Map<String, String> status() {
        try {
            Map<String, String> response = new HashMap<>();
            response.put("damaged_system", damaged);
            return response;
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("There is no damaged system"," "+ e.getMessage());
            return errorResponse;
        }

    }

    @GetMapping("/update")
    public Map<String, String> Ustatus(){
        try {
            damaged="communications";
            Map <String, String> response= new HashMap<>();
            response.put("damaged_system", damaged);
            return response;
        }catch (Exception e){
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("damaged system has not been changed", " " + e.getMessage());
            return errorResponse;
        }


    }


}
