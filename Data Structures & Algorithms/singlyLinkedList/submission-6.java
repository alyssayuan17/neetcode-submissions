class LinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node first;

    public LinkedList() {
        this.first = null;
    }

    public int get(int index) {
        Node curr = first;

        for (int i = 0; i < index; i++) {
            if (curr == null) {
                return -1;
            }
            curr = curr.next;
        }
        if (curr == null) {
            return -1;
        } else {
            return curr.val;
        }
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = first;
        first = newNode;
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        
        if (first == null) {
            first = newNode;
            return;
        } 

        Node curr = first;

        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public boolean remove(int index) {

        if (first == null) {
            return false;
        }

        if (index == 0) {
            first = first.next;
            return true;
        }

        Node curr = first;

        for (int i = 0; i < index - 1; i++) {
            if (curr.next == null) {
                return false;
            }
            curr = curr.next;
        }

        if (curr.next == null) {
            curr = curr.next;
            return false;
        }

        curr.next = curr.next.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> vals = new ArrayList<>();
        Node curr = first; 

        while(curr != null) {
            vals.add(curr.val);
            curr = curr.next;
        }

        return vals; 
    }
}
