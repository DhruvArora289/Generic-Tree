import java.util.*;
public class levelOrderLineWiseZigZag {
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
    public static void zigzag(Node root){
        Stack<Node> mainS = new Stack<>();
        Stack<Node> helperS = new Stack<>();
        int level = 0;
        mainS.push(root);
        while(mainS.size()>0){
            Node fnode = mainS.pop();
            System.out.print(fnode.data+" ");
            if(level%2==0){
                for(Node child:fnode.children){
                    helperS.push(child);
                }
            }else{
                for(int i=fnode.children.size()-1;i>=0;i--){
                    helperS.push(fnode.children.get(i));
                }
            }
            if(mainS.size()==0){
                level++;
                System.out.println();
                Stack<Node> tmp = mainS;
                mainS = helperS;
                helperS = tmp;
            }
        }
    }
    public static void main(String[] args) {
        int input[] = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = construct(input);
        zigzag(root);
    }
}
