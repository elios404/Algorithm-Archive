import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BaseCode {

    // 그래프 연결을 표현할 내부 노드 클래스
    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        // 우선순위 큐에서 거리가 짧은 것이 먼저 나오도록 정렬 기준 설정 (Min-Heap)
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int[] dijkstra(int start, ArrayList<ArrayList<Node>> graph, int v) {
        // 1. 최단 거리 테이블 초기화
        int[] distance = new int[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 2. 우선순위 큐 생성 및 시작 노드 설정
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            // 가장 최단 거리가 짧은 노드 꺼내기
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;

            // 3. 이미 처리된(더 짧은 거리가 테이블에 기록된) 노드라면 무시
            if (distance[now] < dist) {
                continue;
            }

            // 4. 현재 노드와 인접한 노드들을 확인
            for (Node next : graph.get(now)) {
                int cost = dist + next.distance;

                // 5. 현재 노드를 거쳐서 가는 것이 더 짧은 경우 갱신
                if (cost < distance[next.index]) {
                    distance[next.index] = cost;
                    pq.offer(new Node(next.index, cost));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 간선 정보 입력 (a에서 b로 가는 비용 c)
        graph.get(1).add(new Node(2, 2));
        graph.get(1).add(new Node(3, 5));
        graph.get(1).add(new Node(4, 1));
        graph.get(2).add(new Node(3, 3));
        graph.get(2).add(new Node(4, 2));
        graph.get(3).add(new Node(2, 3));
        graph.get(3).add(new Node(6, 5));
        graph.get(4).add(new Node(3, 3));
        graph.get(4).add(new Node(5, 1));
        graph.get(5).add(new Node(3, 1));
        graph.get(5).add(new Node(6, 2));

        int startNode = 1;
        int[] distances = dijkstra(startNode, graph, v);

        System.out.println(startNode + "번 노드에서 출발하는 최단 거리:");
        for (int i = 1; i <= v; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("노드 " + i + ": 도달 불가");
            } else {
                System.out.println("노드 " + i + ": " + distances[i]);
            }
        }
    }
}