package com.coding.anagrams;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnagramCheckerResouce {

	@Autowired
	private Anagram anagram;

	@SuppressWarnings("unchecked")
	@RequestMapping("/anagrams/{string1}/{string2}")
	public ResponseEntity<JSONObject> checkAnagrams(@PathVariable(value = "string1") String string1,
			@PathVariable(value = "string2") String string2) {
		JSONObject obj = new JSONObject();
		if (!anagram.validateInputs(string1, string2))
			return new ResponseEntity<JSONObject>(HttpStatus.BAD_REQUEST);

		obj.put("areAnagrams", anagram.checkIfAnagram(string1, string2));
		return new ResponseEntity<JSONObject>(obj, HttpStatus.OK);

	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/anagrams/{string1}")
	public ResponseEntity<JSONObject> getAllAnagrams(@PathVariable(value = "string1") String string1) {
		JSONObject obj = new JSONObject();
		if (!anagram.validateInputs(string1))
			return new ResponseEntity<JSONObject>(HttpStatus.BAD_REQUEST);

		List<String> anagrams = anagram.getAllAnagrams(string1);
		obj.put("Anagrams:", anagrams);
		return new ResponseEntity<JSONObject>(obj, HttpStatus.OK);

	}

}
