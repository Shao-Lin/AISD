import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.shuffle;

public class MyQueue<T>  {


    private class SimpleLinkedListNode {
        public T value;
        public SimpleLinkedListNode next;

        public SimpleLinkedListNode(T value, SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(T value) {
            this(value, null);
        }
    }

    private SimpleLinkedListNode head = null; // first, top
    private SimpleLinkedListNode tail = null; // last
    private int count = 0;


    public void add(T value) {
        if (count == 0) {
            head = tail = new SimpleLinkedListNode(value);
        } else {
            tail.next = new SimpleLinkedListNode(value);
            tail = tail.next;
        }
        count++;
    }


    public T pool() throws Exception {
        T result = peek();
        head = head.next;
        count--;
        if (count == 0) {
            tail = null;
        }
        return result;
    }


    public T peek() throws Exception {
        if (count() == 0) {
            throw new Exception("Queue is empty");
        }
        return head.value;
    }


    public int count() {
        return count;
    }
    boolean empty() {
        return count() == 0;
    }
    public void shuffleQ(MyQueue<Card> deck) throws Exception {
        List<Card> list = new LinkedList<>();
        while (!deck.empty()){
            list.add(deck.pool());
        }
        shuffle(list);
        while (!list.isEmpty()){
            deck.add(list.remove(0));
        }
    }
}
