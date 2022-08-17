// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
We usually check whether both strings or isomorhpic or not by traversing uni directional from String A to B,
however we can two unique characters in A string is pointing to same character in B string. When we are
traversing unidirectional, the above case would result us postive but the expected result has to be false.

So, we have traverse in both directions, from A to B and B to A. We can go by considering both HashMap's for
A string and B string. If we have to optimize for code, we can go with HashSet for B string. For the above
test case, for two characters in A is pointing to same character in B, while we are traversing same character
in B would exist in HashSet, with this condition we can find out that B fails to be an isomorphic
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;

        HashMap<Character, Character> sMap = new HashMap<>();
        HashSet<Character> tHashSet = new HashSet<>();

        char sChar = ' ';
        char tChar = ' ';

        for(int i=0;i<s.length();i++){
            sChar = s.charAt(i);
            tChar = t.charAt(i);
            if(sMap.containsKey(sChar)){
                if(sMap.get(sChar)!=tChar) return false;
            }
            else{
                if(tHashSet.contains(tChar)) return false;
                else{
                    sMap.put(sChar, tChar);
                    tHashSet.add(tChar);
                }
            }


        }

        return true;
    }
}