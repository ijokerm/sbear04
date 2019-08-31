
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trees4_1 {
    private class Element{
        int level;
        Node node;
    }

    public List<List<Integer>>levalOrder1(Node root){
        List<List<Integer>>retList=new ArrayList<>();
        if(root==null){
            return retList;
        }
        Queue<Element>queue=new LinkedList<>();
        Element e=new Element();
        e.node=root;
        e.level=0;
        queue.add(e);
        while(!queue.isEmpty()){
            Element front=queue.poll();
            //包装
            if(front.level==retList.size()){
                retList.add(new ArrayList<>());
            }
            retList.get(front.level).add((int)front.node.val);
            if(front.node.left!=null){
                Element l=new Element();
                l.node=front.node.left;
                l.level=front.level+1;
                queue.add(l);
            }
            if(front.node.right!=null){
                Element r=new Element();
                r.node=front.node.right;
                r.level=front.level+1;
                queue.add(r);

            }
        }
        return retList;

    }


    //层序遍历
    public static void levelOrder(Node root){
        if(root==null){
            return ;
        }
        Queue<Node>queue=new LinkedList<>();
       queue.add(root);

        while(!queue.isEmpty()){
            Node front=queue.poll();
            if(front.left!=null){
               queue.add(front.left);
            }
            if(front.right!=null){
                queue.add(front.right);
            }
        }
        return;
    }
//是否完全二叉树
public static boolean isComplete(Node root){
    if(root==null){
        return true;
    }
        Queue<Node>queue=new LinkedList<>();
    queue.add(root);
    while(true){
        Node front=queue.poll();
        if(front==null){
            break;
        }
        queue.add(front.left);
        queue.add(front.right);
}
    while(!queue.isEmpty()){
        Node node=queue.poll();
        if(node!=null){
            return false;
        }
    }
    return true;
}


}
