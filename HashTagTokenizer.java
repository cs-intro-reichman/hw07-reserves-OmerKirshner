

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In("dictionary.txt");
			for(int i = 0; i < 3000; i++){
				dictionary[i] = in.readLine();
			}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String[]dictionary) {
		for(int i = 0; i < 3000; i++){
			if (word.equals(dictionary[i])) {
				return true;
			}
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		String Loweredhash = hashtag.toLowerCase();
		// Base case: do nothing (return) if hashtag is an empty string.
        if (Loweredhash.isEmpty()) return;
        for (int i = 1; i <= Loweredhash.length(); i++) {
			String lowsub = Loweredhash.substring(0, i);
			if (existInDictionary(lowsub, dictionary)) {
				System.out.println(lowsub);
				breakHashTag(Loweredhash.substring(i), dictionary);
				break;
    }
}
	}

}
