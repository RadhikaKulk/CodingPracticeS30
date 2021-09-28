class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer next;

    // TC: O(1)
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.it = iterator;
        if(it.hasNext()) {
            next = it.next();
        }
    }

    // TC: O(1)
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // TC: O(1)
    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = next;
        if(it.hasNext()) {
            next = it.next();
        } else {
            next = null;
        }
        return temp;
    }

    // TC: O(1)
    @Override
    public boolean hasNext() {
        return next != null;
    }
}