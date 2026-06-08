class TrieNode:
    def __init__(self):
        self.children = {}      # 자식 노드들을 저장할 딕셔너리
        self.is_end_of_word = False # 단어의 끝을 표시하는 플래그

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        """단어를 트라이에 삽입합니다. / Insert a word into the trie."""
        curr = self.root
        for char in word:
            if char not in curr.children:
                curr.children[char] = TrieNode()
            curr = curr.children[char]
        curr.is_end_of_word = True # 단어 삽입 완료 후 끝을 표시

    def search(self, word):
        """트라이에 해당 단어가 완벽히 존재하는지 찾습니다. / Search for a complete word."""
        curr = self.root
        for char in word:
            if char not in curr.children:
                return False
            curr = curr.children[char]
        return curr.is_end_of_word # 접두사만 일치하는 것이 아니라, 단어의 끝인지 확인

    def starts_with(self, prefix):
        """해당 접두사로 시작하는 단어가 존재하는지 확인합니다. / Returns true if there is any word in the trie that starts with the given prefix."""
        curr = self.root
        for char in prefix:
            if char not in curr.children:
                return False
            curr = curr.children[char]
        return True # 접두사까지만 무사히 도달했다면 끝 플래그와 상관없이 True 반환

# 사용 예시
if __name__ == "__main__":
    trie = Trie()
    trie.insert("apple")
    print(trie.search("apple"))      # Output: True
    print(trie.search("app"))        # Output: False
    print(trie.starts_with("app"))   # Output: True
    
    trie.insert("app")
    print(trie.search("app"))        # Output: True