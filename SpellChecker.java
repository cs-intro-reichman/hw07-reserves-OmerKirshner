
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		String tail = str.substring(1);
		return tail;
	}

	public static int levenshtein(String word1, String word2) {
		String lowWord1 = word1.toLowerCase();
		String lowWord2 = word2.toLowerCase();
		if (lowWord2.length() == 0)
			return lowWord1.length();
		if (lowWord1.length() == 0)
			return lowWord2.length();
		if (lowWord1.charAt(0) == lowWord2.charAt(0))
			return levenshtein(tail(lowWord1),tail(lowWord2));
		else
		return 1 + (Math.min(Math.min(levenshtein(tail(lowWord1), lowWord2),levenshtein(lowWord1,tail(lowWord2))),levenshtein(tail(lowWord1),tail(lowWord2))));
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In("dictionary.txt");
			for(int i = 0; i < 3000; i++){
				dictionary[i] = in.readLine();
			}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		int mnmlT = 100;
		word = word.toLowerCase();
		String match = word;
		for (int i = 0;i < dictionary.length; i++){
			if (levenshtein(dictionary[i], word) < mnmlT && levenshtein(dictionary[i], word) <= threshold) {
				match = dictionary[i];
				mnmlT = levenshtein(dictionary[i], word);
			}
		}
	return match;
	}
	
}
