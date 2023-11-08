package week4.assignment;

public class StringToCharArray {

	 public static void main(String[] args) {
	        String test = "changeme";
	        //Convert the given String to a character array
	        char[] charArray = test.toCharArray();
//Implement a loop to iterate through each character of the String (from end to start)
	        for (int i = charArray.length - 1; i >= 0; i--) {
	            if (i % 2 == 1)//Find the odd index within the loop

	            	
	            {
	                charArray[i] = Character.toUpperCase(charArray[i]);
	                //Inside the loop, change the character to uppercase only if the index is odd
	            }
	        }

	        String result = new String(charArray);
	        System.out.println("Expected Result:"+result);  // Print the characters with the expected output: cHaNgEmE
	    }
	
		

	}


