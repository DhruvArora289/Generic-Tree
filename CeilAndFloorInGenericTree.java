import java.util.*;
public class CeilAndFloorInGenericTree {
    public static class Node{
        int data;
        ArrayList<Node> children;

        Node(){
            children = new ArrayList<>();
        }
        Node(int val){
            data = val;
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
                Node newNode = new Node(input[i]);
                st.peek().children.add(newNode);
                st.push(newNode);
            }
        }
        return root;
    }

    static int ceil;
    static int floor;
    public static void CeilAndFloorInGenericTree(Node node, int data){
        if(node.data<data){
            if(node.data>floor){
                floor = node.data;
            }
        }else if(node.data>data){
            if(node.data<ceil){
                ceil = node.data;
            }
        }
        for(Node child:node.children){
            CeilAndFloorInGenericTree(child, data);
        }
    }
    public static void main(String[] args){
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        int input[] = {10,20,-50,-1,60,-1,-1,30,70,-1,-80,110,-1,120,-1,90,-1,-1,40,-100,-1,-1};
        Node root = construct(input);
        CeilAndFloorInGenericTree(root, 70);
        System.out.println("Ceil: "+ceil);
        System.out.println("floor: "+floor);
    }
}
