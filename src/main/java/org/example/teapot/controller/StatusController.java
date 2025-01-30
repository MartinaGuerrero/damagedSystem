package org.example.teapot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletResponse;
import org.example.teapot.service.RepairBayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@RequestMapping("/api")
public class StatusController {

    @GetMapping("/repareBay")
    public String repareBay(Model model) throws JsonProcessingException {
    String systemValue= RepairBayService.getSystem("navigation");
    model.addAttribute("system", systemValue);
    return "index";
    }

    @GetMapping("/teapot")
    public ResponseEntity<String> teapot() {
        return new ResponseEntity<>( HttpStatus.I_AM_A_TEAPOT);
    }



}


