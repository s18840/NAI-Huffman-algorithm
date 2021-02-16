import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class s18840 {

    public static void main(String[] args) {

        int total=0;
        char[] chars =args[0].toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int number = chars.length;

        for (int i = 0; i <number ; i++) {
            if(map.containsKey(chars[i])){
                map.replace(chars[i], map.get(chars[i])+1);
            }else{
                map.put(chars[i],1);
            }

        }
        try {
                MyHeap minHeap = new MyHeap(map.size());
            for (char key:map.keySet()) {
                minHeap.insert(new NodeTree(String.valueOf(key),map.get(key)));

            }

            //minHeap.minHeap();
            NodeTree parent;
            while(minHeap.getSize()>=2){
                //minHeap.print();
                NodeTree min1= minHeap.delMin();

                //System.out.println();
                //minHeap.print();
                //System.out.println();
                NodeTree min2= minHeap.delMin();
                parent = new NodeTree(min1.getSign()+min2.getSign(),min1.getValue()+min2.getValue());
                parent.setLeft(min1);
                parent.setRight(min2);
                minHeap.insert(parent);

                if(minHeap.getSize()==1) {
                    parent.printLeaves(parent, "");
                }
            }
            //minHeap.print();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
class NodeTree{
    int value;
    String sign;
    NodeTree left;
    NodeTree right;

    public NodeTree(String sign,int value) {
        this.sign = sign;
        this.value = value;
        left=null;
        right=null;
    }
    public NodeTree(int value) {
        this.value = left.value+right.value;
    }

   public void printLeaves(NodeTree node,String path){
        if(node==null)
            return;
        if(node.left==null && node.right==null){
            System.out.println(node.getSign()+ " "+path);
        }
        if(node.left!=null){
            printLeaves(node.left,path+"0");
        }
       if(node.right!=null){
           printLeaves(node.right,path+"1");
       }
   }


    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getValue() {
        return value;
    }

    public NodeTree getLeft() {
        return left;
    }

    public NodeTree getRight() {
        return right;
    }

    public void setLeft(NodeTree left) {
        this.left = left;
    }

    public void setRight(NodeTree right) {
        this.right = right;
    }
}

class MyHeap{
    private NodeTree[] Heap;
    private int size;
    private int maxsize;
    private static final int FRONT = 1;

    public MyHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap =new NodeTree[this.maxsize + 1];
        Heap[0] = new NodeTree(null,Integer.MIN_VALUE);
    }

    public int getSize() {
        return size;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
}

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size && pos != 1) {
            return true;
        }
        return false;
    }

    private void swap(int replacing, int replaced) {
        NodeTree tmp;
        tmp = Heap[replacing];
        Heap[replacing] = Heap[replaced];
        Heap[replaced] = tmp;
    }
    private void recurency(int pos) {
        if (!isLeaf(pos)&& size>1) {
            if (Heap[pos].getValue() > Heap[leftChild(pos)].getValue()
                    || Heap[pos].getValue() > Heap[rightChild(pos)].getValue()) {

                if (Heap[leftChild(pos)].getValue() <= Heap[rightChild(pos)].getValue()) {
                    swap(pos, leftChild(pos));
                    recurency(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    recurency(rightChild(pos));
                }
            }
        }
    }

    public void insert(NodeTree element) {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;

        while (Heap[current].getValue() < Heap[parent(current)].getValue()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            recurency(pos);
        }
    }
    public NodeTree delMin() {
        NodeTree popped = Heap[FRONT];
        //System.out.println(popped.getSign()+" "+popped.getValue());
        Heap[FRONT] = Heap[size--];
        //System.out.println(popped.getSign()+" "+popped.getValue());
        recurency(FRONT);

        return popped;
    }
    public NodeTree delMinLast() {
        NodeTree popped = Heap[FRONT];
        //System.out.println(popped.getSign()+" "+popped.getValue());
        Heap[FRONT] = Heap[size--];
        //System.out.println(popped.getSign()+" "+popped.getValue());
        return popped;
    }

    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.println(Heap[i].getSign()+" "+Heap[i].getValue());
        }
    }

}
