class Solution {
    public boolean wordPattern(String pattern, String s) {
        // Map to hold the key value mappings between pattern & s
        HashMap<Character, String> map = new HashMap<>();
        // To enforce bijection
        HashSet<String> valSet = new HashSet<>();
        boolean ret = true;
        // Split all the words in array of strings
        String[] words = s.split(" ");
        int i, j, m, n;
        i = 0;
        m = pattern.length();
        n = words.length;
        // To enforce equal number of keys and values
        if(m != n) {
            return false;
        }
        while(i < m) {
            Character key = pattern.charAt(i);
            if(map.containsKey(key)) {
                if(!(map.get(key)).equals(words[i])) {
                    ret = false;
                    break;
                }
            } else {
                // To check bijection
                if(valSet.contains(words[i])) {
                    ret = false;
                    break;
                } else {
                    valSet.add(words[i]);
                    map.put(key, words[i]);
                }
            }
            i++;
        }
        return ret;
    }
}