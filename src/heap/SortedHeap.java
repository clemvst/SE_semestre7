package heap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;



public class SortedHeap<E> implements Heap<E> {
    private int size = 0;
    private Object queue[];
    private final int capacity;
    private final Comparator<E> comparator;

    public SortedHeap(int capacity, Comparator<E> comparator) {
        /**
         * this is the constructor SortedHeap
         */
        this.capacity = capacity;
        this.size = 0;
        this.comparator = comparator;
        this.queue = new Object[this.capacity];
    }

    public String affich() {
        String ch = "";
        for (int i = 0; i < this.capacity; i++) {
            ch += ("node number " + i + " : " + this.queue[i] + "\n");
        }
        return ch;
    }

    private class HeapArrayIterator<E> implements Iterator<E> {
        /**
         * This is this iterator
         */
        private int id;

        private HeapArrayIterator() {
            this.id = -1;
        }

        public boolean hasNext() {
            return (this.id<size-1);
            /**
             * if everything has been done, id equals size and there is nothing left to do
             * so it returns FALSE
             */
        }


        public E next() throws NoSuchElementException {
            /**
             * returns the next element in the iteration or sends an exception when no element
             */
            if (hasNext()) {

                return (E) SortedHeap.this.queue[++id];
            } else {
                throw new NoSuchElementException("No element next");
            }
        }
    }

    public Iterator<E> iterator() {
        return new HeapArrayIterator<E>();
    }

    private int father_node(int node){
        if (node>0) {
            return (node - 1) / 2;
        }
        else{
            return 0;
        }
    }

    private int mini(){
        int minimum = capacity/2;
        E item_min = (E)queue[minimum];
        for (int i = minimum;i<capacity;i++){
            if (comparator.compare((E)queue[i],item_min)<0) {
                minimum = i;
                item_min = (E) queue[minimum];
            }
        }
        return minimum;
    }


    private void switching(int a, int b){
        E value = (E) queue[a];
        queue[a] = (E) queue[b];
        queue[b] = value;
    }

    private void go_up(int node) {
        int father_node = father_node(node);
        while (comparator.compare((E) queue[father_node], (E) queue[node]) < 0) {
            /**
             * while father_node (father) < node (child), we reverse father and child
             */
            switching(father_node, node);
            node=father_node(node);

        }
    }


    public boolean insertElement(E e) {
        if (this.size != this.capacity) {
            queue[size] = e;
            go_up(size);
            size++;
        } else if (this.size == this.capacity) {
            /**
             * If the capacity has been reached.
             */
            this.queue = Arrays.copyOf(queue, capacity * 2);
        }else{
            int mini = mini();
            queue[mini] = e;
            go_up(mini);
        }
        return true;
    }


    public E popElement() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("No element");
        } else {
            size--;
            int mini = mini();
            queue[mini]=queue[size];
            queue[size] = null;
            go_up(mini);
            return (E)queue[mini];
        }
    }

    public E element() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Empty object");
        } else {
            return (E) queue[0];
        }
    }

    public boolean isEmpty() {
        /**
         * returns true if heap is empty
         */
        return size == 0;
    }

    public int size() {
        /**
         * returns the size of the heap
         */
        return size;
    }

    public E elementback(int node) throws NoSuchElementException{
        if (node>=size()){
            throw new NoSuchElementException("The node number is bigger than the size");
        }
        else{
            return (E)queue[node];
        }
    }

}