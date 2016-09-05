package binaryTree;


import java.util.Stack;

/**
 * Created by Alvin on 15/11/13.
 */
public class BST {
        //二叉树个节点
        private Node root;

         class Node{
            private int data;
            private Node leftChild;
            private Node rightChild;

             public Node(int data)
             {
                 this.data  = data;
                 leftChild = null;
                 rightChild = null;
             }
        }

    public BST(){
        root = null;
    }

    public int size() {
        return size(root);
    }

    public int deep(){
       return deep(root);
    }

    public int min(){
        return min(root).data;
    }

    public void put(int data){
        root = put(root,data);
    }

    public void preOrderBST(){
        preOrderBST(root);
    }

    public void inOrderBST(){
        inOrderBST(root);
    }

    public void postOrderBST(){
        postOrderBST(root);
    }

    public void mirror(){
        mirror(root);
    }

    private void preOrderBSTByUnRecur(){
        preOrderBSTByUnRecur(root);
    }

    public void inOrderBSTByUnRecur(){ inOrderBSTByUnRecur(root);}

    public void postOrderBSTByUnRecur(){
        postOrderBSTByUnRecur(root);
    }

    //打印数据
    public void visit(Node node){
        if(node == null)
            return;
        System.out.println(node.data);
    }

    //返回二叉树的节点数量
    private int size(Node head){
        if(head == null) return 0;
        else return size(head.leftChild)+size(head.rightChild)+1;
    }

    private int deep(Node head){
        if(head == null) return 0;
        int leftdeep = deep(head.leftChild) + 1;
        int rightdeep = deep(head.rightChild) + 1;
    return leftdeep > rightdeep ? leftdeep : rightdeep;
    }

    //找二叉树中的最小数
    private Node min(Node head){
        if(head.leftChild==null)
            return head;
         return min(head.leftChild);
    }

    //插入数据
    private Node put(Node head,int data){
        if(head == null)
            return new Node(data);
        Node cur = head;
        if(cur.data > data) {
            cur.leftChild = put(cur.leftChild, data);
        }else if(cur.data < data) {
            cur.rightChild = put(cur.rightChild, data);
        }else{
            cur.data = data;
        }
        return cur;
    }

    //先序遍历
    private void preOrderBST(Node head){
        if(head == null)
            return;
        visit(head);
        preOrderBST(head.leftChild);
        preOrderBST(head.rightChild);
    }

    //中序遍历
    private void inOrderBST(Node head){
        if(head == null)
            return;
        inOrderBST(head.leftChild);
        visit(head);
        inOrderBST(head.rightChild);
    }

    //后序遍历
    private void postOrderBST(Node head){
        if(head == null)
            return;
        postOrderBST(head.leftChild);
        postOrderBST(head.rightChild);
        visit(head);
    }

    //二叉树的镜像
    private void mirror(Node head){
        if(head == null)
            return;
        Node temp = head.leftChild;
        head.leftChild = head.rightChild;
        head.rightChild = temp;
        mirror(head.leftChild);
        mirror(head.rightChild);
    }

    //二叉树非递归先序遍历
    private void preOrderBSTByUnRecur(Node head){
        //先判断头节点是否为空
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            //先顺遍历是先父节点,然后父节点的左儿子,父节点的右儿子,
            //所以先要将父节点压入栈
            stack.add(head);
            //只要栈不为空则表示二叉树没有遍历完成
            while(!stack.isEmpty()){
                //先序遍历比较简单,访问父节点弹出后立即打印
                //并判断是否右结点,有则入栈,然后判断是否有
                //左结点,有则入栈
                head = stack.pop();
                System.out.println(head.data);
                //会有人问为什么先右后左,因为父结点读取值
                //后不保存状态,所以先将右儿子压入栈,然后
                //再判断是否有左儿子,有的话下一次操作则先
                //对左儿子进行操作,符合先序遍历的逻辑
                if(null != head.rightChild)
                    stack.add(head.rightChild);
                if(null != head.leftChild)
                    stack.add(head.leftChild);
            }
        }
    }

    //二叉树非递归中序遍历
    private void inOrderBSTByUnRecur(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            //中序遍历是先左儿子,父结点,右儿子,所以循环条件
            //是栈不为空且当前结点不为空
            while(!stack.isEmpty() || head != null){
                //只要父结点的左儿子不为空,则进行进栈操作
                if(head != null){
                    stack.push(head);
                    head = head.leftChild;
                }else{
                    //此时已经将整颗二叉树的最左端的
                    //左儿子压入栈,然后弹出并读值,取其右节点,
                    //这时候有两种情况:1.右结点存在,则进入上一个判断
                    //取他的左儿子2.若右结点不存在,那么继续弹出并读值
                    head = stack.pop();
                    System.out.println(head.data);
                    head = head.rightChild;
                }

            }
        }
    }

    //非递归后续遍历
    private void postOrderBSTByUnRecur(Node head){
        if(null != head){
            Stack<Node> stack = new Stack<>();
            //cur为stack的栈顶元素,pre为最后一个被打印的元素(初始值为根节点)
            Node cur = null,pre = head;
            //先将根节点押入
            stack.push(pre);
            //stack为空则表示整个二叉树已遍历完
            while(!stack.isEmpty()){
                //cur为stack中的栈顶元素
                cur = stack.peek();
                //有三种情况,1.栈顶元素的左节点不为空,而最后打印元素不等于栈顶元素的左节点与右节点,
                //表示栈顶元素的左节点还未遍历,则入栈
                if(cur.leftChild != null && pre != cur.leftChild && pre != cur.rightChild){
                    stack.push(cur.leftChild);
                //2.栈顶元素的右节点不为空,而最后打印元素不等于栈顶元素的右节点,
                //表示栈顶元素的右节点还未遍历,则入栈
                }else if(cur.rightChild != null && pre != cur.rightChild){
                    stack.push(cur.rightChild);
                //3.最后,若栈顶元素的左右节点都已经被遍历或者为空,则出栈并打印,跟新最新打印节点
                }else{
                    System.out.println(stack.pop().data);
                    pre = cur;
                }
            }
        }
    }

}
