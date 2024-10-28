package application;

import java.io.*;
import java.util.*;

public class WordMethods {
	
	private static String answer;
	
	public static void generateAnswer() {
		
//		if(answer!=null) {
//			return;
//		}
//		
		ArrayList<String> wordsList = new ArrayList<String>();
		int index;
		
		
		try{
			String word;
			
			File words = new File("src/application/words.txt");
			Scanner fileScanner = new Scanner(words);
			
			while(fileScanner.hasNextLine()) {
				word = fileScanner.nextLine();
				wordsList.add(word);
			}
			
			index = (int)(Math.random()*wordsList.size());

			
			answer = (wordsList.get(index)).toUpperCase();
			fileScanner.close();
			
			
		}catch(java.io.FileNotFoundException e) {
			System.out.println("ERROR: words.txt FILE NOT FOUND!");
		}
	}
	
	public static char[] evaluateWord(String word){
		//generateAnswer();
		
		String capitalizedWord = word.toUpperCase();
		
		char[] characters = capitalizedWord.toCharArray();

		char[] output = new char[5];
		

//		try {
//		    Thread.sleep(1 * 1000);
//		} catch (InterruptedException ie) {
//		    Thread.currentThread().interrupt();
//		}
		
		
		for(int i=0; i<output.length; i++) {
			if(characters[i] == answer.charAt(i)) {
				output[i] = 'C'; //C = correct
			}
			
			else{
				for(int j=0; j<output.length; j++) {
					if(j!=i) {
						//System.out.println(1);
						if(characters[i]==answer.charAt(j)) {
							//System.out.println(2);
							output[i]= 'P'; // P = present but not correct
							//System.out.println(output);
						}
					}
				}
				
				if(output[i]!='P') {
					output[i]='I';
				}
			}
			//System.out.println(output);
		}
		
		return output;
	}
	
	public static String getAnswer() {
		
		return answer;
	}
	
}
