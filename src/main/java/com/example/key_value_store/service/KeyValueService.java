package com.example.key_value_store.service;

import com.example.key_value_store.model.KeyValuePair;
import com.example.key_value_store.repository.KeyValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KeyValueService {

    @Autowired
    private KeyValueRepository keyValueRepository;

    public String create(String key, String value, Long ttl) {
        try {
            keyValueRepository.save(key, value, ttl);
            return "Key-Value pair created successfully!";
        } catch (IOException e) {
            return "Failed to create Key-Value pair!";
        }
    }

    public KeyValuePair read(String key) {
        try {
            return keyValueRepository.read(key);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read Key-Value pair!");
        }
    }

    public String delete(String key) {
        try {
            keyValueRepository.delete(key);
            return "Key-Value pair deleted successfully!";
        } catch (IOException e) {
            return "Failed to delete Key-Value pair!";
        }
    }
}
