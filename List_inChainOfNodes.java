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
        return 0;
    }

     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
    public String toString() {
        System.out.println("Wait, ");
        return headReference.getReferenceToNextNode().toString();
    }

    /**
      Append @value to the head of this list.
      @return true, in keeping with conventions discussed
     */
     public boolean addAsHead( Object val) {
         if (headReference.getReferenceToNextNode() == null)
             headReference.setReferenceToNextNode(new Node(val));
         else {
             Node temp = new Node(val);
             temp.setReferenceToNextNode(headReference.getReferenceToNextNode());
             headReference.setReferenceToNextNode(temp);
        }
         return true;
     }
}
