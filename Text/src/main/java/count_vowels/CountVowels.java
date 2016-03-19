package count_vowels;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/*-*
Count Vowels –
Enter a string and the program counts the number of vowels in the text.
For added complexity have it report a sum of each vowel found.
 */
/**
 *
 * @author jingchen
 *
 */
public class CountVowels {

	public static String count(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		str = str.trim().toLowerCase();
		int len = str.length();
		if (len < 2) {
			return str;
		}
		HashMap<Character, Integer> vowel = new HashMap<Character, Integer>();
		vowel.put('a', 0);
		vowel.put('e', 0);
		vowel.put('i', 0);
		vowel.put('o', 0);
		vowel.put('u', 0);

		for (int i = 0; i < len; ++i) {
			char c = str.charAt(i);
			if (vowel.containsKey(c)) {
				vowel.put(c, vowel.get(c) + 1);
			}
		}
		StringBuilder sb = new StringBuilder();
		Set<Entry<Character, Integer>> set = vowel.entrySet();
		for (Entry<Character, Integer> entry : set) {
			sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "commit ai39532o61a6cb6e8caf16ub904f8724odce219af34cc8fa63";
		System.out.println(count(str));
	}

}
/*-----------------------------Output------
a: 5
e: 2
u: 1
i: 2
o: 3
*/