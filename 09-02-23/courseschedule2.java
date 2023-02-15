class Solution {
    ArrayList<ArrayList<Integer>> adj;
    int[] ind;
    Queue<Integer> q;
    boolean[] vis;
    ArrayList<Integer> res;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        ind = new int[numCourses];
        q = new LinkedList<>();
        vis = new boolean[numCourses];
        res = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<Integer>());
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            ind[prerequisites[i][0]]++;
        }
        for(int i=0;i<ind.length;i++){
            if(ind[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int k = q.poll();
            vis[k] = true;
            res.add(k);
            for(int nei:adj.get(k)){
                if(!vis[nei]){
                    ind[nei]--;
                    if(ind[nei]==0) q.offer(nei);
                }
            }
        }
        int[] fres = new int[res.size()];
        for(int i=0;i<res.size();i++) fres[i] = res.get(i);
        if(fres.length==numCourses) return fres;
        return new int[]{};
    }
}
