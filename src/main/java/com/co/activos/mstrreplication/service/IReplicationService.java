package com.co.activos.mstrreplication.service;

import com.co.activos.mstrreplication.entities.MyEntity;

public interface IReplicationService {

        MyEntity find(String id);

        boolean replicate();

        void ping();
}
