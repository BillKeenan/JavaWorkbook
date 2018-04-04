package com.agiledeveloper;

public class Pair<T extends Comparable<? super T> > implements Comparable<Pair<T>> {

    private T left;
    private T right;

    public Pair(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }

    public void setLeft(T left) {
        this.left = left;
    }

    public void setRight(T right) {
        this.right = right;
    }

    public <T2 extends T> void copyFrom(Pair<? extends T> pair2) {
        this.left = pair2.getLeft();
        this.right= pair2.getRight();
    }

    public void copyTo(Pair<? super T> pair2) {
        pair2.left =this.left;
        pair2.right =  this.right;
    }


    @Override
    public int compareTo(Pair<T> o) {

        return (this.getLeft().compareTo(o.getLeft()) + this.getRight().compareTo(o.getRight()));

    }
}
