package binarytree;

public class Tree<E> {
    E value;
    Tree left;
    Tree right;

    Tree(E item) {
        value = item;
        left = right = null;
    }

    void setLeft(E value) {
        this.left = new Tree<>(value);
    }

    void setRight(E value) {
        this.left = new Tree<>(value);
    }

    Tree getLeft(){
        return this.left;
    }
    Tree getRight(){
        return this.right;
    }
}
