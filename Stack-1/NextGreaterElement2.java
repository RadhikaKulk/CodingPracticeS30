// TC: O(3 * n)
// SC: O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[] {};
        }
        int[] res = new int[nums.length];
        int n = nums.length;
        Arrays.fill(res, -1);
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < 2 * n; i++) {
            while(!s.isEmpty() && nums[i % n] > nums[s.peek()]) {
                int index = s.pop();
                res[index] = nums[i % n];
            }
            if(i < n) {
                s.push(i);
            }
        }
        return res;
    }
}