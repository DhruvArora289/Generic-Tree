import java.util.*;
public class multiSolver {
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
    static int size, sum, max, min;
    public static void multiSolver(Node node){
        size++;
        sum+=node.data;
        max=Math.max(max,node.data);
        min=Math.min(min,node.data);

        for(Node child:node.children){
            multiSolver(child);
        }
    }
    public static void main(String[] args){
        size = 0;
        sum = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        int input[] = {10,20,-1,30,50,-1,60,-1,-1,40,50,-1,-1,-1};
        Node root = construct(input);
        multiSolver(root);
        System.out.println("Size :"+size);
        System.out.println("Sum :"+sum);
        System.out.println("max :"+max);
        System.out.println("min :"+min);
    }
}
