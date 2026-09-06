class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])) map.put(arr[i],i);
        }
        for(int i=0;i<arr.length;i++){
            int need = 2*arr[i];
            if(map.containsKey(need) && i!=map.get(need)) return true;
        }
        return false;
    }
}