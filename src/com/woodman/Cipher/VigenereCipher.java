package com.woodman.Cipher;

import java.util.Arrays;
import java.util.Scanner;

public class VigenereCipher {

	private static boolean isLetter(char c)
	{   
	
	return ((c >= 'a' && c <= 'z') || (c >='A' && c <= 'Z'));

		
	}
	
   
	//gets the numerical value of a char's position in the alphabet using ASCII values
	private static int toNumber(char c)
	{
		int i = (int)c;
		if( i >= 96) //if uppercase, make lowercase by subtracting 97
		{
			i -= 97;
		}		
		else
		{
			i-=65;
		}
		
		return i;
		
	}
	private static char toLetter(int i)
	{
		return (char)((i % 26) + 97);
	}
	
	
	   //Get keyword and message from the user
		public static String[] getUserInput() {
			
			//Array to hold my key and message
			String[] userInput = new String[2];
			
			System.out.println("Enter a word");
			String key = "";
			Scanner scanner = new Scanner(System.in); 
			while(scanner.hasNextLine()) {
			 String input = scanner.nextLine();
			 key = input;
			 userInput[0] = key;
			 break;
			}
			
		
			System.out.println("Enter a message");
			String message = "";
			while(scanner.hasNextLine()) {
		    String input = scanner.nextLine();
		    message = input;
		    
		    userInput[1] = message;
		    break;
			}
			scanner.close();
            System.out.println(Arrays.toString(userInput));
			return userInput;
		}
		
    //Converts the message to a series of the key repeating		
	public static String repeatKeyOverMessage(String key, String message) {
		String convertedMessage = "";
		String leftOver = "";
		
		//String manipulation begin
		StringBuilder builder = new StringBuilder();

		//Get the number of times the key length divides into the message length evenly
		int even = message.length() / key.length();
		Math.abs(even);
		    	
		//Get the remainder
		int remainder = (message.length() % key.length());
					
		    if(key.length() < message.length()) {
		        for(int i=0;i<even;i++) {
		            even = message.length() / key.length();
		            
		            remainder = (message.length() % key.length());
		            leftOver = key.substring(0, remainder);
		            builder.append(key);
		     }
		            	
		     convertedMessage = builder.toString();
		            	
		    if(remainder != 0) {
		       convertedMessage += leftOver;
		    }
		            	
		      System.out.println(convertedMessage + " " + message.length() + " " + key.length());
	    }
		return convertedMessage;
	}
	
	
	//takes in an array of Strings and gets numeric value of the first letter of each String, adds them together
	public static int keyAndMessageToNumber(String words[]) {
		
		int numValue = 0;
		int numValuez = 0;
		int numValuea =0;
		for(int i=0; i<words.length - 1; i++) {

        numValuea = toNumber(words[i].charAt(0));
        numValuez = toNumber(words[i+1].charAt(0));
        numValue = numValuea + numValuez;
        System.out.println("value 1: " + numValuea + " value 2: " + numValuez);
		}
		
		numValue = numValuea + numValuez;
		System.out.println(numValue);
		return numValue;
	}
	
	
	//takes a key and a message and generates a new letter
	public static char generateNewLetter() {
        String[] message = new String[2];
        message = getUserInput();
        
        int textNumericValue = keyAndMessageToNumber(message);
		System.out.println("Key and message: " + Arrays.toString(message) + " Numerical value: " + textNumericValue);
		
		char newLetter = toLetter(textNumericValue);
		System.out.println(newLetter + "new letter's number: " + toNumber(newLetter));
		return newLetter;
	}
	
	public static void encrypt(String key, String message) 
	{ 
		//Separate key and message in user input
		String[] userInput = getUserInput();
		
		//We know the key is the first element of the array
		key = userInput[0];
		message = userInput[1];
        
		//Repeat the key over the message
		repeatKeyOverMessage(key, message);
	}
	

   public static void main(String[] args) {
         String key = "";
         String message = "";
         encrypt(key, message);
	     } 
}
