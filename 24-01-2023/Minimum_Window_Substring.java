class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tmap = new HashMap<>();
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        char[] tarr = t.toCharArray();
        for(int i=0;i<tarr.length;i++){
            tmap.put(tarr[i],tmap.getOrDefault(tarr[i],0)+1);
        }
        int reqlen = tmap.size();
        HashMap<Character,Integer> resMap = new HashMap<>();
        int l=0;
        int r=0;
        int res=0;
        char[] sarr = s.toCharArray();
        int min = s.length()+1;
        int resl = 0;
        int resr = 0;
        while(r<s.length()){
            resMap.put(sarr[r],resMap.getOrDefault(sarr[r],0)+1);
            // System.out.println(resMap);
            if(tmap.containsKey(sarr[r]) && resMap.get(sarr[r]).intValue()==tmap.get(sarr[r]).intValue()){
                res++;
                System.out.println(res);
            }
            while(l<=r && res==reqlen){
                // System.out.println(min);
                if(min>(r-l+1)){
                    min = r-l+1;
                    resl = l;
                    resr = r;
                }
                resMap.put(sarr[l],resMap.get(sarr[l])-1);
                if(tmap.containsKey(sarr[l]) && resMap.get(sarr[l]).intValue()<tmap.get(sarr[l]).intValue()){
                    res--;
                }
                l++;
            }    
            r++;
        }
        // System.out.println(t.length()+" "+s.length());
        if(min == s.length()+1){
            return "";
        }
        return s.substring(resl,resr+1);
    }
}
