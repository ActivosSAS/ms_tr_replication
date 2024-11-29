package com.co.activos.mstrreplication.repository;

import com.co.activos.mstrreplication.entities.MyEntity;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ExecutionException;

@Repository

public class FirestoreRepository {


    private final Firestore firestore;

    public FirestoreRepository(Firestore firestore) {
        this.firestore = firestore;
    }

    private static final  String COLLECTION_NAME = "AbilityLevels";  // Nombre de la colección en Firestore

    /**
     * Guarda o actualiza una entidad en Firestore
     */
    public String save(MyEntity x) throws InterruptedException, ExecutionException {
        DocumentReference docRef = firestore.collection(COLLECTION_NAME).document(x.getId());
        WriteResult result = docRef.set(x).get();  // Guarda o actualiza el documento
        return result.getUpdateTime().toString();  // Retorna la hora de la última actualización
    }

    /**
     * Encuentra una entidad por su ID
     */
    public MyEntity findById(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = firestore.collection(COLLECTION_NAME).document(id);
        DocumentSnapshot snapshot = docRef.get().get();

        // Si el documento existe, mapea el snapshot a la entidad
        if (snapshot.exists()) {
            return snapshot.toObject(MyEntity.class);
        } else {
            return null;  // Si el documento no existe, retorna null
        }
    }

    /**
     * Elimina un documento por su ID
     */
    public void delete(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = firestore.collection(COLLECTION_NAME).document(id);
        docRef.delete().get();  // Elimina el documento
    }
}
