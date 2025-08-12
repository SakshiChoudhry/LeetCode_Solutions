class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int l=bills.length;
        int f=0;
        int t=0;
        for(int i =0;i<l;i++)
        {
            if(bills[i]==5)
            {
                f++;
            }
            else if(bills[i]==10)
            {
                if(f>0){
                    t++;
                    f--;
                }
                else return false;

            }
            else
            {
                if(t>0 && f>0)
                {
                    t--;
                    f--;
                }
                else if(f>=3)
                {
                    f=f-3;
                }
                else return false;
            }
        }
        return true;

    }
}