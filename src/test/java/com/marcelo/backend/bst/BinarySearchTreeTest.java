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

    @Test
    public void testDeleteRoot() {
        // Create a new Binary Search Tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Add: 955, 967, 944, 606, 921
        bst.insert(955);
        bst.insert(967);
        bst.insert(944);
        bst.insert(606);
        bst.insert(921);

        // Delete 955 (the root)
        bst.delete(955);

        // The root should now be 967 (right child of old root)
        assertNotNull(bst.getRoot());
        assertEquals(967, bst.getRoot().getValue());

        // 944 should still be to the left of 967
        assertNotNull(bst.getRoot().getLeft());
        assertEquals(944, bst.getRoot().getLeft().getValue());

        // 955 should no longer exist
        assertNull(bst.search(955));
    }

    @Test
    public void testDeleteAndReinsert() {
        // Create a new Binary Search Tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Add: 257, 248, 360, 169, 868
        bst.insert(257);
        bst.insert(248);
        bst.insert(360);
        bst.insert(169);
        bst.insert(868);

        // Verify root is 257
        assertNotNull(bst.getRoot());
        assertEquals(257, bst.getRoot().getValue());

        // Delete 967 (not in tree, should have no effect)
        bst.delete(967);

        // Root should still be 257
        assertEquals(257, bst.getRoot().getValue());

        // All other values should still exist
        assertNotNull(bst.search(248));
        assertNotNull(bst.search(360));
        assertNotNull(bst.search(169));
        assertNotNull(bst.search(868));
    }

    @Test
    public void testDeleteCurrentRoot() {
        // Create a new Binary Search Tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Add: 127, 995, 533, 711, 154
        bst.insert(127);
        bst.insert(995);
        bst.insert(533);
        bst.insert(711);
        bst.insert(154);

        // Current root is 127
        assertEquals(127, bst.getRoot().getValue());

        // Delete the current root
        bst.delete(127);

        // Root should change (likely to 154 or 533)
        assertNotNull(bst.getRoot());
        assertNotEquals(127, bst.getRoot().getValue());

        // All other values should still exist
        assertNotNull(bst.search(995));
        assertNotNull(bst.search(533));
        assertNotNull(bst.search(711));
        assertNotNull(bst.search(154));

        // 127 should no longer exist
        assertNull(bst.search(127));
    }

    @Test
    public void testDeleteMostProblematicValue() {
        // Create a new Binary Search Tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Add: 688, 225, 655, 536, 415
        bst.insert(688);
        bst.insert(225);
        bst.insert(655);
        bst.insert(536);
        bst.insert(415);

        // Root should be 688
        assertEquals(688, bst.getRoot().getValue());

        // Delete 225 (the most problematic value - has left subtree)
        bst.delete(225);

        // Root should still be 688
        assertEquals(688, bst.getRoot().getValue());

        // 225 should no longer exist
        assertNull(bst.search(225));

        // All remaining values should still exist
        assertNotNull(bst.search(688));
        assertNotNull(bst.search(655));
        assertNotNull(bst.search(536));
        assertNotNull(bst.search(415));
    }
}
