public class Node {

    private String value;
    private Node next;
    private Node prev;

    public Node(String value, Node prev, Node next) {
        this.next = next;
        this.value = value;
        this.prev = prev;
    }
    public Node(String value, Node prev) {
        this.value = value;
        this.prev = prev;
    }
    
    public Node(String value, Node next) {
        this.next = next;
        this.value = value;
    }
}