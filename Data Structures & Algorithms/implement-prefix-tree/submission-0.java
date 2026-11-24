// new class for TrieNode
class TrieNode {

	private boolean isWord;
	private HashMap<Character, TrieNode> nextLevel;

	public TrieNode() {
		this.isWord = isWord;
		this.nextLevel = new HashMap<>();
    }

    public HashMap<Character, TrieNode> getMap() {
        return nextLevel;
    }

    public boolean setWord() {
        isWord = true;
        return true;
    }

    public boolean isWord() {
        return isWord;
    }
}


class PrefixTree {

    private TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        if (search(word)) {
            return;
        }

        TrieNode node = root;

        // loop through word 
        for (char c : word.toCharArray()) {
            if (!node.getMap().containsKey(c)) {
                TrieNode newNode = new TrieNode();
                node.getMap().put(c, newNode);
            }

            node = node.nextLevel.get(c);
        }

        node.setWord(); 
    }

    public boolean search(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            if (!node.getMap().containsKey(c)) {
                return false;
            }
            node = node.getMap().get(c);
        }

        if (!node.isWord()) {
            return false;
        }

        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (char c : prefix.toCharArray()) {
            if (!node.getMap().containsKey(c)) {
                return false;
            }
            node = node.getMap().get(c);
        }

        return true;
    }
}
