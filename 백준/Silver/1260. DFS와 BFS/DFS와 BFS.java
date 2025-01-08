import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    static int[][] treeArray;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   
        int M = sc.nextInt();   
        int V = sc.nextInt();   

        treeArray = new int[N+1][N+1];

        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            treeArray[a][b] = 1;
            treeArray[b][a] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];

        bfs(V);

        System.out.println();
    }

    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        if(v == treeArray.length) return;

        for(int j = 1; j < treeArray.length; j++) {
            if(treeArray[v][j] == 1 && visited[j] == false) {
                dfs(j);
            }
        }
    }



    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(v);
        visited[v] = true;

        System.out.print(v + " ");

        while(!queue.isEmpty()) {
            int n = queue.poll();

			
            for(int i = 1; i < treeArray.length; i++) {
                if(treeArray[n][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }   
    }

}