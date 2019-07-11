49. Group Anagrams
Medium

1776

116

Favorite

Share
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<> ();
        if(strs==null||strs.length==0)
            return res;
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String temp=strs[i];
            char[] tempA=temp.toCharArray();
            Arrays.sort(tempA);
            String temp1=String.valueOf(tempA);
            if(map.containsKey(temp1)){
                List<String> re=map.get(temp1);
                re.add(strs[i]);
                map.put(temp1,re);
            }
            else{
                List<String> list=new ArrayList<>();
                list.add(strs[i]);
                map.put(temp1,list);
            }
        }
        for(List<String> li:map.values()){
            res.add(li);
        }
        return res;
    }
}