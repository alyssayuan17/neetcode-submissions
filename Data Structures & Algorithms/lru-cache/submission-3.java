class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    // get(), put() -> counts as used
    // instead of a queue (LIFO) or a hashmap, what if we can combine the two?
    // - queue has no convenient lookup/storage for key-value pairs
    // - hashmap has no preservation of order
    // -> implement a separate class to keep track of order
    // e.g.
    // capacity = 3
    // put [2,3], put [1,4], put [5,7] -> put [3,7] -> [2,3] should be removed
    // put [2,3], put [1,4], put [5,7] -> put [2,4] -> [1,4], [5,7], [2,4] (front)
    // put [2,3], put [1,4], put [5,7] -> get [1] -> [2,3], [5,7], [1,4] (front)
    // put [2,3], put [1,4], put [5,7] -> get[3] -> -1
    // time: O(1) for both functions, since we are using hashmap
    // space: O(n), where n is capacity -> worst case store n pairs in hashmap

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node tail; // MRU -> add new to tail
    private Node head; // LRU
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.tail = null;
        this.head = null;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            // move to tail and remove from current position
            removeNode(node);
            updateTail(node);

            return node.val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            
            removeNode(node);
            updateTail(node);
        } else {
            if (map.size() == capacity) {
                removeHead(); // remove LRU
            }
            
            Node node = new Node(key, value);
            map.put(key, node);

            updateTail(node);
        }
    }

    // helper function to update tail
    // O(1) time 
    public void updateTail(Node node) {
        if (tail == null) {
            tail = node;
            head = node;
            node.next = null;
            node.prev = null;
        } else {
            node.prev = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }
    }

    public void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            // must be the head
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            // must be the tail
            tail = node.prev;
        }

        node.prev = null;
        node.next = null;
    }

    public void removeHead() {
        if (head == null) {
            return;
        }
        
        Node oldHead = head;

        head = head.next;
        
        // check if head was the only node in the list
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }

        map.remove(oldHead.key); 
    }
}
