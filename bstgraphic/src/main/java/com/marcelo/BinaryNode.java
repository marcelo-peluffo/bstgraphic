package com.marcelo;

// class implementation of binary node
public class BinaryNode {
    private BinaryNode left, right;
    private Comparable value;

    protected BinaryNode(Comparable v) {
        left = null;
        right = null;
        value = v;
    }
    
    public BinaryNode left() {return left;}
    public BinaryNode right() {return right;}
    public Comparable getValue() {return value;}

    public void setLeft(BinaryNode newLeftNode) {left = newLeftNode;}
    public void setRight(BinaryNode newRightNode) {right = newRightNode;}
    public void setValue(Comparable newValue) {value = newValue;}
}
