package com.marcelo;

// class implementation of binary node
public class BinaryNode {
    private BinaryNode left, right;
    private Comparable<?> value;

    protected BinaryNode(Comparable v) {
        left = null;
        right = null;
        value = v;
    }
    
    public BinaryNode left() {return left;}
    public BinaryNode right() {return right;}
    public Comparable<?> value() {return value;}

    public void setLeftTo(BinaryNode newLeftNode) {left = newLeftNode;}
    public void setRightTo(BinaryNode newRightNode) {right = newRightNode;}
    public void setValueTo(Comparable<?> newValue) {value = newValue;}
}
