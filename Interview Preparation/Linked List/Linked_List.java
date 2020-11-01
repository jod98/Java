import java.util.*;
public class Linked_List {
    public static void main(String args[]){
        LinkedList list = new LinkedList();                         // creating linkedlist

        list.insertHead(10);                                    // inserting '10' at head
        list.insertHead(20);                                    // inserting '20' at head
        list.insertHead(15);                                    // inserting '15' at head
        list.insertHead(12);                                    // inserting '12' at head
        list.display();                                             // printing linkedlist

        list.delete(20);                                        // deleting '20' at head
        list.display();                                             // printing linkedlist
    }
}

// Initiating Link Class
class Link
{
    public int data;                                                // store link data
    public Link next;                                               // allows us to point to next link in list

    // Creating Link Constructor
    public Link(int input) {
        data = input;                                               // initialise data = input
        next = null;                                                // next = null
    }
}

// Initiating LinkedList Class
class LinkedList
{
    public Link first;                                              // creating first link in LinkedList

    // Creating LinkedList Constructor
    public LinkedList() {
        first = null;                                               // set first link (head) = null
    }

    // Is LinkedList Empty?
    public boolean isEmpty() {
        return (first == null);                                     // set first (head) = null - if empty
    }

    // Insert Item (head of list)
    public void insertHead(int val) {
        Link newLink = new Link(val);                               // create new link (contains 'val')
        newLink.next = first;                                       // new link points to old first link
        first = newLink;                                            // new link now becomes first link
    }

    // Delete Item (head of list)
    public Link deleteHead() {
        Link temp = first;                                          // backup first link
        first = first.next;                                         // first link now deleted - second link now first
        return temp;                                                // return deleted link
    }

    public void display() {
        Link current = first;                                       // start with first link
        while(current != null) {                                    // iterate through list
            System.out.print(current.data + " ");                       // print links
            current = current.next;
        }
    }

    public Link delete(int val) {                                   // delete link with 'val'
        Link current = first;                                       // current = first link
        Link previous = first;                                      // previous = first link
        while(current.data != val) {                                // search for link
            if(current.next == null) {
                return null;                                        // didn't find it
            }else {
                previous = current;                                 // go to next link
                current = current.next;                             // update current to point at next
            }
        }
        if(current == first){                                       // if: first link then change first
            first = first.next;
        }else{                                                      // else: bypass it
            previous.next = current.next;
        }
        return current;                                             // return current link
    }
}
