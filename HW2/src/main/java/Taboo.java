
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
	private List<T> rules;
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules ) {
		this.rules = rules;
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		// create set in which to collect elements
		Set<T> set = new HashSet<T>();

		for(int i = 0; i < rules.size()-1; i++){
			if(rules.get(i).equals(elem)){
				//System.out.println("wok");
				if(rules.get(i+1).equals(null)){
					//
				}else{
					set.add(rules.get(i+1));
				}
			}
		}

		// return the set
		return set;
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
		List<String> rules = stringToList("acab");
		Taboo<String> t = new Taboo<String>(rules);
		Set<String> set = new HashSet<String>();
		set = t.noFollow("a");
		System.out.println(set);

	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		for(int i = 0; i < list.size()-1; i++){
			if(noFollow(list.get(i)).contains(list.get(i+1))){
				list.remove(i+1);
				i--;
			}
		}
	}
}
