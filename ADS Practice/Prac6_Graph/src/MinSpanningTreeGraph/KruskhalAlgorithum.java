package MinSpanningTreeGraph;

import java.util.Scanner;
class Edge{ 
	int src,dest,weight;

	Edge(int src,int des ,int weight){
		this.src=src; 
		this.dest=des; 
		this.weight=weight;
	}
}
public class KruskhalAlgorithum {
	private int V;
	private int E;
	private Edge[] edges;
	private int edgeCount=0;
	public KruskhalAlgorithum(int vertices,int edgesCount) { 
		this.V=vertices;
		this.E=edgesCount; 
		edges=new Edge[edgesCount];
	}
	public void addEdge(int src, int dest,int weight) { 
		edges[edgeCount++]=new Edge(src,dest,weight);
	}
	private int findParent(int[] parent,int vertex) { 
		if(parent[vertex]!= vertex) {
			parent[vertex]=findParent(parent, parent[vertex]);
		}
		return parent[vertex];
	}
	public void union(int[] parent,int[] rank,int x,int y) { 
		int rootX=findParent(parent, x); 
		int rootY=findParent(parent, y);
		if(rootX != rootY) {
			if(rank[rootX] < rank[rootY]) {
				parent[rootX]=rootY;
			}else if( rank[rootX]>rank[rootY]) {
				parent[rootY]=rootX;
			}else {
				parent[rootY]=rootX; rank[rootX]++;
			}
		}
	}
	private void sortEdges() { 
		for(int i=0;i<E-1;i++) { 
			for(int j=0;j<E-i-1;j++) {
				if(edges[j].weight>edges[j+1].weight) {
					Edge temp=edges[j]; edges[j]=edges[j+1]; edges[j+1]=temp;
				}
			}
		}
	}
	public void kruskalMST() { 
		sortEdges();
		int[] parent=new int[V];
		int[] rank=new int[V];
		for(int i=0;i<V;i++) { 
			parent[i]=i; rank[i]=0;
		}
		Edge[] mst=new Edge[V-1];
		int mstIndex=0;
		int mstWeight=0;
		for(int i=0;i<E;i++) {
			if(mstIndex == V-1) {
				break;
			}
			Edge edge=edges[i];
			int srcParent=findParent(parent, edge.src); 
			int destParent=findParent(parent,edge.dest);
			if(srcParent != destParent) { 
				mst[mstIndex++]=edge;
				mstWeight+=edge.weight;
				union(parent,rank,srcParent,destParent);
			}
		}
		System.out.println("Edges in the MST : ");
		System.out.println("Src des Weight");
		for(int i=0;i<mstIndex;i++) {
			System.out.println(mst[i].src+"--"+mst[i].dest+"--"+"=="+mst[i].weight);
		}
		System.out.println("Total weight of MST : "+mstWeight);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices : ");

		int V=sc.nextInt();
		System.out.println("Enter the number of edges : ");
		int E=sc.nextInt();
		KruskhalAlgorithum graph=new KruskhalAlgorithum(V, E); System.out.println("Enter the edges in the formate : src dest weight "); 
		for(int i=0;i<E;i++) { int src=sc.nextInt(); int dest=sc.nextInt(); int weight=sc.nextInt(); graph.addEdge(src, dest, weight);
		}
		graph.kruskalMST(); sc.close();
	}
}
