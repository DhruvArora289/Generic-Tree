import java.util.*;
public class TraversalsOfGenericTree {
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
    public static void traversals(Node node){
        //pre-area
        System.out.println("Node Pre "+node.data);
        
        for(Node child:node.children){
            System.out.println("Edge Pre "+node.data+"--"+child.data);
            traversals(child);
            System.out.println("Edge Post "+node.data+"--"+child.data);
        }
        //post-area
        System.out.println("Node Post "+node.data);
    }
}
