package string;

public class Panagram {
	public static void main(String[] args) {
		String s = "The Quick brown fox jumps A LAzy DOG";
		s = s.toLowerCase();
		int count = 0;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (s.indexOf(ch) >= 0) {
				count++;
			} else {
				break;
			}
		}
		System.out.println(count);
		System.out.println(count == 26 ? "Panagram." : "Not a panagram.");
	}
}
