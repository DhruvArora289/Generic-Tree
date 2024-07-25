import java.util.*;
public class NodeWithaMaxSubTreeSum {
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
    static int maxSum;
    static Node maxsumNode;
    public static int maxsumNode(Node node){
        int sum = 0;

        for(Node child:node.children){
            sum += maxsumNode(child);
        }

        sum += node.data;
        if(sum>maxSum){
            maxSum = sum;
            maxsumNode = node;
        }
        return sum;
    }
    public static void main(String[] args) {
        int input[] = {10,20,-50,-1,60,-1,-1,30,-70,-1,80,-1,90,-1,-1,40,-100,-1,-1};
        Node root = construct(input);
        maxSum = 0;
        maxsumNode(root);
        System.out.println(maxsumNode.data + "@" + maxSum);
    }
}
