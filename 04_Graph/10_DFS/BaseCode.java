import java.util.ArrayList;

public class BaseCode {
    
    // DFS 탐색 순서를 저장할 리스트
    public static ArrayList<Integer> result = new ArrayList<>();

    /**
     * 재귀를 활용한 DFS 뼈대 코드
     */
    public static void dfs(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited) {
        // 1. 현재 노드 방문 처리 및 기록
        visited[v] = true;
        result.add(v);

        // 2. 현재 노드와 연결된 인접 노드들을 순회
        for (int nextNode : graph.get(v)) {
            // 3. 아직 방문하지 않은 노드가 있다면 해당 노드를 기준으로 깊이 탐색 진행
            if (!visited[nextNode]) {
                dfs(graph, nextNode, visited);
            }
        }
    }

    public static void main(String[] args) {
        int n = 8; // 노드의 최대 번호
        
        // 1. 인접 리스트 (Adjacency List) 초기화
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 2. 그래프 간선 연결 (양방향 연결 예시)
        graph.get(1).add(2); graph.get(1).add(3); graph.get(1).add(8);
        graph.get(2).add(1); graph.get(2).add(7);
        graph.get(3).add(1); graph.get(3).add(4); graph.get(3).add(5);
        graph.get(4).add(3); graph.get(4).add(5);
        graph.get(5).add(3); graph.get(5).add(4);
        graph.get(6).add(7);
        graph.get(7).add(2); graph.get(7).add(6);
        graph.get(8).add(1);
        
        // 3. 방문 처리 배열 초기화 및 DFS 실행
        boolean[] visited = new boolean[n + 1];
        dfs(graph, 1, visited);
        
        System.out.println("DFS 탐색 순서: " + result);
        // Output: [1, 2, 7, 6, 3, 4, 5, 8]
    }
}