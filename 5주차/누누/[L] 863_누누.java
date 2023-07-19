public class Solution {

    Map<Integer, List<Integer>> edges = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root);
        Queue<Item> queue = new ArrayDeque<>();
        queue.add(new Item(target.val, 0));
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Item poll = queue.poll();
            if (visited.contains(poll.value)) {
                continue;
            }
            visited.add(poll.value);
            if (poll.depth == k) {
                result.add(poll.value);
            }
            for (int value : edges.get(poll.value)) {
                queue.add(new Item(value, poll.depth + 1));
            }
        }
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        edges.putIfAbsent(root.val, new ArrayList<>());
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            edges.putIfAbsent(left.val, new ArrayList<>());
            edges.get(root.val)
                    .add(left.val);
            edges.get(left.val)
                    .add(root.val);
        }
        if (right != null) {
            edges.putIfAbsent(right.val, new ArrayList<>());
            edges.get(root.val)
                    .add(right.val);
            edges.get(right.val)
                    .add(root.val);
        }
        dfs(left);
        dfs(right);
    }
}

class Item {

    int value;
    int depth;

    public Item(int value, int depth) {
        this.value = value;
        this.depth = depth;
    }
}
