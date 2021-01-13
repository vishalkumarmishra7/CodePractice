package DataStructures;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MaxHeapPriorityQ {


    public static void main(String[] args) {
        PriorityQueue<Integer> pQueueHeap = new PriorityQueue<>(Collections.reverseOrder());
        pQueueHeap.add(1);
        pQueueHeap.add(10);
        pQueueHeap.add(11);
        pQueueHeap.add(110);
        pQueueHeap.add(12);
        pQueueHeap.add(120);

        //checking front in queue 
        System.out.println("head of queue="+pQueueHeap.peek());

        //show all elements
        System.out.println("Max heap as PriorityQueue");
        Iterator<Integer> iter  = pQueueHeap.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next()+" ");            
        }

        System.out.println();

        //remove from heap
        System.out.println("deleted from queue="+pQueueHeap.poll());

        //showing again
        System.out.println("Again, Max heap as PriorityQueue");
        Iterator<Integer> iter1  = pQueueHeap.iterator();
        while (iter1.hasNext()) {
            System.out.print(iter1.next()+" ");            
        }

    } 
    
}
