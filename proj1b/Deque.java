public interface Deque<T> {

    int size();

    T get(int index);

    void printDeque();

    void addFirst(T newItem);

    void addLast(T newItem);

    T removeFirst();

    T removeLast();

    default boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

}
