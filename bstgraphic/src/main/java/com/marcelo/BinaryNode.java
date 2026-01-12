package com.marcelo;

// class implementation of binary node
public class BinaryNode {
    private BinaryNode left, right;
    private int value;

    protected BinaryNode(int v) {
        left = null;
        right = null;
        value = v;
    }
    
    public BinaryNode left() {return left;}
    public BinaryNode right() {return right;}
    public int value() {return value;}

    public void setLeftTo(BinaryNode newLeftNode) {left = newLeftNode;}
    public void setRightTo(BinaryNode newRightNode) {right = newRightNode;}
    public void setValueTo(int newValue) {value = newValue;}
}
