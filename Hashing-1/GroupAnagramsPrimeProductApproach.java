class Solution {
    public long primeProduct(String s) {
        long res = 1;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res = res * primes[c - 'a'];
        }
        return res;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long, List<String>> map = new HashMap<>();
        Long key;
        for(String s : strs) {
            // We are going to store the prime product of the string as key for easy comparison
            key = primeProduct(s);
            System.out.println(key + " ");
            // check if already present
            if(map.containsKey(key)) {
                // add the new value to the list
                map.get(key).add(s);
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