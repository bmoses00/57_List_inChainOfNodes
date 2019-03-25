/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes {
    private Node headReference;

    /**
      Construct an empty list
     */

    /**
      @return the number of elements in this list
     */
    public int size() {
        if (headReference == null) return 0;
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
         Node temp = new Node(val, headReference);
         headReference = temp;
         return true;
     }
     // not sure if the amount of code here can be reduced
     public boolean add(int index, Object val) {
         if (index == 0) return addAsHead(val);
         return add(index, val, headReference);
     }
     public boolean add(int index, Object val, Node currentNode) {
         if (index == 1) {
             Node temp = new Node(val, currentNode.getReferenceToNextNode());
             currentNode.setReferenceToNextNode(temp);
             return true;
         }
         else
             return add(index - 1, val, currentNode.getReferenceToNextNode());
     }

     public Object get(int index) {
         return get(index, headReference);
     }
     public Object get(int index, Node currentNode) {
         if (index == 0) return currentNode.getCargoReference();
         else return get(index - 1, currentNode.getReferenceToNextNode());
     }

     public boolean remove(int index) {
         if (index == 0) {
             headReference = headReference.getReferenceToNextNode();
             return true;
         }
         return remove(index, headReference);
     }
     public boolean remove(int index, Node currentNode) {
         if (index == 1) {
             currentNode.setReferenceToNextNode((currentNode.getReferenceToNextNode()).getReferenceToNextNode());
             return true;
         }
         else {
             return remove(index - 1, currentNode.getReferenceToNextNode());
         }
     }

     public boolean set(int index, Object val) {
         return set(index, val, headReference);
     }
     public boolean set(int index, Object val, Node currentNode) {
         if (index == 0) {
             currentNode.setCargoReference(val);
             return true;
         }
         else
            return set(index - 1, val, currentNode.getReferenceToNextNode());
     }
}
