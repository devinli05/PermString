import java.util.ArrayList;

public class PermString {
	public static ArrayList<String> getPerms(String s) {
		ArrayList<String> permutations = new ArrayList<String>();
		if (s == null)
			return null;
		if (s == "") {
			permutations.add("");
			return permutations;
		}
			
		char first = s.charAt(0);
		String reminder = s.substring(1);
		ArrayList<String> words = getPerms(reminder);
		for (String word: words) {
			for (int j=0; j<=word.length(); j++) {
				permutations.add(inserCharBefore(word,first,j));
			}
		}
		
		return permutations;
		
	}

	private static String inserCharBefore(String word, char first, int j) {
		String start = word.substring(0, j);
		String end = word.substring(j);
		return start + first + end;
	}
	
	public static void main(String [] args) {
		String input = args[0];
		ArrayList<String> output = getPerms(input);
		
		for(String word: output) {
			System.out.println(word);
		}
	}

}
