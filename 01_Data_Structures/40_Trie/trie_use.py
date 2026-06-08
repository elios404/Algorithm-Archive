def trie_example():
    # 루트 노드 역할을 할 빈 딕셔너리
    trie = {}

    # 1. 삽입 (Insert)
    words = ["apple", "app", "banana"]
    for word in words:
        curr = trie
        for char in word:
            if char not in curr:
                curr[char] = {} # 문자가 없으면 새로운 딕셔너리 생성
            curr = curr[char]
        curr['*'] = True # 단어의 끝을 나타내는 특수 키('*') 삽입

    # 2. 탐색 (Search)
    target = "apple"
    curr = trie
    found = True
    for char in target:
        if char not in curr:
            found = False
            break
        curr = curr[char]
    
    # 끝까지 탐색 후 '*' 키가 있다면 완벽한 단어 존재
    if found and '*' in curr:
        print(f"'{target}' exists!") # Output: 'apple' exists!

if __name__ == "__main__":
    trie_example()