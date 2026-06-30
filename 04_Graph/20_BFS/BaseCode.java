import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;

public class BaseCode {
    
    // BFS 탐색 순서를 저장할 리스트
    public static ArrayList<Integer> result = new ArrayList<>();

    /**
     * 큐를 활용한 BFS 뼈대 코드
     */
    public static void bfs(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited) {
        // 1. 큐 생성 (ArrayDeque가 빠르고 안전함)
        Queue<Integer> queue = new ArrayDeque<>();
        
        // 2. 시작 노드 큐에 삽입 및 방문 처리
        queue.offer(start);
        visited[start] = true;

        // 3. 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 노드를 하나 꺼내 기록
            int v = queue.poll();
            result.add(v);

            // 해당 노드와 연결된 인접 노드들을 순회
            for (int nextNode : graph.get(v)) {
                // 아직 방문하지 않은 노드라면 큐에 넣고 방문 처리
                if (!visited[nextNode]) {
                    queue.offer(nextNode);
                    visited[nextNode] = true; // 큐에 넣을 때 방문 체크! (중복 삽입 방지)
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 8;
        
        // 1. 인접 리스트 초기화
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 2. 그래프 간선 연결
        graph.get(1).add(2); graph.get(1).add(3); graph.get(1).add(8);
        graph.get(2).add(1); graph.get(2).add(7);
        graph.get(3).add(1); graph.get(3).add(4); graph.get(3).add(5);
        graph.get(4).add(3); graph.get(4).add(5);
        graph.get(5).add(3); graph.get(5).add(4);
        graph.get(6).add(7);
        graph.get(7).add(2); graph.get(7).add(6);
        graph.get(8).add(1);
        
        // 3. 방문 처리 배열 초기화 및 BFS 실행
        boolean[] visited = new boolean[n + 1];
        bfs(graph, 1, visited);
        
        System.out.println("BFS 탐색 순서: " + result);
        // Output: [1, 2, 3, 8, 7, 4, 5, 6]
    }
}