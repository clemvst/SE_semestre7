import heap.*;
import java.util.Iterator;

public class Tests {

    public void Tests(){
        SortedHeap<Integer> integerSortedHeap = new SortedHeap(20, new ComparatorInt());
        for( int i = 0; i<5 ; i++){
            integerSortedHeap.insertElement(450+i);
        }
        integerSortedHeap.insertElement(233);
        integerSortedHeap.insertElement(3);
        integerSortedHeap.insertElement(-3);
        integerSortedHeap.insertElement(599990);
        integerSortedHeap.insertElement(0);

        assert integerSortedHeap.elementback(0) == 599990;
        assert integerSortedHeap.elementback(1) == 233;
        assert integerSortedHeap.elementback(2) == 164;
        assert integerSortedHeap.popElement() == 599990;

        assert integerSortedHeap.isEmpty();
        assert integerSortedHeap.size() == 18;

    }
}