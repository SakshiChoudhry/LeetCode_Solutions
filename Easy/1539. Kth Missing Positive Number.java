class Solution1539 {
    public int findKthPositive(int[] arr, int k) {
        int n =arr.length;
        int l =0;
        int h=n-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k)
            {
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return k+h+1;
    }
}
