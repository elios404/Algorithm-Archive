import java.util.ArrayList;
import java.util.Arrays;

public class BaseCode {

    // 간선 정보를 담을 내부 클래스
    static class Edge {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public static long[] bellmanFord(int start, int n, ArrayList<Edge> edges) {
        // 1. 최단 거리 테이블 초기화
        // 가중치가 더해지는 과정에서 Integer 오버플로우가 발생할 수 있어 long 배열 사용을 권장합니다.
        long[] distance = new long[n + 1];
        long INF = Long.MAX_VALUE;
        Arrays.fill(distance, INF);
        distance[start] = 0;

        // 2. 전체 N - 1번의 라운드 진행
        for (int i = 1; i < n; i++) {
            // 매 라운드마다 모든 간선 확인
            for (Edge edge : edges) {
                // 출발지가 갱신된 적이 있고, 현재 간선을 거쳐가는 것이 더 짧은 경우
                if (distance[edge.u] != INF && distance[edge.u] + edge.weight < distance[edge.v]) {
                    distance[edge.v] = distance[edge.u] + edge.weight;
                }
            }
        }

        // 3. 음수 사이클 판별을 위한 1번의 추가 순회 (N번째 라운드)
        for (Edge edge : edges) {
            if (distance[edge.u] != INF && distance[edge.u] + edge.weight < distance[edge.v]) {
                // N번째 라운드에서도 값이 갱신된다면 음수 사이클이 존재하는 것
                System.out.println("그래프에 음수 사이클이 존재합니다.");
                return null;
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int n = 3;
        ArrayList<Edge> edges = new ArrayList<>();
        
        edges.add(new Edge(1, 2, 4));
        edges.add(new Edge(1, 3, 3));
        edges.add(new Edge(2, 3, -1)); // 음수 가중치
        edges.add(new Edge(3, 1, -2));

        int startNode = 1;
        long[] distances = bellmanFord(startNode, n, edges);

        if (distances != null) {
            System.out.println(startNode + "번 노드에서 출발하는 최단 거리:");
            for (int i = 1; i <= n; i++) {
                if (distances[i] == Long.MAX_VALUE) {
                    System.out.println("노드 " + i + ": 도달 불가");
                } else {
                    System.out.println("노드 " + i + ": " + distances[i]);
                }
            }
        }
    }
}