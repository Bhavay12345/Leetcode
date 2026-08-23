class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int Lknown=0;
        int Rknown =0;
        int L_Qmark=0;
        int R_Qmark=0;
        for(int i=0;i<n;i++){
            if(num.charAt(i)=='?'){
                if(i<n/2)  L_Qmark++;
                else R_Qmark++;
            }
            else{
                if(i<n/2) Lknown+= num.charAt(i)-'0';
                else Rknown+= num.charAt(i)-'0';
            }
        }
        if(( L_Qmark + R_Qmark ) % 2 == 1 ){// odd no. of ? A always win
            return true;
        }
        int Left = 2 * (Lknown) + 9 * (L_Qmark);
        int Right = 2 * (Rknown) + 9 * (R_Qmark);
        if(Left==Right) return false ;
        else return true;
    }
}