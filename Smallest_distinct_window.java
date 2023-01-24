class Solution {
    public int findSubString( String str) {
        if (str.length() == 0) {
            return 0;
        }
        HashMap<Character,Integer> resMap = new HashMap<>();
        HashMap<Character,Integer> smap = new HashMap<>();
        // char[] sarr = str.toCharArray();
        for(int i=0;i<str.length();i++){
            smap.put(str.charAt(i),smap.getOrDefault(str.charAt(i),0)+1);
        }
        int l=0;
        int r=0;
        int res=0;
        int req = smap.size();
        int min = str.length()+1;
        while(r<str.length()){
            resMap.put(str.charAt(r),resMap.getOrDefault(str.charAt(r),0)+1);
            if(resMap.get(str.charAt(r)).intValue()==1){
                res++;
            }
            while(l<=r && res==req){
                if(min>(r-l+1)){
                    min = r-l+1;
                }
                resMap.put(str.charAt(l),resMap.get(str.charAt(l))-1);
                if(resMap.get(str.charAt(l)).intValue()==0){
                    res--;
                }
                l++;
            }    
            r++;
        }
        if(min == str.length()+1){
            return 0;
        }
        return min;
    }
}