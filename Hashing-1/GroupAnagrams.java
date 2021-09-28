class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        char[] temp;
        for(String s : strs) {
            // We are going to store the sorted string as key for easy comparison
            // String are immutable, so convert to character array
            temp = s.toCharArray();
            Arrays.sort(temp);
            // convert back to string
            String key = String.valueOf(temp);
            // check if already present
            if(map.containsKey(key)) {
                // add the new value to the list
                List<String> l = map.get(key);
                l.add(s);
                map.replace(key, l);
            } else {
                // since not present, add new entry to map
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(key, l);
            }
        }
        return new ArrayList<>(map.values());
    }
}