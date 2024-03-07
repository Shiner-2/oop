import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
		for(Object var: a){
			int ha = var.hashCode();
			if(mp.containsKey(ha)==false){
				mp.put(ha,1);
			}else{
				mp.put(ha,mp.get(ha)+1);
			}
		}
		for(Object var: b){
			int ha = var.hashCode();
			if(mp.containsKey(ha)==true){
				mp.put(ha,mp.get(ha)-1);
			}
		}
		int cnt = 0;
		for(Integer i: mp.values()){
			if(i==0) cnt++;
		}
		return cnt; // YOUR CODE HERE
	}

	private static List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}

	public static void main(String[] args) {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		System.out.println(sameCount(a,b));
	}
}
