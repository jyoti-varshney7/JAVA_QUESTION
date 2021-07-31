// Given an array of strings, group anagrams together.
// Note:All inputs will be in lowercase.
// The order of your output does not matter. go to this link Anagrams_Together leetcode

// Input Format
// First line contains integer n as size of String array. Next n line contains single string as element of array.

// Constraints
// None

// Output Format
// Print the anagrams together.

// Sample Input
// 6
// eat
// tea
// tan
// ate
// nat
// bat
// Sample Output
// eat tea ate 
// bat 
// tan nat

import java.util.*;
public class Main {
		public static List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> map = new HashMap<>();
		
		for(String currString : strs) {
			char[] currStringArray = currString.toCharArray();
			Arrays.sort(currStringArray);
			String sortedStringKey = new String(currStringArray);
			// System.out.println(currString + "->" + sortedStringKey);
			if(map.containsKey(sortedStringKey)) {
				List<String> anaList = map.get(sortedStringKey);
				anaList.add(currString);
				map.put(sortedStringKey, anaList);
			} else {
				List<String> anaList = new ArrayList<>();
				anaList.add(currString);
				map.put(sortedStringKey, anaList);
			}
		}
		
		// System.out.println(map);
		

		List<List<String>> ans = new ArrayList<>();
		ans.addAll(map.values());
		for(List val : ans)
		{
			int le = val.size();
			for(int i=0;i<le;i++)
			System.out.print(val.get(i) + " ");

			System.out.println();
		}
		return ans;
	}
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] str = new String[n];

		for(int i=0;i<n;i++){
			str[i] = sc.next();
		}

		groupAnagrams(str);
		// for(List i : )
    }
}
