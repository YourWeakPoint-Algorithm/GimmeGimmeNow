
public class Solution {
    public int minDepth(TreeNode root) {
        Queue<Item> queue = new ArrayDeque<>();
        if(root==null){
            return 0;
        }
        queue.add(new Item(root, 1));
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.start.left == null && item.start.right == null) {
                return item.depth;
            }
            if (item.start.left != null) {
                queue.add(new Item(item.start.left, item.depth + 1));
            }
            if (item.start.right != null) {

                queue.add(new Item(item.start.right, item.depth + 1));
            }
        }
        return 0;
    }
}

class Item {

    TreeNode start;
    int depth;

    public Item(TreeNode start, int depth) {
        this.start = start;
        this.depth = depth;
    }
}
