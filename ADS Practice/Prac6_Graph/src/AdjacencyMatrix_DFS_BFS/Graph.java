package AdjacencyMatrix_DFS_BFS;
import java.util.Scanner;
public class Graph {
	private int[][] adjacenyMatrix;
	private int numVertices; 
	public Graph(int numVertices) { 
		this.numVertices=numVertices; 
		adjacenyMatrix=new int[numVertices][numVertices];

	} 
	public void addEdge(int start,int end) { 
		adjacenyMatrix[start][end]=1;
		adjacenyMatrix[end][start]=1;
	} 
	public void bfs(int startVertex) { 
		boolean[] visited=new boolean[numVertices]; 
		int[] queue=new int[numVertices]; 
		int front=0,rear=0;
		visited[startVertex]=true;
		queue[rear++]=startVertex;

		System.out.println("BFS traversal starting from vertex : "+startVertex+ " :");
		while(front<rear) { 
			int currentVertex=queue[front++]; 
			System.out.print(currentVertex+" "); 
			for(int i=0;i<numVertices;i++) {
				if(adjacenyMatrix[currentVertex][i] == 1 && !visited[i]) 
				{
					visited[i]=true; queue[rear++]=i;
				}
			}
		}
		System.out.println();
	}
	public void dfs(int startVertex) {
		boolean[] visited=new boolean[numVertices];
		int[] stack=new int[numVertices]; 
		int top=-1;
		stack[++top]=startVertex;
		visited[startVertex]=true;
		System.out.println("DFS traversal starting from vertex "+startVertex+" ");
		while(top>=0) { 
			int currentVertex=stack[top--]; System.out.print(currentVertex+" "); 
			for(int i=numVertices-1;i>=0;i--) { 
				if(adjacenyMatrix[currentVertex][i]==1 && !visited[i]) {
					visited[i]=true; stack[++top]=i;
				}
			}
		}
		System.out.println();
	}
	public void displayAdjacencyMatrix() {
		System.out.println("Adjacency matrix : ");
		for(int i=0;i<numVertices;i++) { 
			for(int j=0;j<numVertices;j++) {
				System.out.print(adjacenyMatrix[i][j]+" ");
			}
			System.out.println();
		} }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices : ");
		int numVertices=sc.nextInt();
		Graph gh=new Graph(numVertices); 
		System.out.println("Enter number of edges : ");
		int numEdges=sc.nextInt();
		System.out.println("Enter the edges (Source and destination) : ");
		for(int i=0;i<numEdges;i++) {
			int src=sc.nextInt();
			int des=sc.nextInt();
			gh.addEdge(src, des);
		}
		gh.displayAdjacencyMatrix();
		System.out.println("Enter the start vertex for BFS : "); 
		int bfsStart=sc.nextInt();
		gh.bfs(bfsStart);
		System.out.println("Enter the start vertex for DFS : ");
		int dfsStart=sc.nextInt();
		gh.bfs(dfsStart);
	}
}
