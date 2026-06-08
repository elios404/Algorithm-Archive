import java.util.HashMap;

public class BaseCode {
    // 내부 노드 클래스
    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public BaseCode() {
        root = new TrieNode();
    }

    /**
     * 단어를 트라이에 삽입합니다. / Insert a word into the trie.
     */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // 해당 문자가 자식에 없으면 새로 추가, 있으면 해당 노드로 이동
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true; // 단어의 끝 표시
    }

    /**
     * 트라이에 해당 단어가 완벽히 존재하는지 찾습니다. / Search for a complete word.
     */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = curr.children.get(ch);
            if (node == null) {
                return false;
            }
            curr = node;
        }
        return curr.isEndOfWord; // 접두사가 아닌 진짜 단어의 끝인지 반환
    }

    /**
     * 해당 접두사로 시작하는 단어가 존재하는지 확인합니다. / Check if any word starts with prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode node = curr.children.get(ch);
            if (node == null) {
                return false;
            }
            curr = node;
        }
        return true; // 무사히 순회했다면 해당 접두사를 가진 단어가 존재함
    }

    // 사용 예시
    public static void main(String[] args) {
        BaseCode trie = new BaseCode();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // Output: true
        System.out.println(trie.search("app"));     // Output: false
        System.out.println(trie.startsWith("app")); // Output: true
        
        trie.insert("app");
        System.out.println(trie.search("app"));     // Output: true
    }
}