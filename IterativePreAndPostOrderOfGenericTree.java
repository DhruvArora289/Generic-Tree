import java.util.*;
public class IterativePreAndPostOrderOfGenericTree {
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
    public static void IterativePreAndPostOrderOfGenericTree(Node node){
        
    }
}
