package binary_tree;

import java.util.*;

public class SerializeAndDeserialize {

/**
    // 层序遍历 + ”数组索引的对应关系 i-2*i+1-2*i+2“ 来解树和造树
    public String serialize(TreeNode root) {
        List<String> arr = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        int levelNum = 0;
        if (root == null) {
            return "[null]";
        }
        boolean allNone = false;
        queue.addLast(root);
        while (!allNone) {
            allNone = true;
            levelNum++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.pollFirst();
                if (cur == null) {
                    arr.add("null");
                    queue.addLast(null);
                    queue.addLast(null);
                } else {
                    allNone = false;
                    arr.add(String.valueOf(cur.val));
                    queue.addLast(cur.left);
                    queue.addLast(cur.right);
                }
            }
        }
        // 把最后全是 null 的一个空层给去除掉
        for (int i = 0; i < 1<<(levelNum-1); i++) {
            arr.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String str : arr) {
            sb.append(str + ",");
        }
        int lastIndex = sb.lastIndexOf(",");
        sb.setCharAt(lastIndex, ']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;
        data = data.substring(1,data.length()-1);   // 去掉前后的[]
        String[] list = data.split(",");

        List<TreeNode> nodeList = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals("null")) {
                nodeList.add(null);
            } else {
                TreeNode cur = new TreeNode(Integer.parseInt(list[i]));
                nodeList.add(cur);
            }
        }
        int size = nodeList.size();
        int index = (size-3)/2;
        for(int i=0; i<=index; i++){
            if(nodeList.get(i) == null){
                continue;
            }
            nodeList.get(i).left = nodeList.get(2*i+1);
            nodeList.get(i).right = nodeList.get(2*i+2);
        }
        return nodeList.get(0);
    }
}
*/

/**
    // 层序遍历 + for 循环父子节点配对
    public String serialize(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        if(root == null) return "";
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.pollFirst();
            if(cur == null){
                list.add("null");
            }
            if(cur != null){
                list.add(String.valueOf(cur.val));
                queue.addLast(cur.left);
                queue.addLast(cur.right);
            }
        }
        return String.join(",",list);
    }
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] list = data.split(",");
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        queue.addLast(root);
        for(int i=1; i < list.length-1; i++){
            TreeNode cur = queue.pollFirst();
            if(!list[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(list[i]));
                cur.left = left;
                queue.addLast(left);
            }else{
                cur.left = null;
            }
            i++;
            if(!list[i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(list[i]));
                cur.right = right;
                queue.addLast(right);
            }else{
                cur.right = null;
            }
        }
        return root;
    }
 */


    // 递归-前序遍历
public String serialize(TreeNode root) {
    List<String> list = new ArrayList<>();
    if(root == null) return "";
    preOrder(root,list);
    return String.join(",",list);
}

    public TreeNode deserialize(String data) {
        Deque<String> queue = new ArrayDeque<>();
        if(data.equals("")) return null;
        String[] str = data.split(",");
        for(String s:str){
            queue.addLast(s);
        }
        return deserializeHelper(queue);
    }

    void preOrder(TreeNode root, List<String> list){
        if(root == null){
            list.add("null");
            return;
        }
        list.add(String.valueOf(root.val));
        preOrder(root.left,list);
        preOrder(root.right,list);
    }

    TreeNode deserializeHelper(Deque<String> queue){
        String val = queue.pollFirst();
        if(val.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }
}
