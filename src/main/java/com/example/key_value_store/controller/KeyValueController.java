package com.example.key_value_store.controller;

import com.example.key_value_store.model.KeyValuePair;
import com.example.key_value_store.service.KeyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kvstore")
public class KeyValueController {

    @Autowired
    private KeyValueService keyValueService;

    @PostMapping("/create")
    public String createKeyValue(@RequestParam String key, @RequestParam String value, @RequestParam(required = false) Long ttl) {
        return keyValueService.create(key, value, ttl);
    }

    @GetMapping("/read/{key}")
    public KeyValuePair readKeyValue(@PathVariable String key) {
        return keyValueService.read(key);
    }

    @DeleteMapping("/delete/{key}")
    public String deleteKeyValue(@PathVariable String key) {
        return keyValueService.delete(key);
    }
}
