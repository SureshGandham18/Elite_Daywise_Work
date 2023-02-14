import java.util.* ;
import java.io.*; 
class Pair implements Comparable<Pair>{
	int dist;
	int node;
	public Pair(int dist,int node){
		this.dist = dist;
		this.node = node;
	}
	public int compareTo(Pair p1){
		return dist-p1.dist;
	}
}
public class Solution {
	static List<List<List<Integer>>> adj;
	static boolean[] vis;
	static PriorityQueue<Pair> q = new PriorityQueue<>();
	static int[] distance;
	static ArrayList<Integer> res;
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
		// Write your code here.
		adj = new ArrayList<>();
		vis = new boolean[vertices];
		distance = new int[vertices];
		for(int i=0;i<vertices;i++) distance[i] = Integer.MAX_VALUE;
		for(int i=0;i<vertices;i++){
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<edges;i++){
			ArrayList<Integer> list = new ArrayList<>();
			list.add(vec.get(i).get(1));
			list.add(vec.get(i).get(2));
			adj.get(vec.get(i).get(0)).add(list);
			list = new ArrayList<>();
			list.add(vec.get(i).get(0));
			list.add(vec.get(i).get(2));
			adj.get(vec.get(i).get(1)).add(list);
		}
		// System.out.println(adj);
		q.offer(new Pair(0,source));
		distance[source] = 0;
		Pair k;
		while(!q.isEmpty()){
			k = q.poll();
			int dis = k.dist;
			int nod = k.node;
			if(vis[nod]) continue;
			distance[nod] = dis;
			vis[nod] = true;
			for(List<Integer> nei:adj.get(nod)){
				if(!vis[nei.get(0)])
					q.add(new Pair(dis+nei.get(1), nei.get(0)));	
			}
		}
		res = new ArrayList<>();
		for(int i=0;i<distance.length;i++) res.add(distance[i]);
		return res;
	}
}
