class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1, n2;
        n1 = nums1.length;
        n2 = nums2.length;
        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low, high;
        low = 0;
        high = n1;
        while(low <= high) {
            int x = low + (high - low) / 2;
            int y = (n1 + n2)/2 - x;
            double l1 = x == 0 ? Integer.MIN_VALUE : nums1[x - 1];
            double r1 = x == n1 ? Integer.MAX_VALUE : nums1[x];
            double l2 = y == 0 ? Integer.MIN_VALUE : nums2[y - 1];
            double r2 = y == n2 ? Integer.MAX_VALUE : nums2[y];

            if(l1 <= r2 && l2 <= r1) {
                if((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2;
                } else {
                    return Math.min(r1, r2);
                }
            } else if(l2 > r1) {
                low = x + 1;
            } else {
                high = x - 1;
            }
        }
        return 1.00;
    }
}