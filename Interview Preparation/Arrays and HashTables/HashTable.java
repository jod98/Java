import java.util.ArrayList;

// Initiating HashTable Class
public class HashTable {

    public static void main(String[] args)
    {
        Map<String, Integer>map = new Map<>();                                  // Creating map (hashtable) instance

        map.add("this", 1);                                                     // inserting '1' in hashtable after hashing string "this" and finding index
        map.add("coder", 2);                                                    // inserting '2' in hashtable after hashing string "coder" and finding index
        map.add("this", 4);                                                     // inserting '4' in hashtable after hashing string "this" and finding index
        map.add("hi", 5);                                                       // inserting '5' in hashtable after hashing string "hi" and finding index

        System.out.println(map.size());                                         // OUTPUT: 3
        System.out.println(map.remove("this"));                            // OUTPUT: 4
        System.out.println(map.remove("this"));                            // OUTPUT: null
        System.out.println(map.size());                                         // OUTPUT: 2
        System.out.println(map.isEmpty());                                      // OUTPUT: false
    }
}

// Initiating HashNode
class HashNode<K, V> {
    K key;                                                                          // unique hash
    V value;                                                                        // value to store in hashed index

    HashNode<K, V> next;                                                            // reference to next node

    // Create HashNode Constructor
    public HashNode(K key, V value)
    {
        this.key = key;                                                             // setting key
        this.value = value;                                                         // setting value
    }
}

// Initiating HashTable as Map
class Map<K, V> {

    private ArrayList<HashNode<K, V>> bucketArray;                                  // 'bucketArray' (slots) used to store values
    private int numBuckets;                                                         // current capacity of array list
    private int size;                                                               // current size of array list

    // Create HashTable Constructor
    public Map()
    {
        bucketArray = new ArrayList<>();                                            // initialise slots as empty chains (array list)
        numBuckets = 10;                                                            // initialise capacity
        size = 0;                                                                   // initialise size

        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);                                                  // create slots
    }

    // Return Size
    public int size() {
        return size;
    }

    // Return 'true'/'false' if Empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Hash Function to Generate Key
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();                                              // returns hash code value for object
        int index = hashCode % numBuckets;                                          // index = hash code mod hash table size (numBuckets)
        return index;                                                               // return index to place object
    }

    // Remove Key
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);                                      // apply hash function to find index for given key
        HashNode<K, V> head = bucketArray.get(bucketIndex);                         // get head of chain
        HashNode<K, V> prev = null;                                                 // temp hash node

        while (head != null) {                                                      // search for key in its chain{
            if (head.key.equals(key))                                               // if key found: break
                break;
            prev = head;                                                            // else: keep moving in chain
            head = head.next;
        }
        if (head == null)                                                           // if key was not there: return null
            return null;

        size--;                                                                     // reduce size

        if (prev != null)                                                           // remove key
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;                                                          // return key
    }

    // Returns Value for Key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);                                      // head of chain for given key
        HashNode<K, V> head = bucketArray.get(bucketIndex);                         // create head node for given hashed slot

        while (head != null) {                                                      // search key in chain
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;                                                                // return null: key not found
    }

    // Adds Key Value Pair to Hash
    public void add(K key, V value)
    {
        int bucketIndex = getBucketIndex(key);                                      // hashed index for given key
        HashNode<K, V> head = bucketArray.get(bucketIndex);                         // create head node for given hashed slot

        while (head != null) {                                                      // iterate over entries
            if (head.key.equals(key)) {                                             // if key is already present: return
                head.value = value;
                return;
            }
            head = head.next;                                                       // iterate to next entry
        }

        size++;                                                                     // increment table size if no available spaces
        head = bucketArray.get(bucketIndex);                                        // head of chain for given key
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);                    // create head node for given hashed slot
        newNode.next = head;                                                        // set head of chain for given key as next available node
        bucketArray.set(bucketIndex, newNode);                                      // place node (value) into given slot

        // If load factor goes beyond threshold, then double hash table size - load factor (7 buckets filled and 10 spaces in table = 0.7)
        if ((1.0*size)/numBuckets >= 0.7) {                                         // if load factor > 0.7, double the hashtable size
            ArrayList<HashNode<K, V>> temp = bucketArray;                           // create array list of hash nodes i.e. more entries to table
            bucketArray = new ArrayList<>();                                        // create new slots
            numBuckets = 2 * numBuckets;                                            // double the slots
            size = 0;                                                               // reset size after 0.7 load factor limit reached (new hashtable created)

            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);                                              // iterate over all slots and set to null

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {                                          // iterate over all slots in previous hashtable
                    add(headNode.key, headNode.value);                              // add old hashtable entries to new bigger hashtable
                    headNode = headNode.next;                                       // go to next node
                }
            }
        }
    }
} 