class Solution {
    public int reverse(int x) {
        int revno=0;
        int ld;
        while(x!=0)
    {
        ld=x%10;
        if(revno>Integer.MAX_VALUE/10 || revno<Integer.MIN_VALUE/10)
        {
            return 0;
        }
        revno=(revno*10)+ld;
        x=x/10;
    }
    return revno;
    }
}