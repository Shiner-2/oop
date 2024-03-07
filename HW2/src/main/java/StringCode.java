import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str string
	 * @return max run length
	 */
	public static int maxRun(String str) {
		if (str.length() == 0) {
			return 0;
		}

		int cnt = 1, mx = 1;
		char lst = str.charAt(0);

		for(int i = 1 ; i < str.length(); i++){
			if (str.charAt(i) == lst) {
				cnt++;
			}else{
				cnt = 1;
				lst = str.charAt(i);
			}
			mx = Math.max(mx,cnt);
		}

		return mx; // YOUR CODE HERE
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		if (str.length()==0){
			return "";
		}
		String ans = "";
		for(int i = 0 ; i < str.length() - 1; i++){
			char c = str.charAt(i);
			if (c >= 48 && c <= 57){
				int num = c - 48;
				c = str.charAt(i+1);
				for(int j = 0 ; j < num; j++){
					ans = ans + c;
				}
			}else{
				ans = ans + c;
			}
		}
		char d = str.charAt(str.length()-1);
		if(d<48||d>57){
			ans = ans + d;
		}
		return ans; // YOUR CODE HERE
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> setA = new HashSet<String>();
		for(int i = 0 ; i < a.length()-len+1; i++){
			String tmp = a.substring(i,i+len);
			setA.add(tmp);
		}
		for(int i = 0 ; i < b.length()-len+1; i++){
			String tmp = b.substring(i,i+len);
			if(setA.contains(tmp)){
				return true;
			}
		}
		return false; // YOUR CODE HERE
	}

}
