package week4.assignment;

public class RemoveDuplicates {

	public static void main(String[] args) {
		 String text = "We learn Java basics as part of java sessions in java week1";
	        String[] words = text.split(" ");
	        int count = 0;

	        for (int i = 0; i < words.length; i++) {
	            for (int j = i + 1; j < words.length; j++) {
	                if (words[i].equalsIgnoreCase(words[j]) && !words[i].equals("")) {
	                    words[j] = "";
	                    count++;
	                  }
	                 }	
	               }

	        if (count > 0) {
	            StringBuilder result = new StringBuilder();
	            for (String word : words) {
	                if (!word.isEmpty()) {
	                    result.append(word).append(" ");
	                }
	             }

	            // Remove the trailing space and print the modified text
	            System.out.println(result.toString().trim());
	        } else {
	            System.out.println(text);
	           }
	      }
	

	 }


