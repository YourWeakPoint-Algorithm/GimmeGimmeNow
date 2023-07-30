public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

public class LinkedList {
    private Node head;
    private Node tail;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));

        list.reverse(list);
        print(list);
    }

    private void reverse(LinkedList list) {
        Node prev = null;
        Node curr = list.head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.tail = head;
        this.head = prev;
    }

    private static void print(LinkedList list) {
        Node pointer = list.head;
        while (pointer != null) {
            System.out.print(pointer.value + " ");
            pointer = pointer.next;
        }
    }

    private void add(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }
    }
}
