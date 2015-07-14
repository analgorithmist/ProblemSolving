package BST;


public class Successor {

    private class Node{
        int data;
        Node left;
        Node right;
        public Node(int data, Node left, Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }


    public Node findMin(Node root){
        if(root.left==null)
            return root;
        else
            return findMin(root.left);
    }

    /**
     * First right from current node is one possible successor, but if node has right child then min of the right child is the successor(this holds higher priority)
     * Does your code when root is null or if there is no successor.
     */
    public Node findSuccessor(Node root, int data){
        Node firstRightSuccessor = null;
        while(root!=null){
            if(root.data>data){
                firstRightSuccessor=root;
                root=root.left;
            }
            else if(root.data<data){
                root = root.right;
            }
            else{
                if(root.right!=null)
                    return findMin(root.right);
                else
                    return firstRightSuccessor;
            }
        }
        return firstRightSuccessor;
    }


    public void test(){
        Node seven = new Node(7,null,null);
        Node ten = new Node(10,null,null);
        Node nine = new Node(9,seven,ten);
        Node eight = new Node(8,null,null);
        Node five = new Node(5, null, null);
        Node three = new Node(3,null,null);
        Node one = new Node(1,null, null);
        Node two = new Node(2,one,three);
        Node four = new Node(4,two,five);
        Node six = new Node(6,four, nine);
        System.out.println(findSuccessor(six,5).data);
        System.out.println(findSuccessor(six,4).data);
        System.out.println(findSuccessor(six,6).data);
        System.out.println(findSuccessor(six,10));

    }

    public static void main(String[] args){
       Successor s = new Successor();
       s.test();
   }
}
