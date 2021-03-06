/**
   Red black tree with a java.Map like interface.  Implements Icon so
   that it can be easily drawn. Insert, contains, and get are O(log n)
   worst case time. It is possible to write a constant space, linear
   time iterator for this tree that produces the elements in sorted order.
   
   <p>
   Based on Okasaki, Alternatives to Two Classic Data Structures, SIGCSE 2005

   <P>Morgan McGuire
   <br>morgan@cs.williams.edu
*/
public class RedBlack<Key extends Comparable<Key>, Value> {

    /** Node labels. */
    private enum Color {RED, BLACK};

    /** Value returned from a comparator */
    private static final int LESS    = -1;

    /** Value returned from a comparator */
    private static final int EQUAL   =  0;

    /** Value returned from a comparator */
    private static final int GREATER = +1;
    
    /** NULL when the tree is empty */
    private Node root;

    /** All leaf nodes are black empty nodes that share this one instance. */
    final private Node EMPTY = new Empty();

    public RedBlack() {
        root = EMPTY;
    }
    
    public void add(Key key, Value value) {
        root = root.add(key, value);
        root.color = Color.BLACK;
    }

    /** Returns null if not found. */
    public Value get(Key key) {
        Node n = root.getNode(key);
        if (n != null) {
            return n.value;
        } else {
            return null;
        }
    }
    
    public boolean contains(Key key) {
        return root.getNode(key) != null;
    }
    
    public boolean isEmpty() {
    	return root == null;
    }
    public void clear() {
    	root = null;
    }
    private class Node {
        public Key    key;
        public Value  value;
        
        public Color  color;
        public Node   left;
        public Node   right;
        
        /** Used by Empty */
        protected Node() {
            assert EMPTY == null;
        }

        /** Nodes always begin red */
        public Node(Key k, Value v) {
            key   = k;
            value = v;
            color = Color.RED;
            left  = EMPTY;
            right = EMPTY;
        }
        
        private boolean isRed() {
            return color == Color.RED;
        }

        public Node add(Key k, Value v) {
            switch (k.compareTo(key)) {
            case LESS:
                left = left.add(k, v);
                break;

            case GREATER:
                right = right.add(k, v);
                break;

            case EQUAL:
                // key is already in the tree; replace the value
                value = v;
                return this;  
            }
        
        
            // Check for two red nodes in a row: Red child and red grandchild
            if (left.isRed() && left.left.isRed()) {

                //       z           y
                //      / \         / \
                //     y   D  ==>  /   \
                //    / \         x     z
                //   x   C       / \   / \
                //  / \         A   B C   D
                // A   B
                return balance(left.left, left, this,              // x,y,z
                               left.left.right, left.right);       // B,C

            } else if (left.isRed() && left.right.isRed()) {

                //       z           y
                //      / \         / \
                //     x   D  ==>  /   \
                //    / \         x     z
                //   A   y       / \   / \
                //      / \     A   B C   D
                //     B   C
                return balance(left, left.right, this,             // x,y,z
                               left.right.left, left.right.right); // B,C
                
            } else if (right.isRed() && right.left.isRed()) {

                //     x             y
                //    / \           / \
                //   A   z    ==>  /   \
                //      / \       x     z
                //     y   D     / \   / \
                //    / \       A   B C   D
                //   B   C
                return balance(this, right.left, right,            // x,y,z
                               right.left.left, right.left.right); // B,C
                
            } else if (right.isRed() && right.right.isRed()) {
                //   x               y
                //  / \             / \
                // A   y      ==>  /   \
                //    / \         x     z
                //   B   z       / \   / \
                //      / \     A   B C   D
                //     C   D
                return balance(this, right, right.right,           // x,y,z
                               right.left, right.right.left);      // B,C
            }

            return this;
        }


        /** Returns the node for this key, or null. */
        public Node getNode(Key k) {
            switch (k.compareTo(key)) {
            case LESS:
                return left.getNode(k);

            case GREATER:
                return right.getNode(k);

            default: // EQUAL
                return this;
            }
        }

    }

    /** The empty node used at leaves */
    private class Empty extends Node {

        public Empty() {
            color = Color.BLACK;
            assert EMPTY == null : "Should only make one empty node instance!";
        }

        /** Always make a new node, since this one is empty */
        public Node add(Key k, Value v) {
            return new Node(k, v);
        }

        public Node getNode(Key key) {
            return null;
        }
    }

    /**
      Rearrange/recolor the tree as

      <pre>
             y      <== red
            / \
           /   \
          x     z   <== both black
         / \   / \
        A   B C   D
      </pre> 
      Note: A and D are not passed in because already in the right place
    */
    private Node balance(Node x, Node y, Node z, Node B, Node C) {
        
        x.right = B;
        y.left  = x;
        y.right = z;
        z.left  = C;
        x.color = Color.BLACK;
        y.color = Color.RED;
        z.color = Color.BLACK;
        return y;
    }

    @Override public String toString() {
        return getNodeString(root);
    } // public String toString()

    public String getNodeString(Node node) {
        String str = "";
        if (node.left != EMPTY)
            str += getNodeString(node.left);
        str += node.value.toString().trim() + "-(" + (node.color == Color.RED ? "R" : "B") + ") ";
        if (node.right != EMPTY)
            str += getNodeString(node.right);
        return str;
    } // public String getNodeString(Node node)

    public static void main(String[] args) {
        RedBlack<Integer, String> rbt = new RedBlack<Integer, String>();
        for (int i = 0; i < 10; i++) {
            int value = (int) (Math.random() * 10);
            rbt.add(value, value + "");
            System.out.println(value + ": " + rbt.toString());
        } // for (int i = 0; i < 10; i++)
        for (int i = 0; i < 10; i++) {
            int value = (int) (Math.random() * 10);
            String str = rbt.get(value);
            System.out.println(value + (str == null ? ": not found" : ": found"));
        } // for (int i = 0; i < 10; i++)
    } // public static void main(String[] args)

}

