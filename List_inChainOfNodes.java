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

        String output = size() + " elements: [";
        Node node = headReference;
        for (; node != null; node = node.getReferenceToNextNode())
            output += node.getCargoReference() + ",";
        return output + "]";
    }

    public Node getNode(int index) {
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
         Node node = getNode(index - 1); // index before where we're adding
         node.setReferenceToNextNode(new Node(val, node.getReferenceToNextNode()));
         return true;
     }

     public Object get(int index) {
         return getNode(index).getCargoReference();
     }

     public Object remove(int index) {
         Object oldValue = getNode(index).getCargoReference();
         if (index == 0) headReference = headReference.getReferenceToNextNode();
         else getNode(index - 1).setReferenceToNextNode(getNode(index + 1));

         // more efficient:
         /*
         Node node = getNode(index - 1);
         if (index == 0) headReference = headReference.getReferenceToNextNode();
         else node.setReferenceToNextNode(
                         node.getReferenceToNextNode().getReferenceToNextNode());
                         */
         return oldValue;
     }

     public Node set(int index, Object val) {
         Node oldValue = getNode(index);
         getNode(index).setCargoReference(val);
         return oldValue;
     }
}
