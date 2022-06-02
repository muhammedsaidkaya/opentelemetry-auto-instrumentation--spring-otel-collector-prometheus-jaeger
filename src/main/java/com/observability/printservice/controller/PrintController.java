package com.observability.printservice.controller;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/print")
@CrossOrigin
@RequiredArgsConstructor
public class PrintController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @PostMapping
    public void print(@RequestBody  String message){
        LOG.info("Getting message: {}", message);
    }
}
