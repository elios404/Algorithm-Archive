import java.util.Arrays;

public class BaseCode {
    
    // 오버플로우를 방지하기 위한 적절한 무한대 값 (보통 1e9 사용)
    private static final int INF = 100000000;

    public static int[][] floydWarshall(int v, int[][] edges) {
        // 1. 2차원 최단 거리 테이블 초기화
        int[][] graph = new int[v + 1][v + 1];
        
        for (int i = 1; i <= v; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0; // 자기 자신으로 가는 비용은 0
        }

        // 2. 간선 정보 입력
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];
            graph[a][b] = c;
        }

        // 3. 플로이드-워셜 핵심 3중 루프
        for (int k = 1; k <= v; k++) {          // k: 거쳐가는 노드
            for (int i = 1; i <= v; i++) {      // i: 출발 노드
                for (int j = 1; j <= v; j++) {  // j: 도착 노드
                    // 기존 비용과 k를 거쳐가는 비용 중 최솟값으로 갱신
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        return graph;
    }

    public static void main(String[] args) {
        int v = 4;
        int[][] edges = {
            {1, 2, 4},
            {1, 4, 6},
            {2, 1, 3},
            {2, 3, 7},
            {3, 1, 5},
            {3, 4, 4},
            {4, 3, 2}
        };

        int[][] resultGraph = floydWarshall(v, edges);

        System.out.println("모든 쌍의 최단 거리 결과:");
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (resultGraph[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(resultGraph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}