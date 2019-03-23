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
         Node storage = headReference;
         int counter = 1;
         for (; headReference.getReferenceToNextNode()!= null; counter++)
             headReference = headReference.getReferenceToNextNode();
         headReference = storage;
         return counter;
     }

     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
    public String toString() {
        Node storage = headReference;
        String output = headReference.getCargoReference().toString() + ",";
        while (headReference.getReferenceToNextNode() != null) {
            headReference = headReference.getReferenceToNextNode();
            output += headReference.getCargoReference() + ",";
        }
        headReference = storage;
        return "[" + output + "]";
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
