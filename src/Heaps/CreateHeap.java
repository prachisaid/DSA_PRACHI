package Heaps;

class Heap{
    public int arr[] = new int[100];
    int size = 0;
    Heap(){
        arr[0] = -1;
        size = 0;
    }

    void insert(int val){
        size = size + 1;
        int ind = size;
        arr[ind] = val;

        while(ind > 1){
            int parent = ind / 2;
            if(arr[parent] < arr[ind]){
                int temp = arr[parent];
                arr[parent] = arr[ind];
                arr[ind] = temp;
                ind = parent;
            }
            else{
                return;
            }
        }
    }

    void delete(){
        if(size == 0) return;

        arr[1] = arr[size];
        size--;

        int ind = 1;

        while(ind < size){
            int left = (2 * ind);
            int right = (2 * ind + 1);

            if(left < size && arr[left] > arr[ind]){
                int temp = arr[ind];
                arr[ind] = arr[left];
                arr[left] = temp;
                ind = left;
            }

            else if(right < size && arr[right] > arr[ind]){
                int temp = arr[ind];
                arr[ind] = arr[right];
                arr[right] = temp;
                ind = right;
            }
            else{
                return;
            }
        }
    }

    void heapify(int[] arr, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right =  2 * i + 2;

        if(left < n && arr[largest] < arr[left]){
            largest = left;
        }

        if(right < n && arr[largest] < arr[right]){
            largest = right;
        }

        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    void heapSort(int[] arr, int n){
        int s = n;
//        int i = 1;
        while(s > 0){
            int temp = arr[0];
            arr[0] = arr[s-1];
            arr[s-1] = temp;
            s--;
            heapify(arr, s, 0);
        }
    }

    public void print(){
        for(int i = 1; i <= size; i++){
            System.out.println(arr[i]);
        }
    }
}
public class CreateHeap {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(50);
        heap.insert(55);
        heap.insert(53);
        heap.insert(52);
        heap.insert(54);
//        heap.print();
        heap.delete();
//        heap.print();

        int arr[] = {70, 60, 55, 45, 50, 65};
        int n = 6;

        for(int i = n/2-1; i >= 0; i--){
            heap.heapify(arr, n, i);
        }

        heap.heapSort(arr, n);

        for(int i = 0   ; i < n; i++){
            System.out.println(arr[i]);
        }
    }
}
