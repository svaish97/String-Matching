import java.util.*;

public class finiteAutomata {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String text, pattern;
		System.out.println("Enter text");
		text = s.next();
		System.out.println("Enter pattern");
		pattern = s.next();
		search(text, pattern);

	}

	private static void search(String text, String pattern) {
		int fT[][] = new int[pattern.length() + 1][256];
		finiteAutomataTable(pattern, fT);
		int state = 0;
		for (int i = 0; i < text.length(); i++) {
			state = fT[state][text.charAt(i)];
			if (state == pattern.length()) {
				System.out.println("Pattern found at " + (i - pattern.length() + 1));
			}
		}

	}

	private static void finiteAutomataTable(String pattern, int[][] fT) {
		for (int i = 0; i <= pattern.length(); i++) {
			for (int j = 0; j < 256; j++) {
				fT[i][j] = getNextState(pattern, i, j);
			}
		}
	}

	private static int getNextState(String pattern, int i, int j) {
		if (i < pattern.length() && j == pattern.charAt(i)) {
			return i + 1;
		}
		for (int ns = i; ns > 0; ns--) {
			if (pattern.charAt(ns - 1) == i) {

				for (int k = 0; k < ns - 1; k++) {
					if (pattern.charAt(i) != pattern.charAt(i - ns + 1 + k))
						break;
					if (k == ns - 1)
						return ns;
				}

			}
		}
		return 0;
	}

}
