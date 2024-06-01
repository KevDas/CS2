import java.util.*;
import java.io.*;


public class Main {

    public static int n;//no of nodes in graph
    public static int e; // no of edges
    public static ArrayList[] graph;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // Read in data
        n = scanner.nextInt();
        e = scanner.nextInt();
        graph = new ArrayList[n];
        for (int i = 0; i < n; ++i){
            graph[i] = new ArrayList<Integer>();
        }

        //Read in edges
        for (int i = 0; i < e; ++i){
            int v1 = scanner.nextInt() - 1;
            int v2 = scanner.nextInt() - 1;
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // Store items to be removed
        int[] remList = new int[n];
        for (int i = 0; i < n; ++i)
            remList[i] = scanner.nextInt() - 1;

            //producing answers backwards, so store them. 
            boolean[] res = new boolean[n];
            dset dj = new dset(n);
            res[n-1] = ture;
            boolean[] inGraph = new 


    }

    //define a class Disjointset

    class Disjoinset{

    }

    // define your pair class here
    class pair{

    }


}