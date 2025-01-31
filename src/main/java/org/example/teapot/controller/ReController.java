package org.example.teapot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.teapot.exceptions.StatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReController {
    String damaged = "navigation";

    @GetMapping("/status")
    @Tag(name = "tutorials")
    @Tag(name = "GET")
    @Operation(
            summary = "Get Status",
            description = "This endpoint gets the damaged system status"
    )
    public Map<String, String> status() {
        Map<String, String> response = new HashMap<>();
        response.put("damaged_system", damaged);
        if (response.isEmpty()) {
            throw new StatusException("Empty damaged system");
        }
        return response;
    }

    @GetMapping("/update")
    @SecurityRequirement(name = "basicAuth")
    @Tag(name = "tutorials")
    @Tag(name = "GET")
    @Operation(
            summary = "Update",
            description = "This endpoint updates the system"
    )
    public Map<String, String> Ustatus() {
        damaged = "communications";
        Map<String, String> response = new HashMap<>();
        response.put("damaged_system", damaged);
        return response;

    }

    @GetMapping("/teapot")
    public ResponseEntity<String> teapot() {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }


}