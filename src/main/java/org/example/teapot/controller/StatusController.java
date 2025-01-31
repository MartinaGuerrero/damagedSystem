package org.example.teapot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import org.example.teapot.service.RepairBayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api")
public class StatusController {
    @GetMapping("/repairBay")
    @Operation
    public String repairBay(Model model) throws JsonProcessingException {
        String systemValue= RepairBayService.getSystem("navigation");
        model.addAttribute("system", systemValue);
        return "index";
    }





}


