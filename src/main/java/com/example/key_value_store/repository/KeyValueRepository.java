package com.example.key_value_store.repository;

import com.example.key_value_store.model.KeyValuePair;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Repository
public class KeyValueRepository {

    private static final String FILE_PATH = "kvstore.txt";
    private final Map<String, KeyValuePair> store = new HashMap<>();

    public synchronized void save(String key, String value, Long ttl) throws IOException {
        if (store.containsKey(key)) {
            throw new IllegalArgumentException("Key already exists");
        }

        KeyValuePair keyValuePair = new KeyValuePair(key, value, ttl != null ? System.currentTimeMillis() + (ttl * 1000) : null);
        store.put(key, keyValuePair);
        writeToFile();
    }

    public synchronized KeyValuePair read(String key) throws IOException {
        KeyValuePair keyValuePair = store.get(key);
        if (keyValuePair == null) {
            throw new IllegalArgumentException("Key not found");
        }

        // Check for TTL expiration
        if (keyValuePair.getTtl() != null && System.currentTimeMillis() > keyValuePair.getTtl()) {
            store.remove(key);
            writeToFile();
            throw new IllegalArgumentException("Key has expired");
        }
        return keyValuePair;
    }

    public synchronized void delete(String key) throws IOException {
        if (!store.containsKey(key)) {
            throw new IllegalArgumentException("Key not found");
        }
        store.remove(key);
        writeToFile();
    }

    private synchronized void writeToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (KeyValuePair keyValuePair : store.values()) {
                writer.write(keyValuePair.getKey() + "=" + keyValuePair.getValue() + "\n");
            }
        }
    }
}
