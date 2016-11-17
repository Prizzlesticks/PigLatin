		// Program is designed to convert user input to Pig Latin - by RL Prill \\
import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {

		// Initialize scanners and variables
		Scanner entry = new Scanner(System.in);
		Scanner again = new Scanner(System.in);
		String words = (" ");
		String repeat = "yes";
		String comp = " ";
		String sentence = "";
		int i = 0;
		//String sym = "@";
		

		// Welcome User and Explain program also Ask for Input
		System.out.println("Good afternoon, Welcome to the Pig Latin Translator");
		while (repeat.equalsIgnoreCase("yes")) {

			System.out.println("Please enter a Word or Sentence: ");
			words = entry.nextLine();
			int stringCount = count(words);
			

			// Split user entry into an array for translation
			String[] phrase = words.split(" ");

			// If and For to print based on word or phrase
			if (stringCount == 0 && stringCount < 1) {
				System.out.println("Your translation is: " + translate(words)); 
			
			}
			
			while (stringCount > i) {
				//if has symbol return phrase[i] 
				//if (phrase[i].contains(sym));
				//comp = phrase[i];
				//sentence = sentence + " " + comp;
				
				//if (!phrase[i].contains(sym));
				comp = translate(phrase[i]);
				sentence = sentence + " " + comp;
				i++; }
				

				System.out.println("Your translations is:" + sentence); 

				// Ask if user would like to enter again
				System.out.println(
				"Would you like to try another word or phrase? \nType yes to continue or anything else to end: ");
				repeat = again.nextLine();
				i = 0;
				sentence = " ";
			}

			
		// Closing statement and closing the scanners
		System.out.println("Thank you for using the Translator, we hope you had fun!");
		entry.close();
		again.close();
		}

	// method for number of words
	public static int count(String str) {
		int count = 1;
		while (true) {
			str = str.trim();

			int spacePosition = str.indexOf(' ');
			if (spacePosition < 0)
				return count;
			str = str.substring(spacePosition);
			count++;
			System.out.println(str);
		}
	}

	// method for translation
	public static String translate(String word) {
		word = word.toLowerCase();
		String vowels = "aeiouAEIOU";
		String consonant = "";
		int cut = 0;
		
			
		// While loop to find number of consonants, and then cut at the first vowel and add to end
		while (cut < word.length() && !vowels.contains("" + word.charAt(cut))) {
			consonant += word.charAt(cut);
			cut++;
		}

		// If word starts with vowel
		if (cut == 0) {
			word = word + "w";
		}

		// Use cut word concatenate consonant and 'ay'
		word = (word.substring(cut) + consonant + "ay");

		// kick translation back to main
		return word;
	}

}
