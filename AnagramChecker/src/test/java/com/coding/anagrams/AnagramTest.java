package com.coding.anagrams;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

class AnagramTest {

	private Anagram anagram = new Anagram();

	@Test
	void testValidateInputs() {
		assertEquals(true, anagram.validateInputs("dog", "god"));
		assertEquals(false, anagram.validateInputs("dog", " "));
	}

	@Test
	void testCheckIfAnagram() {
		assertEquals(true, anagram.checkIfAnagram("dog", "god"));
		assertEquals(false, anagram.checkIfAnagram("dog", "cat"));
		
	}

	@Test
	void testGetAllAnagrams() {
		String arr[] = new String[]{"dog","dgo","odg","ogd","gdo","god"};
		List<Object> output = Arrays.asList(arr);
		assertEquals(output, anagram.getAllAnagrams("dog"));
	}

}
