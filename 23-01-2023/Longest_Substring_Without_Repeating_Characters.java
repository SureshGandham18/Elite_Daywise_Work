class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> unique = new HashSet<>();
        char[] arr = s.toCharArray();
        int max=0;
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(!list.contains(arr[i])){
                list.add(arr[i]);
                if(max<list.size())
                    max=list.size();
            }
            else{
                int k=list.indexOf(arr[i]);
                for(int j=0;j<=k;j++)
                    list.remove(0);
                list.add(arr[i]);
                if(max<list.size())
                    max=list.size();
            }
        }

        return max;
    }
}
