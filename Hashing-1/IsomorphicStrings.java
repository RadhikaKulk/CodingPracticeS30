class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int i, m, n;
        boolean ret = true;
        m = s.length();
        n = t.length();
        if(m != n) {
            ret = false;
        } else {
            i = 0;
            while(i < m) {
                Character key = s.charAt(i);
                if(map.containsKey(key)) {
                    if(!(map.get(key)).equals(t.charAt(i))) {
                        ret = false;
                        break;
                    }
                } else {
                    if(map.containsValue(t.charAt(i))) {
                        ret = false;
                        break;
                    } else {
                        map.put(key, t.charAt(i));
                    }
                }
                i++;
            }
        }
        return ret;
    }
}