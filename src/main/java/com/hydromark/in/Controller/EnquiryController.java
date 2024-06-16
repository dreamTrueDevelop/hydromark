package com.hydromark.in.Controller;

import com.hydromark.in.DTO.Enquiry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1")
public class EnquiryController {

    @PostMapping("/addEnquiry")
    public ResponseEntity addEnquiry(@RequestBody Enquiry enquiry) {
        return ResponseEntity.ok().build();
    }
}
