// Time Complexity : O(NM)
// Where N is number of element in array and M maximum lenth of a individual string
// Space Complexity : O(N)
// Where N is number of element in an array, HashMap stores all element in the array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
The bruteforce solution would be having a HashMap, traversing to each individual element and sort the element
and check whether the element exists in hashmap, if not add that sorted element to hashmap and link new
arraylist as a value. Else, you can add the new element to the existing arraylist. The Space complexity would
be same to the optimized solution O(N), the time complexity would be O(N*MlogM).

We can optimize the sorting part with the primefactorization. We get all 26 prime numbers starting from 2,
then we would multiply each character in the string with the respective index of 26 prime numbers. Though,
the order of string gets shuffled the product of prime number would result same.

Using prime product we have optimized our time complexity from O(NMlogM) to O(NM)
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs==null||strs.length==0){
            return null;
        }

        HashMap<Double, List<String>> anagram = new HashMap();

        for(String str: strs){
            double hashCode = primeHashCode(str);
            System.out.println(hashCode);
            if(!anagram.containsKey(hashCode)){
                anagram.put(hashCode, new ArrayList());
            }
            anagram.get(hashCode).add(str);
        }

        return new ArrayList(anagram.values());
    }

    public double primeHashCode(String str){
        double result  = 1;
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            result *= prime[c - 'a'];
        }
        return result;
    }

}