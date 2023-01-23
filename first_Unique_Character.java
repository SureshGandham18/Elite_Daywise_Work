class Solution {
    public int firstUniqChar(String s) {
        TreeMap<Character,Integer> map = new TreeMap<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }
            else{
                int c = map.get(arr[i]);
                c++;
                map.put(arr[i],c);
            }
        }
        System.out.println(map);
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])==1)
                return i;
        }
        return -1;
    }
}