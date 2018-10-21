package heap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;



public class SortedHeap<E> implements Heap<E> {
    private int size = 0;
    private Object queue[];
    private final int capacity;
    private final Comparator<? super E> comparator;

    public SortedHeap(int capacity, Comparator<? super E> comparator) {
        /**
         * this is the constructor SortedHeap
         */
        this.capacity = capacity;
        this.size = 0;
        this.comparator = comparator;
        this.queue = new Object[this.capacity];
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
            return !(SortedHeap.this.capacity - 1 == id);
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
                //id += 1;
                return (E) SortedHeap.this.queue[++id];
            } else {
                throw new NoSuchElementException("No element next");
            }
        }
    }

    public Iterator<E> iterator() {
        return new HeapArrayIterator<E>();
    }


    private void go_up(int node) {
        int father_node = (node - 1) / 2;
        E value = (E) queue[father_node];
        while (comparator.compare(value, (E) queue[node]) < 0) {
            /**
             * while father_node (father) < node (child), we reverse father and child
             */
            queue[father_node] = (E) queue[node];
            queue[node] = value;
        }
    }


    private void go_down() {
        /**
         * k represents the layer and l represents a spot within the layer k
         */
        int k = 0;
        int l = 0;

        int node = (int) (l + Math.pow(2, k) - 1);
        int node_child1 = (int) (2 * l + Math.pow(2, k + 1) - 1);
        int node_child2 = (int) (2 * l + Math.pow(2, k + 1));
        E value = (E) queue[node];

        while (comparator.compare(value, (E) queue[node_child1]) < 0 || comparator.compare(value, (E) queue[node_child2]) < 0) {
            /**
             * -- reverses the father and the biggest child --
             * first we compare each child with his father
             * then we compare the children and pick the biggest
             * finally we reverse the biggest child and the father
             */
            int chosen_child;
            if (comparator.compare((E) queue[node_child1], (E) queue[node_child2]) < 0) {
                /**
                 * tests if the child 2 is bigger than the child 1
                 * if yes, we reverse father and child 2
                 */
                chosen_child = node_child2;
            } else {
                chosen_child = node_child1;
            }

            queue[node] = (E) queue[chosen_child];
            queue[chosen_child] = value;

        }

    }

    public boolean insertElement(E e) {
        if (this.size < this.capacity) {
            queue[size] = e;
            go_up(size);
            size++;
        } else if (this.size == this.capacity) {
            /**
             * If the capacity has been reached.
             */
            this.queue = Arrays.copyOf(queue, capacity * 2);
        }
        return true;
    }


    public E popElement() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("No element");
        } else {
            E returned = (E) queue[0];
            size--;
            queue[0] = queue[size];
            queue[size] = null;
            go_down();
            return returned;
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
        return (size() == 0);
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

    public String affich() {
        String ch = "";
        for (int i = 0; i < this.capacity; i++) {
            ch += ("node number " + i + " : " + this.queue[i] + "\n");
        }
        return ch;
    }
}