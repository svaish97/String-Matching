
public class wildCardPatternMatching {
	public static void main(String[] args) {
		System.out.println(matchstring("xaylmz", "x?y*z"));

	}

	private static boolean matchstring(String string, String string2) {
		boolean T[][] = new boolean[string.length() + 1][string2.length() + 1];
		T[0][0] = true;

		for (int i = 1; i <= string.length(); i++) {
			for (int j = 1; j <= string2.length(); j++) {
				if (string.charAt(i - 1) == string2.charAt(j - 1) || string2.charAt(j - 1) == '?') {
					T[i][j] = T[i - 1][j - 1];
				} else if (string2.charAt(j - 1) == '*') {
					T[i][j] = T[i - 1][j] || T[i][j - 1];
				} else
					T[i][j] = false;
			}
		}

		return T[string.length()][string2.length()];
	}

}
