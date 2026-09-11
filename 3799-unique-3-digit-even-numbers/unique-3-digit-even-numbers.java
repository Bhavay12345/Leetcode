class Solution {
    public int totalNumbers(int[] digits) {
        int n= digits.length; int c=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            if(digits[i]==0) continue;
            int num=digits[i];
            for(int j=0;j<n;j++){
                if(j==i) continue;
                num=(num*10)+digits[j];
                for(int k=0;k<n;k++){
                    if(k==j || k==i) continue;
                    num=(num*10)+digits[k];
                    if(!map.containsKey(num)){
                        if(num%2==0) c++;
                        map.put(num,1);
                    }
                    num=num/10;
                }
                num=num/10;
            }
        }
        return c;
    }
}