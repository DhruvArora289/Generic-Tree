import java.util.*;
public class KthLargestElementInTree {
    public static class Node{
        int data;
        ArrayList<Node> children;

        Node(){
            children=new ArrayList<>();
        }
        Node(int val){
            data=val;
            children = new ArrayList<>();
        }
    }
    public static Node construct(int input[]){
        Node root = new Node(input[0]);
        Stack<Node> st = new Stack<>();
        st.push(root);

        for(int i=1;i<input.length;i++){
            if(input[i]==-1){
                st.pop();
            }else{
                Node newNode=new Node(input[i]);
                st.peek().children.add(newNode);
                st.push(newNode);
            }
        }
        return root;
    }
    static int floor;
    public static void floor(Node node, int data){
        if(node.data<data){
            if(node.data>floor){
                floor = node.data;
            }
        }
        for(Node child:node.children){
            floor(child, data);
        }
    }
    public static int KthLargestElementInTree(Node node, int k){
        floor = Integer.MIN_VALUE;
        int data = Integer.MAX_VALUE;
        while(k>0){
            floor(node, data);
            data = floor;
            floor = Integer.MIN_VALUE;
            k--;
        }
        return data;
    }
    public static void main(String[] args) {
        floor = Integer.MIN_VALUE;
        int input[] = {10,20,-50,-1,60,-1,-1,30,70,-1,-80,110,-1,-120,-1,90,-1,-1,40,-100,-1,-1};
        Node root = construct(input);
        System.out.println(KthLargestElementInTree(root, 6));
    }
}
