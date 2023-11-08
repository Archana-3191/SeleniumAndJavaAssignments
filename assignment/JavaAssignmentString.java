package week4.assignment;

public class JavaAssignmentString {

	
		 public static void main(String[] args) {
		        String s1 = "Hello World";
		        System.out.println("In First String, Length Of The Last Word :"+lengthOfLastWord(s1));  // Output:5

		        String s2 = "   fly me   to   the moon  ";
		        System.out.println("In Second String, Length Of The Last Word :"+lengthOfLastWord(s2));  // Output: 4

		        String s3 = "luffy is still joyboy";
		        System.out.println("In Third String, Length Of The Last Word :"+lengthOfLastWord(s3));  // Output: 6
		    }

		    public static int lengthOfLastWord(String s) {
		        // Split the input string by spaces and remove any leading/trailing spaces.
		        String[] words = s.trim().split(" ");

		        // If there are no words, return 0.
		        if (words.length == 0) {
		            return 0;
		        }

		        // Get the last word and return its length.
		        String lastWord = words[words.length - 1];
		        return lastWord.length();
		    }
		}



	


