class Solution {
    static Stack<Integer> st= new Stack<>();
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        return LargestSum(nums,n) - SmallestSum(nums,n);
    }
    public long SmallestSum(int[] nums,int n){
        int[] nse=new int[n];
        Nse(nse,nums);
        int[] psee=new int[n];
        Psee(psee,nums);
        long sum=0;
        for(int i=0;i<nums.length;i++){
            int left=i-psee[i];
            int right = nse[i] - i;

            sum += (long) left * right * nums[i] ;
        }
        return sum;
    }
    public long LargestSum(int[] nums,int n){
        int[] nle=new int[n];
        Nle(nle,nums);
        int[] plee=new int[n];
        Plee(plee,nums);
        long sum=0;
        for(int i=0;i<nums.length;i++){
            int left=i-plee[i];
            int right = nle[i] - i;

            sum += (long) left * right * nums[i] ;
        }
        return sum;
    }
    public void Nse(int[] nse,int[] nums){ // next smallest
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]<=nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) nse[i]=nums.length;
            else nse[i]=st.peek();
            st.push(i);
        }
        st.clear();
    }
    public void Nle(int[] nle,int[] nums){ // next largest
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>=nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) nle[i]=nums.length;
            else nle[i]=st.peek();
            st.push(i);
        }
        st.clear();
    }
    public void Psee(int[] psee,int[] nums){ // previous smallest
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[i]<nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) psee[i]=-1;
            else psee[i]=st.peek();
            st.push(i);
        }
        st.clear();
    }
    public void Plee(int[] plee,int[] nums){ // next largest
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) plee[i]=-1;
            else plee[i]=st.peek();
            st.push(i);
        }
        st.clear();
    }
}