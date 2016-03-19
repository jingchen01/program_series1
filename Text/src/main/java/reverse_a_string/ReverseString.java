package reverse_a_string;

/*-*
Reverse a String – Enter a string and the program will reverse it and print it out.
 */
public class ReverseString {

	public static String reverse(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		char[] arr = str.toCharArray();
		int start = 0;
		int end = str.length() - 1;
		while (start < end) {
			char c = arr[start];
			arr[start] = arr[end];
			arr[end] = c;
			++start;
			--end;
		}
		return new String(arr);
	}

	public static void main(String[] args) {
		String str = "blank final variable  ";
		System.out.println(reverse(str));
		// elbairav lanif knalb
		System.out.println(reverse("st"));// ts
	}

}
