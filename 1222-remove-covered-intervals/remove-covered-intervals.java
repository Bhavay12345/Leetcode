class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        int c=0;
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int s=intervals[i][0];
            int e=intervals[i][1];
            if(e<=end || (e>=end && start>=s)){
                end=Math.max(end,e);
            }
            else{
                c++;
                start=s; end=e;
            }
        }
        return c+1;
    }
}