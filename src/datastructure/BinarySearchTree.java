package datastructure;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node root = null;

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
        } else{
            if(data.compareTo(current.data) < 0){
                current = current.left;
            } else if (data.compareTo(current.data) > 0){
                current = current.right;
            } else if(data.compareTo(current.data) == 0){
                return current;
            }
            return insert(current, data);
        }
    }

    private Node delete(Node current, T target){
        
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
