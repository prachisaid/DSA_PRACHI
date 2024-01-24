package LinkedList;

public class HashMap {

    HashNode[] arr;
    int size;
    public HashMap(){
        size = (int) (1e6+1);
        arr = new HashNode[size];
    }

    public int hashValue(int key){
        return key%size;
    }

    public void put(int key, int value){
        int hash = hashValue(key);
        HashNode node = new HashNode(key, value);

        if(arr[hash] != null){
            arr[hash].value = value;
        }
        else{
            arr[hash] = node;
        }
    }

    public int get(int key){
        int hash = hashValue(key);

        if(arr[hash] == null){
            return -1;
        }
        else{
            return arr[hash].value;
        }
    }

    public void remove(int key){
        int hash = hashValue(key);

        if(arr[hash].key == key){
            arr[hash] = null;
        }
    }
}

class HashNode{
    int key;
    int value;
    HashNode next;

    public HashNode(){

    }

    public HashNode(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
