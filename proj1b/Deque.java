public interface Deque<T> {

    public int size();

    public T get(int index);

    public void printDeque();

    public void addFirst(T newItem);

    public void addLast(T newItem);

    public T removeFirst();

    public T removeLast();

    default public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

}
