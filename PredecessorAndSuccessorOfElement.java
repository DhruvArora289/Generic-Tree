import java.util.*;
public class PredecessorAndSuccessorOfElement {
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
    public static Node predecessor;
    public static Node successor;
    public static int state;
    public static void PredecessorAndSuccessorOfElement(Node node, int data){
        if(state == 0){
            if(node.data == data){
                state++;
            }else{
                predecessor = node;
            }
        }else if(state == 1){
            successor = node;
            state++;
        }
        for(Node child : node.children){
            PredecessorAndSuccessorOfElement(child,data);
        }
    }
    public static void main(String[] args){
        predecessor = null;
        successor = null;
        state = 0;
        int input[] = {10,20,-1,30,70,-1,60,-1,-1,40,50,-1,-1,-1};
        Node root = construct(input);
        PredecessorAndSuccessorOfElement(root,50);
        if (state == 0) {
            System.out.println("Invalid input: Element not found");
        } else {
            if (predecessor != null) {
                System.out.println("Predecessor: " + predecessor.data);
            } else {
                System.out.println("Predecessor: Not found");
            }
            if (successor != null) {
                System.out.println("Successor: " + successor.data);
            } else {
                System.out.println("Successor: Not found");
            }
        }
    }
    }

