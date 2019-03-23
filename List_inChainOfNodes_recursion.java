/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes {
    private Node headReference;

    /**
      Construct an empty list
     */
    public List_inChainOfNodes() {
        headReference = new Node();
    }

    /**
      @return the number of elements in this list
     */
    public int size() {
        return size(headReference);
    }

    public int size(Node currentNode) {
        if (currentNode.getReferenceToNextNode() == null)
            return 1;
        else
            return 1 + size(currentNode.getReferenceToNextNode());
    }

     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
    public String toString() {
        return "[" + toString(headReference) + "]";
    }

    public String toString(Node currentNode) {
        if (currentNode.getReferenceToNextNode() == null)
            return currentNode.getCargoReference().toString() + ",";
        else
            return currentNode.getCargoReference().toString() + ","
            + toString(currentNode.getReferenceToNextNode());
    }

    /**
      Append @value to the head of this list.
      @return true, in keeping with conventions discussed
     */
     public boolean addAsHead( Object val) {
         if (headReference.getCargoReference() == null)
             headReference = new Node(val);
         else {
             Node temp = new Node(val, headReference);
             headReference = temp;
        }
         return true;
     }
}
