class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int ans = -1;

        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        // ans can be initialized to high as a safe upper bound
        ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Use long to prevent overflow when calculating total time
            long max_time = 0;
            for (int pile : piles) {
                // Equivalent to Math.ceil((double)pile / mid)
                max_time += (long)(pile - 1) / mid + 1;
            }

            if (max_time <= h) {
                ans = mid;
                high = mid - 1; // Try for an even smaller speed
            } else {
                low = mid + 1; // Speed is too slow, need to increase it
            }
        }
        return ans;
    }
}