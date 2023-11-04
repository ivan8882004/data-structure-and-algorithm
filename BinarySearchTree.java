public class BinarySearchTree {
    private TreeNode root;

    public class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
    public void inorder(TreeNode root) { 
        if ( root != null) {
        inorder(root.left); //left->root->right
        System.out.println(root.val);
        inorder(root.right); }
    }

    public void postorder(TreeNode root) { 
        if ( root != null) {
        postorder(root.left);//left->right->root
        postorder(root.right); 
        System.out.println(root.val);}
    }

    public void preorder(TreeNode root) {
        if (root != null) { //root->left->right
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }


    public TreeNode insert(int val, TreeNode node) { //average-case time complexity is O(logn)
        if (node == null) {
            return new TreeNode(val);
        }

        if (val > node.val) {
            node.right = insert(val, node.right);
        } else if (val < node.val) {
            node.left = insert(val, node.left);
        }

        return node;
    }

    public TreeNode deleteTreeNode(int key,TreeNode root) {
        if(root==null) return null;
        
        if(key<root.val){                            
            root.left = deleteTreeNode(key,root.left);
            return root;
        }
        
        else if(key>root.val){
            root.right = deleteTreeNode(key,root.right);
            return root;
        }
        
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                TreeNode min = root.right;
                while(min.left!=null){
                    min = min.left;
                }
                
                root.val = min.val;
                root.right = deleteTreeNode(min.val,root.right);
                return root;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.insert(10, null);
        tree.insert(2, tree.root);
        tree.insert(15, tree.root);
        tree.insert(7, tree.root);
        tree.insert(1, tree.root);
        tree.insert(11,tree.root);
        tree.insert(100, tree.root);
        tree.deleteTreeNode(10, tree.root);
        tree.preorder(tree.root);
    }
}