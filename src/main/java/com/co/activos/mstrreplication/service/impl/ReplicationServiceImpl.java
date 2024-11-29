package com.co.activos.mstrreplication.service.impl;

import com.co.activos.mstrreplication.entities.MyEntity;
import com.co.activos.mstrreplication.repository.FirestoreRepository;
import com.co.activos.mstrreplication.service.IReplicationService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ReplicationServiceImpl implements IReplicationService {

    private final FirestoreRepository firestoreRepository;

    public ReplicationServiceImpl(FirestoreRepository firestoreRepository) {
        this.firestoreRepository = firestoreRepository;
    }

    @Override
    public MyEntity find(String id) {
        try {
            return firestoreRepository.findById(id);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean replicate() {
        return true;
    }

    @Override
    public void ping() {
        System.out.println("pong");
    }
}
