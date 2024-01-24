package LinkedList;

public class HashMapMain {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put(1, 1);
        map.put(2, 2);
        System.out.println(map.get(1));
        map.remove(2);
        System.out.println(map.get(2));
    }
}
