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
		
		StringBuilder builder = new StringBuilder();

		//Remove whitespace from key and message
		key = key.replaceAll("\\s", "");
		message = message.replaceAll("\\s", "");
		
		//Get the number of times the key length divides into the message length evenly
		int even = message.length() / key.length();
		Math.abs(even);
		    	
		//Get the remainder
		int remainder = (message.length() % key.length());
					
		    if(key.length() <= message.length()) {
		        for(int i=0;i<even;i++) {
		          
		            //The length of the key if there is a remainder
		            leftOver = key.substring(0, remainder);
		            
		            //If the key goes into the message evenly n times, simply create a new string of the key
		            //repeating n times
		            builder.append(key);
		     }
		            	
		     convertedMessage = builder.toString();
		      
		    //If the key does not go into the message evenly, concatenate the remainder of 
		    // the key onto the end of the message
		    if(remainder != 0) {
		       convertedMessage += leftOver;
		    }
		            	
		      System.out.println(convertedMessage + " " + message.length() + " " + key.length());
	    }
		return convertedMessage;
	}
	

	//Take in two Strings and add their numeric values together 
	public static int[] messageToNumbers(String messageOne, String messageTwo) {

		//Create empty int array that is the same length as your message
		int[] messageInNumbers = new int[messageOne.length()];
		
		//Convert both messages to char arrays
		char[] messageOneArray = messageOne.toCharArray();
		char[] messageTwoArray = messageTwo.toCharArray();
		
		for(int i=0; i<messageOneArray.length - 1; i++) {
			
			//Convert each array to its corresponding numbers, 
			// one char at a time
			int messageOneValue = toNumber(messageOneArray[i]);
			int messageTwoValue = toNumber(messageTwoArray[i]);
			int newValue = messageOneValue + messageTwoValue;
			//TODO: handle what happens when you get a number that is bigger than 25 (i.e z + y)
			
			System.out.println(messageTwoValue);
			//Place the new values in an array of ints
			messageInNumbers[i] = newValue;
		}
		System.out.println(Arrays.toString(messageInNumbers));
		return messageInNumbers;
	}
	

	public static void encrypt() 
	{ 
		//Separate key and message in user input
		String[] userInput = getUserInput();
		
		//We know the key is the first element of the array
		String key = userInput[0];
		String message = userInput[1];
        
		char[] encryptedMessage = new char[message.length()];
		//Repeat the key over the message
		String newMessage =  repeatKeyOverMessage(key, message);
		
		
		int[] messageInNumbers = messageToNumbers(message, newMessage);
		
		for(int i=0; i<messageInNumbers.length; i++) {
			encryptedMessage[i] = toLetter(messageInNumbers[i]);
		}
		
		System.out.println(encryptedMessage);
	}
	

   public static void main(String[] args) {

         encrypt();
	     } 
}
