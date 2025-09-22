public class Sentinel {

    private Node pointingTo;
    private Node pointingToOposite;

    public Sentinel() { }

    public void setPointingTo(Node node) { this.pointingTo = node; }
    public Node getPointingTo() { return this.pointingTo; }

    public void setPointingToOposite(Node node) { this.pointingToOposite = node; }
    public Node getPointingToOposite() { return this.pointingToOposite; }
}