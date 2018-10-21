import heap.*;

public class Main {


    public static void main(String[] args){
        SortedHeap<Integer> integerSortedHeap = new SortedHeap(15,new ComparatorInt());
        /**
         * Creation of a heap
         * Capacity = 15 nodes.
         * Type of elements = Integers.
         * Elements : 450, 451, 452, 453, 454, 233, 3, -3, 599990, 0.
         * Prints the nodes and their elements
         */


        for (int i = 0; i<5; i++){
            integerSortedHeap.insertElement(450+i);
        }
        integerSortedHeap.insertElement(233);
        integerSortedHeap.insertElement(3);
        integerSortedHeap.insertElement(-3);
        integerSortedHeap.insertElement(599990);
        integerSortedHeap.insertElement(0);

        System.out.println(integerSortedHeap.affich());


    }
}
