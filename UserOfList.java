/**
 Test list features.
 */
public class UserOfList {
    public static void main( String[] args ) {
        List_inChainOfNodes list = new List_inChainOfNodes();

        System.out.println( "number of elements: " + list.size() );

        // the spec requests that toString include the size
        System.out.println( "empty list: " + list
                          + System.lineSeparator());

        /* Populate the list with elements.
           Create the test data in an array, for the programming
           convenience of being able to loop through it.
        */

        String[] elements = new String[]{"y","u","t","S",};
            /* convenient syntax      ^^^^^^^^^^^^^^^^^^^^
               for convenient way to init an array of Strings */
        int elemIndex;
        for( String elem : elements ) {
            list.addAsHead( elem);
            System.out.println( "number of elements: " + list.size() );
        }
        System.out.println(list);

        list.add(3, "d");
        System.out.println("after adding 'd' in middle: " + list);

        list.add(0, "a");
        System.out.println("after adding 'a' at beginning: " + list);

        list.add(6, "h");
        System.out.println("after adding 'h' at end: " + list);

        System.out.println("expecting a, received: " + list.get(0));
        System.out.println("expecting u, received: " + list.get(3));
        System.out.println("expecting h, received: " + list.get(6));

        list.remove(0);
        System.out.println("expecting S,t,u,d,y,h, received: " + list);
        list.remove(5);
        System.out.println("expecting S,t,u,d,y, received: " + list);
        list.remove(3);
        System.out.println("expecting S,t,u,y, received: " + list);
        list.set(1, "a");
        list.set(2, "d");
        list.remove(3);
        System.out.println("expecting S,a,d, received: " + list);

        System.out.println(list.getNode(0).getCargoReference());
        System.out.println(list.getNode(1).getCargoReference());
        System.out.println(list.getNode(2).getCargoReference());
    }
}
