package StackQueue;

import java.util.HashMap;
import java.util.*;

class LFUCache {
    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;

    LFUCache(int capacity){
        this.capacity = capacity;
        curSize = 0;
        minFrequency = 0;

        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public int get(int key){
        DLLNode curNode = cache.get(key);
        if(curNode == null){
            return -1;
        }

        updateNode(curNode);
        return curNode.value;
    }

    public void put(int key, int value){
        if(capacity == 0){
            return;
        }

        if(cache.containsKey(key)){
            DLLNode curNode = cache.get(key);
            curNode.value = value;
            updateNode(curNode);
        }

        else{
            curSize++;
            if(curSize > capacity){
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }

            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);

            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    private void updateNode(DLLNode curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);

        if(curFreq == minFrequency && curList.listSize == 0){
            minFrequency++;
        }

        curNode.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }


}

class DLLNode{
    int key;
    int value;
    DLLNode next, prev;
    int frequency;

    public DLLNode(int key, int value){
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
}

class DoubleLinkedList{
    int listSize;
    DLLNode head;
    DLLNode tail;

    public DoubleLinkedList(){
        this.listSize = 0;
        this.head = new DLLNode(0, 0);
        this.tail = new DLLNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(DLLNode curNode){
        DLLNode nextNode = head.next;
        head.next = curNode;
        curNode.prev = head;
        curNode.next = nextNode;
        nextNode.prev = curNode;
        listSize++;
    }

    public void removeNode(DLLNode curNode){
        DLLNode nextNode = curNode.next;
        DLLNode prevNode = curNode.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        listSize--;
    }
}
