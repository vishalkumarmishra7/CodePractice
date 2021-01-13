import java.util.Arrays;
import java.util.NoSuchElementException;

/*
1 6 3 9 8 5
1st smallest = 1
2nd smallest = 3
nth order smallest = 
*/
public class OrderedStatistics{

    class SolutionSecondMin{
        public int secondMin(int[] arr) {
            int min = arr[0];
            int min2 = arr[1];
    
            for(int i=0; i<arr.length; i++){
                if(arr[i]<min){
                    min2 = min;
                    min = arr[i];                
                } else if(arr[i] < min2){
                    min2 = arr[i];
                }
            }
            return min2;
        }
    }

    class MinHeap{
        // private int[] heap;
        private int heapSize;

        public MinHeap(int[] heap){
            heapSize = heap.length;
            // heap = new int[heapSize];
            // Arrays.fill(heap, -1); 

            //build min heap     
            for(int i=heapSize/2-1; i>=0; i--)            
                minHeapifyDown(heap, heapSize, i);          
        }
        private int leftChild(int pos){
            return 2*pos+1;
        }
        private int rightChild(int pos){
            return 2*pos+2;
        }
        private void minHeapifyDown(int[] heap, int heapSize, int pos){
            int smallestIdx=pos;
            int leftChild = leftChild(pos);
            int rightChild = rightChild(pos);
               
            if(leftChild<heapSize && heap[leftChild] < heap[smallestIdx])
                smallestIdx = leftChild;
            if(rightChild<heapSize && heap[rightChild] < heap[smallestIdx])
                smallestIdx = rightChild;
    
            if(smallestIdx != pos){
                int temp = heap[pos];
                heap[pos] = heap[smallestIdx];
                heap[smallestIdx] = temp;
    
                minHeapifyDown(heap, heapSize, smallestIdx);
            }

        }
        private int extractMinheap(int[] heap){
            if(heap.length == 0)
                throw new NoSuchElementException("Heap is Empty, No item available to delete item");    
            
            int root = heap[0];

            if(heapSize>0){
                heap[0] = heap[heapSize-1];
                heap[heapSize-1] = -1 ;
                heapSize--;
                minHeapifyDown(heap, heapSize, 0);
            }

            return root;

        }
        public void printHeapStructure(int[] heap){
            System.out.println("MinHeap is:");
            System.out.println("PARENT NODE"+"\t"+"LEFT NODE"+"\t"+"RIGHT NODE");
            for(int i=0;i<heap.length/2;i++)
                System.out.println(" "+heap[i]+"\t\t"
                                    +" "
                                    +(leftChild(i)<heap.length?heap[leftChild(i)]:-1)
                                    +"\t\t"
                                    +" "
                                    +(rightChild(i)<heap.length?heap[rightChild(i)]:-1));
            System.out.println();
        }

        int kthSmallest(int[] heap, int k){
            printHeapStructure(heap);      

            //extract min value k-1 times
            if(k>heapSize)
                throw new NoSuchElementException("Heap has less items"); 
            for(int i=0; i<k-1; i++)
                extractMinheap(heap);

            // return new root from heap
            
            return heap[0];
        }

    }




    public static void main(String[] args) {
        int[] input = {3, 2, 5, 6, 10, 21, 15};

        Arrays.stream(input).forEach(n->System.out.print(n+" "));
        System.out.println();

        OrderedStatistics os = new OrderedStatistics();
        OrderedStatistics.SolutionSecondMin ssm = os.new SolutionSecondMin();
        // SolutionSecondMin ss = new OrderedStatistics().new SolutionSecondMin();

        //finding 2nd minimum
        System.out.println("Second Minimum= "+ssm.secondMin(input));


        //find kth minimum using min heap
        int[] input2 = input.clone();
        OrderedStatistics.MinHeap mh = os.new MinHeap(input2);
        System.out.println("kth Minimum= "+mh.kthSmallest(input2, 1));


    }
}













