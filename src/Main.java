import heap.*;

public class Main {


    public static void main(String[] args){
        SortedHeap<Integer> integerSortedHeap = new SortedHeap(20,new ComparatorInt());
        for (int i = 0; i<15; i++){
            integerSortedHeap.insertElement(150+i);
        }
        integerSortedHeap.insertElement(233);
        integerSortedHeap.insertElement(3);
        integerSortedHeap.insertElement(-3);
        integerSortedHeap.insertElement(599990);
        integerSortedHeap.insertElement(0);

        System.out.println(integerSortedHeap);


    }
}
