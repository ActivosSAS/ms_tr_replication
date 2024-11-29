package com.co.activos.mstrreplication.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;


@Configuration
public class FirestoreConfig {

    @Bean
    public Firestore firestore() throws IOException, NoSuchAlgorithmException, KeyManagementException {

        SSLUtil.disableSSLVerification();
        // Ruta al archivo de credenciales descargado desde la consola de Firebase
        InputStream serviceAccount = new ClassPathResource("serviceAccountKey.json").getInputStream();

        // Configura las credenciales para Google Cloud
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);

        // Configura Firestore con las credenciales
        FirestoreOptions firestoreOptions = FirestoreOptions.newBuilder()
                .setCredentials(credentials)
                .build();

        // Devuelve la instancia de Firestore
        return firestoreOptions.getService();
    }
}
