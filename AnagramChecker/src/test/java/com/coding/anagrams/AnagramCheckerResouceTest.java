package com.coding.anagrams;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith( SpringRunner.class )
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class AnagramCheckerResouceTest {

	
	@Autowired
	private TestRestTemplate template;

	
	
	@Test
	void testCheckAnagrams() {
		ResponseEntity<JSONObject> response = template.getForEntity( "/anagrams/dog/god", JSONObject.class );
		assertThat( response.getStatusCode().equals( HttpStatus.OK ) );
		assertThat( response.getBody().containsValue(true) );
		
		ResponseEntity<JSONObject> response2 = template.getForEntity( "/anagrams/dog/cat", JSONObject.class );
		assertThat( response2.getStatusCode().equals( HttpStatus.OK ) );
		assertThat( response2.getBody().containsValue(false) );

		ResponseEntity<JSONObject> response3 = template.getForEntity( "/anagrams/dog/ ", JSONObject.class );
		assertThat( response3.getStatusCode().equals( HttpStatus.BAD_REQUEST ) );
		
	}

	@Test
	void testGetAllAnagrams() {

		String arr[] = new String[]{"dog","dgo","odg","ogd","gdo","god"};
		List<Object> output = Arrays.asList(arr);
		
		ResponseEntity<JSONObject> response = template.getForEntity( "/anagrams/dog", JSONObject.class );
		assertThat( response.getStatusCode().equals( HttpStatus.OK ) );
		assertThat( response.getBody().toJSONString().equals(output));
		
		ResponseEntity<JSONObject> response3 = template.getForEntity( "/anagrams/ ", JSONObject.class );
		assertThat( response3.getStatusCode().equals( HttpStatus.BAD_REQUEST ) );
	}

}
