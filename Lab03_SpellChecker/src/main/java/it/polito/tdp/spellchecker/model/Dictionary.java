package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {
	List<String> dict = new LinkedList<String>();  	// dictionary of correct words
	
	public void LoadDictionary(String language) {
		try {
			FileReader fr = new FileReader("src/main/resources/" + language + ".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				dict.add(word);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> spellCheckTest(String[] inputText) {
		List<String> wrong = new LinkedList<String>();
		
		for (String w : inputText) {
			if (!dict.contains(w)) {
				wrong.add(w);
			}
		}
		
		return wrong;
	}
	
}
