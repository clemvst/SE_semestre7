import heap.*;
import java.util.Iterator;

public class Tests {

    public void Tests(){
        SortedHeap<Integer> integerSortedHeap = new SortedHeap(20, new ComparatorInt());
        for( int i = 0, i<15 ; i++){
            integerSortedHeap.insertElement(150+i);
        }
        integerSortedHeap.insertElement(233);
        integerSortedHeap.insertElement(3);
        integerSortedHeap.insertElement(-3);
        integerSortedHeap.insertElement(599990);
        integerSortedHeap.insertElement(0);

        assert(599990,(int)integerSortedHeap.elementback(0));
        assert(3,(int)integerSortedHeap.elementback(1));
        assert(599990,(int)integerSortedHeap.popElement());
        assert(233,(int)integerSortedHeap.popElement());
        assert(233,integerSortedHeap.isEmpty());
        assert(3,integerSortedHeap.size());

    }
}