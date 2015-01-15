import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FullBinaryTree {

	public static void main(String[] args) {
		FullBinaryTree c = new FullBinaryTree();
		try {
			FileReader fr = new FileReader(
					new File(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\Input.in"));
			BufferedReader br = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter(
					new FileWriter(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\Output.in"));
			int out ;
			int T = Integer.parseInt(br.readLine());
			int[][] adj;
			int[] sumArr;
			for (int t = 1; t <= T; t++) {
				 out = Integer.MIN_VALUE;
				int N = Integer.parseInt(br.readLine());
				adj = new int[N][N];
				sumArr = new int[N];
				for (int i = 0; i < N - 1; i++) {
					String[] arr = br.readLine().split("\\ ");
					int x = Integer.parseInt(arr[0]);
					int y = Integer.parseInt(arr[1]);
					adj[x - 1][y - 1] = 1;
					adj[y - 1][x - 1] = 1;
					sumArr[x - 1] += 1;
					sumArr[y - 1] += 1;
				}
				
				List<Integer> list = new ArrayList<Integer>();
				for(int i=0;i<N;i++){
					if(sumArr[i]==2){
						list.add(i);
					}
				}
				int len = list.size();
				int[][][] adjx = new int[len][N][N]; int[][] sumArrx=new int[len][N];
				
				for(int i=0;i<len;i++){
					for(int j=0;j<N;j++){
						for(int k=0;k<N;k++){
							adjx[i][j][k] = adj[j][k];
						}
					}
				}
				for(int i = 0;i<len;i++){
					for(int j=0;j<N;j++){
						sumArrx[i][j]=sumArr[j];
					}
				}
				for(int i =0;i<len;i++){
					boolean[] visited=new boolean[N];
					visited[list.get(i)]=true;
 				out = Math.max(out,c.solution(adjx[i], sumArrx[i],visited, N,list.get(i)));
				System.out.println("root as"+list.get(i)+" out: "+out); 
				}
				System.out.println("Case #" + t + ": " + out);
				
				// pw.write("Case #" + t + ": " + out + "\n");
			}
			br.close();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*public int solution(int[][] adj, int[] sumArr, int N,int root) {
		int count = 0;
		boolean flag = false;
		int noOfTwo=0;
		for(int i=0;i<N;i++){
			if(sumArr[i]==2){
				noOfTwo++;
			}
		}
		if(noOfTwo==1){
			flag=false;
			return count;
		}
		
			for (int i = 0; i < N; i++) {
				if (sumArr[i] == 1) {
					for (int j = 0; j < N; j++) {
						if (adj[i][j] == 1) {
							if (sumArr[j] == 2 && i!=root) {
								flag=true;
								adj[i][j] = 0;
								adj[j][i] = 0;
								sumArr[i] -= 1;
								sumArr[j] -= 1;
								count++;
							} else {
								break;
							}
						}	
					}
				}
			}
			
			
		if(flag){
			count+=solution(adj,sumArr,N,root);
		}
		return count;
	}*/
	
	public int solution(int[][] adj, int[] sumArr,boolean[] visited, int N,int root){
		
		visited[root]=true;
		int count=0;
		for(int j=0;j<N;j++){
			if(adj[root][j]==1 && !visited[j]){	
				visited[j]=true;
				if(sumArr[j]==1){
					if(count>0){
						count--;
					}
					continue;
				}else if(sumArr[j]==2){
					if(count>0){
					count-=delete(adj,sumArr,visited,N,j);
					}else{
						count=delete(adj,sumArr,visited,N,j);
					}
					
				}else if(sumArr[j]==3){
					count+=solution(adj,sumArr,visited,N,j);
				}
			}
		}
		return count;
		
	}
	
	public int delete(int[][] adj, int[] sumArr,boolean[] visited, int N,int parent){
		int count=0;
		for(int j=0;j<N;j++){
			if(adj[parent][j]==1 && !visited[j]){
				adj[parent][j]=0;
				sumArr[parent]-=1;
				/*for(int k=0;k<N;k++){
					adj[j][k]=0;
				}*/
				sumArr[j]=0;
			}
			if(!visited[j]){
				count++;
			}
		}
		return count;
	}	
}
