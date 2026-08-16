class Solution {
    static int MOD=1000000007;
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] nse = new int[n]; // next smallest element
        Nse(nse,arr);
        int[] psee = new int[n]; // previous smallest element & equal
        Psee(psee,arr);
        // & equal in psee bcuz arr[1,1] --> subarr(1,1) count twise if we can't do it in psee
        long sum=0;
        for(int i=0;i<arr.length;i++){
            int left = i - psee[i];
            int right = nse[i] - i;

            sum = ( sum + ((long) left * right * arr[i])%MOD )%MOD ;
        }
        return (int)sum;
    }
    public static void Nse(int[] nse,int[] arr){
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) nse[i] = arr.length ; //N
            else nse[i] = st.peek();
            st.push(i);
        }  
    }
    public static void Psee(int[] psee,int[] arr){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) psee[i] = -1 ;
            else psee[i] = st.peek();
            st.push(i);
        }  
    }
}