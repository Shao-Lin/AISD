public class MyStack<T>   {

    private static class SimpleLinkedListNode<T> {
        public T value;
        public SimpleLinkedListNode<T> next;

        public SimpleLinkedListNode(T value, SimpleLinkedListNode<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private SimpleLinkedListNode<T> head = null;  // first, top
    private int count = 0;


    public void push(T value) {
        head = new SimpleLinkedListNode<T>(value, head);
        count++;
    }


    public T pop() throws Exception {
        T result = this.peek();
        head = head.next;
        count--;
        return result;
    }


    public T peek() throws Exception {
        if (count == 0) {
            throw new Exception("Stack is empty");
        }
        return head.value;
    }

    public int count() {
        return count;
    }
     boolean empty() {
        return count() == 0;
    }

}

