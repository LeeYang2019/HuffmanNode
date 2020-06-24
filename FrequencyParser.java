///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (Huffman.java)
// File:             (FrequencyParser.java)
// Semester:         (Introduction to Data Structures) Fall 2016
//
// Author:           (Nhialee Yang nyang5@wisc.edu)
// CS Login:         (nhialee)
// Lecturer's Name:  (Alexander Brooks)
// Lab Section:      (N/A)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     (Yia Xiong)
// Email:            (yxiong58@wisc.edu)
// CS Login:         (yia)
// Lecturer's Name:  (Alexander Brooks)
// Lab Section:      (N/A)
//
//////////////////////////// 80 columns wide //////////////////////////////////
import java.io.*;
import java.util.*;

public class FrequencyParser{
	/**
	 * This method takes a text file containing ASCII characters only and
	 * returns an int array of length 128 which counts the occurrences of each
	 * character.  
	 * 
	 * The entry at index i is the count of the character with ASCII
	 * value i 'Start of Heading' (ASCII value 1) and null character (ASCII
	 * value 0) should both have count 0.
	 * 
	 * @param file 
	 *  the name of the file containing the mapping from symbols to codes
	 * 
	 * @return the array of frequencies of each character
	 * 
	 * @throws FileNotFoundException 
	 *  if the file does not exist
	 */
	public static int[] getFrequencies(String file) throws FileNotFoundException
	{
		// TODO
		//create a scanner to read in the file
		Scanner input = new Scanner(new File(file));
		
		//array size 128 to count frequency of each character
		int [] frequency = new int [128];
		String string = "";

		//read each line of the file
		while (input.hasNextLine())
		{
			frequency[10] = frequency[10] +1; //increase next line by 1 each time nextLine is called
			
			string = input.nextLine(); //stores the line
			
			char character;
			int asciiVal;

			//loop through the line stored 
			for (int i = 0; i < string.length(); i++)
			{
				//obtain each character in the line and get its ascii value
				character = string.charAt(i);
				asciiVal = (int) character;
				
				//increment the position of a character's ascii value by 1
				frequency[asciiVal] = frequency[asciiVal] + 1;
			}
		}
		//close scanner
		input.close();

		//return the frequency
		return frequency;
	}
}
