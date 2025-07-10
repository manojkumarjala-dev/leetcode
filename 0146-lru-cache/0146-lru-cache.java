class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k; value = v;
        }
    }

    private Map<Integer, Node> map;
    private int capacity;
    private Node head, tail; // dummy head and tail nodes

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Remove a node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add a node right after head (most recently used position)
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);

        // Move accessed node to front (MRU)
        remove(node);
        addToFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update existing node and move to front
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToFront(node);
        } else {
            if (map.size() == capacity) {
                // Evict LRU node
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            // Insert new node at front
            Node node = new Node(key, value);
            map.put(key, node);
            addToFront(node);
        }
    }
}
