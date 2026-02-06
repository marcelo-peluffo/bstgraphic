package com.marcelo.backend.bst;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for BinarySearchTree.
 */
public class BinarySearchTreeTest {
    
    @Test
    public void testInsertNumbers() {
        // Create a new Binary Search Tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        
        // Insert the numbers: 955, 967, 944, 606, 921
        bst.insert(955);
        bst.insert(967);
        bst.insert(944);
        bst.insert(606);
        bst.insert(921);
        
        // Verify the root is 955 (first inserted)
        assertNotNull(bst.getRoot());
        assertEquals(955, bst.getRoot().getValue());
        
        // Verify the tree structure
        // 967 should be to the right of 955
        assertNotNull(bst.getRoot().getRight());
        assertEquals(967, bst.getRoot().getRight().getValue());
        
        // 944 should be to the left of 955
        assertNotNull(bst.getRoot().getLeft());
        assertEquals(944, bst.getRoot().getLeft().getValue());
        
        // 606 should be to the left of 944 (left of left)
        assertNotNull(bst.getRoot().getLeft().getLeft());
        assertEquals(606, bst.getRoot().getLeft().getLeft().getValue());
        
        // 921 should be to the right of 606 but left of 944
        assertNotNull(bst.getRoot().getLeft().getLeft().getRight());
        assertEquals(921, bst.getRoot().getLeft().getLeft().getRight().getValue());
    }
}
