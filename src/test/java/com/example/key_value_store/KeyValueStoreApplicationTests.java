package com.example.key_value_store;

import com.example.key_value_store.model.KeyValuePair;
import com.example.key_value_store.service.KeyValueService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KeyValueStoreApplicationTests {

	@Autowired
	private KeyValueService keyValueService;

	@Test
	void testCreateAndReadKeyValue() {
		String key = "testKey";
		String value = "testValue";

		String result = keyValueService.create(key, value, null);
		assertEquals("Key-Value pair created successfully!", result);

		KeyValuePair keyValuePair = keyValueService.read(key);
		assertEquals(value, keyValuePair.getValue());
	}

	@Test
	void testDeleteKeyValue() {
		String key = "deleteKey";
		String value = "deleteValue";

		keyValueService.create(key, value, null);
		String deleteResult = keyValueService.delete(key);
		assertEquals("Key-Value pair deleted successfully!", deleteResult);
	}
}
