import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.List;

public class BaseCode {

    public static List<Integer> topologicalSort(int v, int[][] edges) {
        // 1. 진입차수 배열 및 그래프 초기화
        int[] inDegree = new int[v + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        // 2. 방향 간선 연결 및 진입차수 기록
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b); // A -> B
            inDegree[b]++;       // B의 진입차수 증가
        }

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        // 3. 진입차수가 0인 노드를 찾아 큐에 삽입
        for (int i = 1; i <= v; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 4. 큐를 이용한 위상 정렬 수행
        while (!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);

            // 해당 노드와 연결된 인접 노드 확인
            for (int nextNode : graph.get(now)) {
                inDegree[nextNode]--; // 간선 제거 (진입차수 1 감소)

                // 새롭게 진입차수가 0이 되었다면 큐에 삽입
                if (inDegree[nextNode] == 0) {
                    queue.offer(nextNode);
                }
            }
        }

        // 5. 사이클 존재 여부 확인
        if (result.size() != v) {
            System.out.println("그래프에 사이클이 존재합니다.");
            return new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args) {
        int v = 6;
        int[][] edges = {{1, 4}, {2, 4}, {3, 5}, {4, 6}, {5, 6}};

        List<Integer> result = topologicalSort(v, edges);
        System.out.println("위상 정렬 결과: " + result);
    }
}