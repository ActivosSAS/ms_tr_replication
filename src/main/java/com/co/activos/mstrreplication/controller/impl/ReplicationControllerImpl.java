package com.co.activos.mstrreplication.controller.impl;

import com.co.activos.mstrreplication.entities.MyEntity;
import com.co.activos.mstrreplication.service.IReplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReplicationControllerImpl {

    private final IReplicationService replicationService;

    public ReplicationControllerImpl(IReplicationService replicationService) {
        this.replicationService = replicationService;
    }

    @GetMapping
    public String ping() {
        return "pong";
    }

    public ResponseEntity<String> replicate() {
        return ResponseEntity.ok("Replication done");
    }


    @GetMapping("/find")
    public ResponseEntity<MyEntity> find(@RequestParam String id) {
        MyEntity myEntity = replicationService.find(id);
        return ResponseEntity.ok(myEntity);
    }
}
