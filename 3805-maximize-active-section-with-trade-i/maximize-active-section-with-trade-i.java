class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        ArrayList<Integer> zero= new ArrayList<>();
        int n=s.length();
        int zerocount =0;
        int onecount=0;
        for(int i=0;i<s.length();i++){
            int num=s.charAt(i)-'0';
            if(num==1){
                if(i!=0 && s.charAt(i-1)=='0'){
                    zero.add(zerocount);
                    zerocount=0;
                }
                onecount++;
            }
            else {
                zerocount++;
            }
        }
        if(zerocount!=0) zero.add(zerocount);
        int maxi=0;
        int st=0;int e=1;
        while(e<zero.size()){
            int sum=zero.get(st)+zero.get(e);
            maxi=Math.max(maxi,sum);
            st++;e++;
        }
        for(int i=0;i<zero.size();i++){
            System.out.println(zero.get(i));
        }
        return maxi+onecount;
    }
}