package heap;

import java.util.Comparator;

public class ComparatorInt implements Comparator<Integer>{

    public ComparatorInt(){
    }

    public int compare(Integer a, Integer b){
        if (a<b){
            return -1;
        }
        else if (a==b){
            return 0;
        }
        else{
            return 1;
        }
    }
}
