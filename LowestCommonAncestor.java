import java.util.*;
public class LowestCommonAncestor {
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
    public static ArrayList NodeToRootPath(Node node, int data){
        if(node.data==data){
            ArrayList<Integer> base = new ArrayList<>();
            base.add(node.data);
            return base;
        }
        for(Node child:node.children){
            ArrayList<Integer> res = NodeToRootPath(child,data);
            if(res.size()!=0){
                res.add(node.data);
                return res;
            }
        }
        return new ArrayList<>();
    }
    public static int LowestCommonAncestor(Node node, int d1, int d2){
        ArrayList<Integer> list2 = NodeToRootPath(node,d1);
        ArrayList<Integer> list1 = NodeToRootPath(node,d2);
        int p1 = list1.size()-1 , p2 = list2.size()-1;

        while(p1>=0 && p2>=0){
            if(list1.get(p1)==list2.get(p2)){
                p1--;
                p2--;
            }else{
                break;
            }
        }
        p1++;
        p2++;
        return list1.get(p1);
    }
    public static void main(String[] args) {
        int input[] = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = construct(input);
        System.out.println(LowestCommonAncestor(root,120,110));
    }
}
