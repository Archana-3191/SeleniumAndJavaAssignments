package week4.assignment;

public class ReverseOddWordsInAString {

	public static void main(String[] args) {
		
		    
		        String test = "I am a software tester";
		        String[] words = test.split(" ");
		        
		        for (int i = 0; i < words.length; i++) {
		            if (i % 2 == 1) {
		                words[i] = reverseWord(words[i]);
		            }
		        }
		        
		        StringBuilder result = new StringBuilder();
		        for (String word : words) {
		            result.append(word).append(" ");
		        }
		        
		        System.out.println("Final Result :"+result.toString().trim());
		    }

		    public static String reverseWord(String word) {
		        char[] charArray = word.toCharArray();
		        int left = 0;
		        int right = charArray.length - 1;

		        while (left < right) {
		            char temp = charArray[left];
		            charArray[left] = charArray[right];
		            charArray[right] = temp;
		            left++;
		            right--;
		        }

		        return new String(charArray);
		    }
		}
	


