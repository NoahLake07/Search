package datastructure;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node root = null;

    /// region Constructors

    public BinarySearchTree(){
        this.root = null;
    }

    public BinarySearchTree(T data){
        this.root = new Node(data);
    }

    /// endregion

    /// region Interface Methods
    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public void insert(T data) {
        insert(root, data);
    }

    @Override
    public void delete(T target) {
        delete(root,target);
    }

    @Override
    public boolean contains(T data) {
        return contains(root, data);
    }

    /// endregion

    /// region Specific Methods

    private T getMin(Node node){
        if(node==null){
            return null;
        } else {
            while(node.left != null){
                node = node.left;
            }
            return node.data;
        }
    }

    private T getMax(Node node){
        if(node==null){
            return null;
        } else {
            while(node.right != null){
                node = node.right;
            }
            return node.data;
        }
    }

    private Node insert(Node current, T data){
        if(current == null){
            return new Node(data);
        } else {
            if(data.compareTo(current.data) < 0){
                insert(root.left,data);
            } else if (data.compareTo(current.data) > 0){
                insert(root.right,data);
            } else if(data.compareTo(current.data) == 0){
                return current;
            }
            return insert(current, data);
        }
    }

    private Node delete(Node current, T target){
        if(current == null){
            return null;
        } else {
            if(current.data.compareTo(target) > 0){
                // greater than
                delete(current.right,target);
            } else if (current.data.compareTo(target) < 0){
                // less than
                delete(current.left,target);
            } else if (current.data.compareTo(target) == 0) {
                // equal to
                if ( current.left == null && current.right == null){
                    // both children are null
                    System.out.println("\t* Both children are null; returned null.");
                    return null;
                } else if (current.left != null && current.right != null){
                    // neither child is null
                    //TODO complete recurring statement
                } else if (current.left != null && current.right == null){
                    // left is not null, but right is null
                    return current.left;
                } else if (current.left == null && current.right != null){
                    // right is not null, but left is null
                    return current.right;
                } else {
                    System.out.println("\t! End of statement reached. Returned null.");
                    return null;
                }
            } else {
                return null;
            }
        }

        return null;
    }

    private boolean contains(Node current, T target){
        if(current == null){
            return false;
        } else if(current == target){
            return true;
        } else {
            if(target.compareTo(current.data) < 0){
                return contains(current.left, target);
            } else {
                return contains(current.right, target);
            }
        }
    }

    // endregion

    private class Node {
        public Node left, right;
        public T data;

        public Node(){
            left = null;
            right = null;
            data = null;
        }

        public Node(T dat){
            data = dat;
            left = null;
            right = null;
        }

        public Node(Node l, Node r, T d){
            left = l;
            right = r;
            data = d;
        }
    }

}
