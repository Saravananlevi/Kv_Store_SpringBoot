package com.example.key_value_store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyValuePair {
    private String key;
    private String value;
    private Long ttl; // Time-to-Live in seconds (Optional)
}
