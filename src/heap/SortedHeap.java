package heap;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;



public class SortedHeap<E> implements Heap<E>{
    private int size = 0;
    private Object queue[];
    private final int capacity;
    private final Comparator<? super E> comparator;

    private SortedHeap(int capacity, Comparator<? super E> comparator){
        /**
         * this is the constructor SortedHeap
         */
        this.capacity = capacity;
        this.size = 0;
        this.comparator = comparator;
        this.queue = new Object[this.capacity];
    }



    private class HeapArrayIterator<E> implements Iterator<E> {
        private int id;

        private HeapArrayIterator() {
            id = -1;
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
                id += 1;
                return (E)SortedHeap.this.queue[++id];
            } else {
                throw new NoSuchElementException("No element next");
            }
        }
    }

    public Iterator<E> iterator() {
        return new HeapArrayIterator<E>();
    }

        /*public E popElement(){
            if (id >0) {
                Object inter[] = null;
                System.arraycopy(liste,id+1,inter,0,size()-id-1);
                for (Object elem : inter){
                    insertElement((E)elem);
                }

            }
            else{
                throw new IllegalStateException("Impossible to delete element. Call next() method before.");
            }
        }*/



    private void go_up(int node){
        int father_node = (node-1)/2;
        while (comparator.compare((E)queue[father_node],(E)queue[node])<0){
            /**
             * while father_node (father) < node (child), we reverse father and child
             */
            E value = (E)queue[father_node];
            queue[father_node] = (E)queue[node];
            queue[node] = value;
        }
    }


    private void go_down(){
        /**
         * k represents the layer and l represents a spot within the layer k
         */
        int k = 0;
        int l = 0;

        int node = (int)(l+Math.pow(2,k)-1);
        int node_child1 = (int)(2*l+Math.pow(2,k+1)-1);
        int node_child2 = (int)(2*l+Math.pow(2,k+1));

        while (comparator.compare((E)queue[node],(E)queue[node_child1])<0 || comparator.compare((E)queue[node],(E)queue[node_child2])<0){
            /**
             * -- reverses the father and the biggest child --
             * first we compare each child with his father
             * then we compare the children and pick the biggest
             * finally we reverse the biggest child and the father
             */
            int chosen_child;
            if (comparator.compare((E)queue[node_child1],(E)queue[node_child2])<0){
                /**
                 * tests if the child 2 is bigger than the child 1
                 * if yes, we reverse father and child 2
                 */
                chosen_child = node_child2;
            }
            else{
                chosen_child = node_child1;
            }
            E value = (E)queue[node];
            queue[node] = (E)queue[chosen_child];
            queue[chosen_child] = value;

        }

    }

    public boolean insertElement(Object e) {
        if (this.size()<this.capacity){
            queue[this.size()] = e;
            go_up(size());
            return true;
        }
        else{
            queue[0] = e;
            go_down();
            return true;
        }
    }
    public E element() throws NoSuchElementException{
        if (this.isEmpty()){
            throw new NoSuchElementException("Empty object");
        }
        else{
            return (E)queue[0];
        }
    }

    public E popElement() throws NoSuchElementException{
        if (size==0) {
            throw new NoSuchElementException("No element");
        }else {
            E returned = (E) queue[0];
            size--;
            queue[0] = queue[size];
            queue[size] = null;
            go_down();
            return returned;
        }
    }

    public boolean isEmpty() {
        return (size()==0);
    }
    public int size(){
        return this.size;
    }

    public String affich() {
        String ch= "";
        for (int i=0;i<this.capacity;i++) {
            ch += ("node number " + i + " : " + this.queue[i] + "\n");
        }
        return ch;
    }

    public class HeapComparator implements Comparator<String>{
        public HeapComparator(){

        }
        public int compare(String ch1, String ch2){
            if ()
        }
    }
}
