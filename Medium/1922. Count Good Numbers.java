class Solution1922 {
    long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long evenways=power(5,even);
        long oddways=power(4,odd);
        return (int) ((evenways*oddways)%MOD);
    }
    private long power(long base,long exp)
    {
        if(exp==0)
        {
            return 1;
        }
        long half=power(base,exp/2);
        long res=(half*half)%MOD;
        if(exp%2==1)     //if exp is odd
        {
            res=(base*res)%MOD;
        }
        return res;
    }
}