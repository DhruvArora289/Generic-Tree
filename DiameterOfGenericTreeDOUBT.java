import java.util.*;
public class DiameterOfGenericTreeDOUBT {
    public static class Node{
        String data;
        ArrayList<Node> children;

        Node(){
            children=new ArrayList<>();
        }
        Node(String val){
            data=val;
            children = new ArrayList<>();
        }
    }
    public static Node construct(String input[]){
        Node root = new Node(input[0]);
        Stack<Node> st = new Stack<>();
        st.push(root);

        for(int i=1;i<input.length;i++){
            if(input[i].equals("-1")){
                st.pop();
            }else{
                Node newNode=new Node(input[i]);
                st.peek().children.add(newNode);
                st.push(newNode);
            }
        }
        return root;
    }
    public static void display(Node node){
        System.out.print(node.data+"->");
        for(Node child:node.children){
            System.out.print(child.data+" ");
        }
        System.out.println();
        for(Node child:node.children){
            display(child);
        }
    }
    static int diaOfTree;
    public static int diameter(Node node){
        int lh = -1, slh = -1;

        for(Node child:node.children){
            int cht = diameter(child);

            if(cht>lh){
                slh = lh;
                lh = cht;
            }else if(cht>slh){
                slh = cht;
            }
        }
        int diaOfNode = lh+slh+2;
        if(diaOfNode>diaOfTree){
            diaOfTree = diaOfNode;
        }
        return lh+1;
    }
    
    public static void main(String[] args){
        String input[] = {"A", "B", "E", "R", "-1", "-1", "F", "S", "-1", "-1", "-1", "C", "G", "I", "L", "H", "P", "-1", "-1", "-1", "-1", "J", "-1", "-1", "C", "H", "K", "M", "O", "Q", "-1", "-1", "-1", "-1", "-1", "-1", "D", "U", "-1", "V", "-1", "-1", "-1"};

        Node root = construct(input);
        diaOfTree=0;
        diameter(root);
        System.out.println(diaOfTree);
    }
}
