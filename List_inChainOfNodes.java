/**
  Represent a list, implemented in a chain of nodes
 */
public class List_inChainOfNodes {
    private Node headReference;
    /**
      @return the number of elements in this list
     */
    public int size() {
        if (headReference == null) return 0;

        int counter = 1;
        Node node = headReference;
        for (; node.getReferenceToNextNode() != null
             ; counter++, node = node.getReferenceToNextNode()) {}
        return counter;
    }
     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
    public String toString() {
        if (headReference == null) return "[]";
        else return size() + " [" + toString(headReference) + "]";
    }
    public String toString(Node currentNode) {
        if (currentNode.getReferenceToNextNode() == null)
            return currentNode.getCargoReference().toString() + ",";
        else
            return currentNode.getCargoReference().toString() + ","
            + toString(currentNode.getReferenceToNextNode());
    }

    public Node findCorrectNode(int index) {
        Node node = headReference;
        for (; index > 0; index--, node = node.getReferenceToNextNode()) {}
        return node;
    }

    /**
      Append @value to the head of this list.
      @return true, in keeping with conventions discussed
     */
     public boolean addAsHead( Object val) {
         headReference = new Node(val, headReference);
         return true;
     }
     public boolean add(int index, Object val) {
         if (index == 0) return addAsHead(val);
         findCorrectNode(index - 1).setReferenceToNextNode(
         new Node(val, findCorrectNode(index)));
         return true;
     }

     public Object get(int index) {
         return findCorrectNode(index).getCargoReference();
     }

     public Object remove(int index) {
         Object oldValue = findCorrectNode(index).getCargoReference();
         if (index == 0) headReference = headReference.getReferenceToNextNode();
         else findCorrectNode(index - 1).setReferenceToNextNode(
                                                    findCorrectNode(index + 1));
         return oldValue;
     }

     public Node set(int index, Object val) {
         Node oldValue = findCorrectNode(index);
         findCorrectNode(index).setCargoReference(val);
         return oldValue;
     }
}
