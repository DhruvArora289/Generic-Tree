import java.util.*;
public class IsSymmetric {
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
                Node newNode = new Node(input[0]);
                st.peek().children.add(newNode);
                st.push(newNode);
            }
        }
        return root;
    }
    public static boolean AreTreesMirrorInShape(Node n1, Node n2){
        if(n1.children.size()!=n2.children.size()){
            return false;
        }
        for(int i=0;i<n1.children.size();i++){
            Node child1 = n1.children.get(i);
            int mIdx = n2.children.size()-1-i;
            Node child2 = n2.children.get(mIdx);

            boolean res = AreTreesMirrorInShape(child1, child2);

            if(!res){
                return false;
            }
        }
        return true;
    }
    public static boolean IsSymmetric(Node node){
        return AreTreesMirrorInShape(node, node);
    }
    public static void main(String[] args) {
        int input[] = {10,20,-1,30,50,-1,60,-1,-1,40,50,-1,-1,-1};
        Node root = construct(input);
        System.out.println(IsSymmetric(root));
    }
}
