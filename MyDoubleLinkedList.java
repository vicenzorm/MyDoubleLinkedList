public class MyDoubleLinkedList {

    private Sentinel trailer;
    private Sentinel header;

    private Node currentNode;
    private Node opositeNode;

    private int count;

    public MyDoubleLinkedList(Node node) {
        this.header = new Sentinel();
        this.trailer = new Sentinel();

        this.header.setPointingTo(node);
        this.trailer.setPointingToOposite(node);

        this.count = 1;
    }

    public void add(String element) {
        Node newNode = new Node(element);
        opositeNode = this.trailer.getPointingToOposite();

        opositeNode.setNext(newNode);
        newNode.setPrev(opositeNode);
    
        this.trailer.setPointingToOposite(newNode);
        this.count++;
    }

    public void add(int index,String element) {
        Node newNode = new Node(element);
        opositeNode = this.trailer.getPointingToOposite();
        currentNode = this.header.getPointingTo();

        if(index > this.count || index < 0) {
        System.out.println("Index out of bounds");
        return;
        } else if(index == 0) {
            header.setPointingTo(newNode);
            newNode.setNext(currentNode);
            currentNode.setPrev(newNode);
        } else if(index == this.count) {
            trailer.setPointingToOposite(newNode);
            newNode.setPrev(opositeNode);
            opositeNode.setNext(newNode);
        } else if(index > (this.count / 2)) {
            for(int i = count - 1; i > index; i--) {
                opositeNode = opositeNode.getPrev();
            }
            Node nodeToBePrev = opositeNode.getPrev();
            nodeToBePrev.setNext(newNode);
            newNode.setPrev(nodeToBePrev);
            newNode.setNext(opositeNode);
            opositeNode.setPrev(newNode);

        } else if(index <= (this.count/2)) {
            for(int i = 0; i < index; i++ ) {
                currentNode = currentNode.getNext();
            }
            Node nodeToBePrev = currentNode.getPrev();
            nodeToBePrev.setNext(newNode);
            newNode.setNext(currentNode);
            newNode.setPrev(nodeToBePrev);
            currentNode.setPrev(newNode);
        }
        this.count++;
    }

    public String get(int index) { 
        opositeNode = trailer.getPointingToOposite();
        currentNode = header.getPointingTo();

        if(index >= this.count || index < 0) {
        System.out.println("Index out of bounds");
        } else if(index == 0) {
            return currentNode.getValue();
        } else if(index == this.count - 1) {
            return opositeNode.getValue();
        } else if(index > (this.count / 2)) {
            for(int i = count - 1; i > index; i--) {
                opositeNode = opositeNode.getPrev();
            }
            return opositeNode.getValue();
        } else if(index <= (this.count/2)) {
            for(int i = 0; i < index; i++ ) {
                currentNode = currentNode.getNext();
            }
            return currentNode.getValue();
        }
        return "";
    }
    
    public void set(int index, String element) {
        opositeNode = trailer.getPointingToOposite();
        currentNode = header.getPointingTo();

        if(index >= this.count || index < 0) {
            System.out.println("Index out of bounds");
        } else if(index == 0) {
            currentNode.setValue(element);
        } else if(index == this.count - 1) {
            opositeNode.setValue(element);
        } else if(index > (this.count / 2)) {
            for(int i = count - 1; i > index; i--) {
                opositeNode = opositeNode.getPrev();
            }
            opositeNode.setValue(element);
        } else if(index <= (this.count/2)) {
            for(int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setValue(element);
        }
    } 

    public void remove(String element) {
        Node node = header.getPointingTo();
        while (node != null) {
            if (node.getValue().equals(element)) {
                Node prev = node.getPrev();
                Node next = node.getNext();
                if (prev != null) prev.setNext(next);
                if (next != null) next.setPrev(prev);

                if (node == header.getPointingTo()) header.setPointingTo(next);
                if (node == trailer.getPointingToOposite()) trailer.setPointingToOposite(prev);

                this.count--;
                break;
            }
            node = node.getNext();
        }
    }

    public void removeByIndex (int index) {
        Node node = header.getPointingTo();
        int i = 0;
        if(index >= this.count || index < 0) {
            System.out.println("Index out of bounds");
            return;
        }

        while (i < count) {
            if (i == index) {
                Node prev = node.getPrev();
                Node next = node.getNext();
                if (prev != null) prev.setNext(next);
                if (next != null) next.setPrev(prev);

                if (node == header.getPointingTo()) header.setPointingTo(next);
                if (node == trailer.getPointingToOposite()) trailer.setPointingToOposite(prev);

                this.count--;
                break;
            }
            i++;
            node = node.getNext();
        }
    }

    public boolean isEmpty() { return header.getPointingTo() == null; }

    public int size() { return this.count; }

    public boolean contains(String element) {
        Node currentNode = header.getPointingTo();
        int i = 0;
        while(i < this.count) {
            if (currentNode.getValue().equals(element)) {
                return true;
            }
            i++;
            currentNode = currentNode.getNext();
        }
        return false;
    }
    
    public int indexOf(String element) {
        Node currentNode = header.getPointingTo();
        int i = 0;
        while(i < this.count) {
            if (currentNode.getValue().equals(element)) {
                return i;
            }
            i++;
            currentNode = currentNode.getNext();
        }
        return -1;
     }
    
    public void clear() {
        header.setPointingTo(null);
        trailer.setPointingToOposite(null);
        this.count = 0;
    } 
}