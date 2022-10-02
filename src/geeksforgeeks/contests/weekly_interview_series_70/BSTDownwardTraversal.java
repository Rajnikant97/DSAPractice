package geeksforgeeks.contests.weekly_interview_series_70;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BSTDownwardTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1; //Integer.parseInt(sc.nextLine());
        while (t>0) {
            int target = 35; //Integer.parseInt(sc.nextLine());
            String s = "25 20 35 15 22 30 45 N N N N N 32 N N"; //sc.nextLine();
            Node root = buildTree(s);
            printInorder(root);
            System.out.println();
            BSTDownwardTraversal b = new BSTDownwardTraversal();
            int ans = b.verticallyDownBST(root, target);
            System.out.println(ans);
            t--;
        }
    }

    int sum = 0;

    int verticallyDownBST(Node root,int target) {
        Node x  = findTarget(root, target);
        if(x == null) {
            return -1;
        }
        dfs(x, 0);
        return sum-x.data;
    }

    public Node findTarget(Node curr, int target) {
        if(curr == null) {
            return null;
        }

        if(curr.data == target) {
            return curr;
        } else if(curr.data < target) {
            return findTarget(curr.right, target);
        } else {
            return findTarget(curr.left, target);
        }
    }

    public void dfs(Node curr, int pos) {
        if(curr == null) {
            return;
        }
        //  System.out.println(pos+" -> "+curr.data);
        if(pos == 0) {
            sum += curr.data;
        }
        dfs(curr.left, pos-1);
        dfs(curr.right, pos+1);
    }

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left=null;
            right=null;
        }
    }

    static Node buildTree(String str) {
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String[] ip = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (queue.size()>0 && i<ip.length) {
            Node currNode = queue.peek();
            queue.remove();

            String currVal = ip[i];

            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            i++;
            if(i>=ip.length){
                break;
            }

            currVal = ip[i];

            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    static void printInorder(Node root) {
        if(root == null){
            return;
        }

        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
}
