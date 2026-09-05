class Solution {
    public int minCostClimbingStairs(int[] cost) {
         int step1=0;
        int step2=0;
        for(int i=cost.length-1; i>=0; i--)
        {
            int current_step=cost[i]+Math.min(step1,step2);
            step1=step2;
            step2=current_step;
            System.out.println("current_step");
             System.out.println(current_step);
              System.out.println("step1");
               System.out.println(step1);
                System.out.println("step2");
                 System.out.println(step2);
            
        }
        return Math.min(step1,step2);
        
    }

    }