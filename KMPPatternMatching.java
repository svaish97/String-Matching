
public class KMPPatternMatching {
	public static void main(String[] args) {
		String text = "ABCDEABCFG";
		String pattern = "ABCF";
		KMPSearch(text, pattern);
	}

	private static void KMPSearch(String text, String pattern) {
		int arr[] = new int[pattern.length()];
		calculateArray(pattern, arr);
		int i=0,j=0;
		while(i<text.length())
		{
			if(pattern.charAt(j)==text.charAt(i))
			{
				i++;
				j++;
			}
			if(j==pattern.length())
			{
				System.out.println("Pattern Found At "+(i-j));
				j=arr[j-1];
			}
			else if(i<text.length() && pattern.charAt(j)!=text.charAt(i))
			{
				if(j!=0)
					j=arr[j-1];
				else
					i++;
			}
		}

	}

	private static void calculateArray(String pattern, int[] arr) {
		int length = 0;
		int i = 1;
		while (i < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(length)) {
				length++;
				arr[i] = length;
				i++;
			} else {
				if (length != 0)
					length = arr[length - 1];
				else {
					arr[i] = length;
					i++;
				}
			}
		}

	}
}
