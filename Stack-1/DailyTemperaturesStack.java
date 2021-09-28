// TC: O(2n) because in worst case scenario, we will push n elements in stack and pop n elements
// SC: O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        if(temperatures == null || temperatures.length == 0) {
            return new int[] {};
        }
        int[] res = new int[temperatures.length];
        // stack has got indices
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < temperatures.length; i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int index = s.pop();
                res[index] = i - index;
            }
            s.push(i);
        }
        return res;
    }
}