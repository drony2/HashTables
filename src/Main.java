import java.util.*;

public class Main {
    private static int[] HashTableOps(int[] ListOfInts){
        int[] HashTable = new int[9];
        int count = 0;

        for (int num: ListOfInts){
            int index = Hash(num);
            System.out.println("key: " + num + ", key_bf_mod: "+ (11 * num + 4) + ", index: " + index);
            while(HashTable[index] != 0){
                index = (index + 1) % HashTable.length;
            }
            HashTable[index] = num;
            count++;

            if (count == HashTable.length) {
                System.out.println("Хеш-таблица заполнена. Нельзя добавить больше элементов.");
                break;
            }
        }
        return HashTable;
    };

    public static List<List<Integer>> HashTableOpsClosed(int[] A) {
        int size = 9;
        List<List<Integer>> hashtable = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            hashtable.add(new ArrayList<>());
        }

        int prime = 11;
        int offset = 4;
        Set<Integer> modSet = new HashSet<>();

        for (int key : A) {
            int index = (prime * key + offset) % size;
            modSet.add(index);
            hashtable.get(index).add(key);
        }

        System.out.println(modSet);
        return hashtable;
    }




    private static int Hash(int key){
        return (11 * key + 4) % 9;
    }


    public static void main(String[] args) {
        int[] list = {5, 28, 19, 15, 20, 33, 12, 17,10};

        System.out.println("HashTableOpened: " + Arrays.toString(HashTableOps(list)) + "\n");
        System.out.println("HashTableClosed: " + HashTableOpsClosed(list) + "\n");




    }
}