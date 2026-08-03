class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        for(String word:strs)
        {
            char chars[]=word.toCharArray();
            Arrays.sort(chars);
            String keys=new String(chars);
            if(!map.containsKey(keys))
            {
                map.put(keys,new ArrayList<>());
            }
            map.get(keys).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
