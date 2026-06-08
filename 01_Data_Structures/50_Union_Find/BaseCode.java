public class BaseCode {
    private int[] parent;
    private int[] rank;

    public BaseCode(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; // 처음에는 자기 자신을 부모로 가리킴
            rank[i] = 0;   // 초기 랭크는 0
        }
    }

    /**
     * 특정 원소가 속한 루트 노드를 찾습니다. (Path Compression)
     */
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        // 재귀적으로 루트를 찾고, 돌아오면서 모든 부모를 루트로 갱신
        return parent[x] = find(parent[x]); 
    }

    /**
     * 두 원소가 속한 집합을 하나로 합칩니다. (Union by Rank)
     */
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }

    /**
     * 두 원소가 같은 집합에 속해 있는지 확인합니다.
     */
    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }

    public static void main(String[] args) {
        BaseCode uf = new BaseCode(6);
        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(4, 5);

        System.out.println(uf.isConnected(1, 3)); // Output: true
        System.out.println(uf.isConnected(1, 5)); // Output: false
    }
}