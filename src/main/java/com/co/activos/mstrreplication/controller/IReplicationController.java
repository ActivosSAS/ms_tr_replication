package com.co.activos.mstrreplication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public interface IReplicationController {


    @GetMapping("/ping")
    String ping();

    @PostMapping("/replicate")
    ResponseEntity<String> replicate();

    @GetMapping("/find")
    ResponseEntity<String> find(@PathVariable("id") String id);

}
