package com.coding.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Anagram {

	Anagram() {

	}

	private List<String> anagrams;

	public boolean validateInputs(String... input) {

		for (String str : input) {
			if ( StringUtils.isEmpty(str) || str.trim().length() == 0)
				return false;
		}
		return true;
	}

	public boolean checkIfAnagram(String string1, String string2) {

		if (!validateInputs(string1, string2))
			return false;

		char str1[] = string1.toCharArray();
		char str2[] = string2.toCharArray();

		int n1 = str1.length;
		int n2 = str2.length;

		// If length of both strings is not same,
		// then they cannot be anagram
		if (n1 != n2)
			return false;

		// Sort both strings
		Arrays.sort(str1);
		Arrays.sort(str2);

		return Arrays.equals(str1, str2);
	}

	public List<String> getAllAnagrams(String input) {

		if (input == null || input.isEmpty())
			return new ArrayList<String>();
		this.anagrams = new ArrayList<String>();
		createAnagranms("", input);

		return this.anagrams;
	}

	public void createAnagranms(String s1, String s2) {
		if (s2.length() <= 1) {
			this.anagrams.add(s1 + s2);
		} else {
			for (int i = 0; i < s2.length(); i++) {
				String x = s2.substring(i, i + 1);
				String y = s2.substring(0, i);
				String z = s2.substring(i + 1);
				createAnagranms(s1 + x, y + z);
			}
		}
	}

	public List<String> getAnagrams() {
		return anagrams;
	}

}
