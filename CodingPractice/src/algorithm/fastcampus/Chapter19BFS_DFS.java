package algorithm.fastcampus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Chapter19BFS_DFS {

    public ArrayList<String> bfs(HashMap<String, ArrayList<String>> graph, String start){
        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> needVisit = new ArrayList<String>();

//        visited.add(start);
//        needVisit.addAll(graph.get(start));
        needVisit.add(start);

        while(needVisit.size() > 0){
            String node = needVisit.remove(0);
            if(!visited.contains(node)){
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
            // 방문한적 없을때 addAll 해야댐
            // needVisit.addAll(graph.get(node));
        }
        return visited;
    }

    public ArrayList<String> dfs(HashMap<String, ArrayList<String>> graph, String start){
        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> needVisit = new ArrayList<String>();

        needVisit.add(start);

        while(needVisit.size() > 0){
            String node = needVisit.remove(needVisit.size()-1);
            if(!visited.contains(node)){
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }

    public static void main(String[] args){
        Chapter19BFS_DFS bfs_dfs = new Chapter19BFS_DFS();

        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));


//        System.out.println(bfs_dfs.bfs(graph,"A"));
        System.out.println(bfs_dfs.dfs(graph,"A"));


    }

}
