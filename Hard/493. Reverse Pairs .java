class Solution {
    public int merge(int nums[], int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int count = 0;

        int l = low, h = mid + 1;
        while (l <= mid) {
            while (h <= high && (long) nums[l] > 2L * nums[h]) {
                h++;
            }
            count += (h - (mid + 1));
            l++;
        }

        l = low;
        h = mid + 1;

        while (l <= mid && h <= high) {
            if (nums[l] <= nums[h]) {
                temp.add(nums[l++]);
            } else {
                temp.add(nums[h++]);
            }
        }

        while (l <= mid) temp.add(nums[l++]);
        while (h <= high) temp.add(nums[h++]);

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }

        return count;
    }

    public int mergeSort(int nums[], int l, int h) {
        int count = 0;
        if (l >= h) return count;

        int mid = (l + h) / 2;
        count += mergeSort(nums, l, mid);
        count += mergeSort(nums, mid + 1, h);
        count += merge(nums, l, mid, h);
        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
