package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

 class Result {
    public static int countMinimumUnreachableWarehouses(int warehouseNodes, List<Integer> warehouseFrom,
                                                        List<Integer> warehouseTo) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[warehouseNodes + 1];

        for (int i = 1; i <= warehouseNodes; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < warehouseFrom.size(); i++) {
            int warehouseA = warehouseFrom.get(i);
            int warehouseB = warehouseTo.get(i);
            graph.get(warehouseA).add(warehouseB);
            graph.get(warehouseB).add(warehouseA); // Assuming roads are bidirectional
        }

        int startWarehouse = 1; // You can change this to your desired starting warehouse
        int unreachableCount = findUnreachableWarehouses(graph, visited, startWarehouse);
        int reachableCount = warehouseNodes - unreachableCount;

        return reachableCount;
    }

    private static int findUnreachableWarehouses(Map<Integer, List<Integer>> graph,
                                                 boolean[] visited, int warehouse) {
        visited[warehouse] = true;
        int unreachableCount = 1;

        for (int neighbor : graph.get(warehouse)) {
            if (!visited[neighbor]) {
                unreachableCount += findUnreachableWarehouses(graph, visited, neighbor);
            }
        }

        return unreachableCount;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] warehouseNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int warehouseNodes = Integer.parseInt(warehouseNodesEdges[0]);
        int warehouseEdges = Integer.parseInt(warehouseNodesEdges[1]);

        List<Integer> warehouseFrom = new ArrayList<>();
        List<Integer> warehouseTo = new ArrayList<>();

        IntStream.range(0, warehouseEdges).forEach(i -> {
            try {
                String[] warehouseFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                warehouseFrom.add(Integer.parseInt(warehouseFromTo[0]));
                warehouseTo.add(Integer.parseInt(warehouseFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.countMinimumUnreachableWarehouses(warehouseNodes, warehouseFrom, warehouseTo);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}