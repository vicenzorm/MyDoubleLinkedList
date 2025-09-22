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
        this.next = null;
    }

    public Node(String value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public void setNext(Node node) { this.next = node; }
    public Node getNext() { return this.next; }

    public void setPrev(Node node) { this.prev = node; }
    public Node getPrev() { return this.prev; }

    public void setValue(String value) { this.value = value; }
    public String getValue() { return this.value; }


}