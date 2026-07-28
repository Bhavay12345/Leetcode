class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gs=0;int cs=0;
        for(int i=0;i<gas.length;i++){
            gs+=gas[i];
            cs+=cost[i];
        }
        if(cs>gs) return -1;
        int str=0;
        int cf=0;
        for(int i=0;i<gas.length-1;i++){
            cf=cf+gas[i]-cost[i];
            if(cf<0){
                str=i+1;
                cf=0;
            }
        }
        return str;
    }
}