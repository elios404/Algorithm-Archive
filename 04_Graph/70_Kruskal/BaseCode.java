import java.util.ArrayList;
import java.util.Collections;

public class BaseCode {

    // 간선 클래스 정의 (가중치 기준 정렬을 위해 Comparable 구현)
    static class Edge implements Comparable<Edge> {
        int cost;
        int a;
        int b;

        public Edge(int cost, int a, int b) {
            this.cost = cost;
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    // 1. Union-Find 함수 정의
    public static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]); // 경로 압축
    }

    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static int kruskal(int v, ArrayList<Edge> edges) {
        int resultCost = 0;
        int[] parent = new int[v + 1];

        // 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 1. 간선을 비용 순으로 오름차순 정렬
        Collections.sort(edges);

        // 2. 간선을 하나씩 확인하며 MST 구성
        for (Edge edge : edges) {
            // 3. 사이클이 발생하지 않는 경우에만 포함 (부모가 다를 때)
            if (find(parent, edge.a) != find(parent, edge.b)) {
                union(parent, edge.a, edge.b); // 노드 연결
                resultCost += edge.cost;       // 비용 누적
            }
        }

        return resultCost;
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> edges = new ArrayList<>();
        
        edges.add(new Edge(29, 1, 2));
        edges.add(new Edge(75, 1, 5));
        edges.add(new Edge(35, 2, 3));
        edges.add(new Edge(34, 2, 6));
        edges.add(new Edge(7, 3, 4));
        edges.add(new Edge(23, 4, 6));
        edges.add(new Edge(13, 4, 7));
        edges.add(new Edge(53, 5, 6));
        edges.add(new Edge(25, 6, 7));

        int totalCost = kruskal(v, edges);
        System.out.println("모든 노드를 연결하는 최소 비용: " + totalCost);
    }
}