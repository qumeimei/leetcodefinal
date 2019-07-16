386. Longest Substring with At Most K Distinct Characters
中文English
Given a string S, find the length of the longest substring T that contains at most k distinct characters.

Example
Example 1:

Input: S = "eceba" and k = 3
Output: 4
Explanation: T = "eceb"
Example 2:

Input: S = "WORLD" and k = 4
Output: 4
Explanation: T = "WORL" or "ORLD"
Challenge
O(n) time

public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null||s.length()==0||k==0)
            return 0;
        if(s.length()<=k)
            return s.length();
        int n=s.length();
        HashMap <Character, Integer> map=new HashMap<>();
        int start=0,end=0,res=0;
        while(end<n){
            char temp=s.charAt(end);
            map.put(temp,map.getOrDefault(temp,0)+1);
            if(map.size()==k) res=Math.max(res,end-start+1);
            while(map.size()>k){
                char temp1=s.charAt(start);
                start++;
                map.put(temp1,map.get(temp1)-1);
                if(map.get(temp1)==0) map.remove(temp1);
            }
            end++;
        }
        res=Math.max(res,end-start);
        return res;
    }
}