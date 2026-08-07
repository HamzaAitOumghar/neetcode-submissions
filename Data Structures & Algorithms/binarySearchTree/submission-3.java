class TreeMap {
    static class Node {
        int key;
        int val;
        Node left;
        Node right;
    }

    private Node root;

    public TreeMap() {
        this.root = null;
    }

    public void insert(int key, int val) {
        if (this.root == null) {
            root = new Node();
            root.val = val;
            root.key = key;
        } else {
            insertNode(this.root, key, val);
        }
    }

    private Node insertNode(Node root, int key, int val) {
        if (root == null) {
            Node temp = new Node();
            temp.val = val;
            temp.key = key;
            return temp;
        } else if (key > root.key) {
            root.right = insertNode(root.right, key, val);
        } else if (key < root.key) {
            root.left = insertNode(root.left, key, val);
        } else {
            root.val = val;
        }
        return root;
    }

    public int get(int key) {
        Node node = search(this.root, key);
        if (node != null) {
            return node.val;
        }
        return -1;
    }

    private Node search(Node node, int key) {
        if (node != null) {
            if (node.key == key) {
                return node;
            } else if (key > node.key) {
                return search(node.right, key);
            } else {
                return search(node.left, key);
            }
        }
        return node;
    }

    public int getMin() {
        if (this.root == null) {
            return -1;
        }

        Node temp = this.root;

        while (temp.left != null) {
            temp = temp.left;
        }

        return temp.val;
    }

    private Node minHelper(Node temp) {
        if (temp == null) {
            return null;
        }

        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public int getMax() {
        if (this.root == null) {
            return -1;
        }
        Node temp = this.root;

        while (temp.right != null) {
            temp = temp.right;
        }

        return temp.val;
    }

    public void remove(int key) {
       this.root= removeHelper(this.root, key);
    }

    private Node removeHelper(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = removeHelper(node.left, key);
        } else if (key > node.key) {
            node.right = removeHelper(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }
            
            Node minRight = minHelper(node.right);

            node.val = minRight.val;
            node.key = minRight.key;

            node.right = removeHelper(node.right, minRight.key);
        }
        return node;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> temp = new ArrayList<>();
        dfs(this.root, temp);
        return temp;
    }

    private void dfs(Node node, List<Integer> temp) {
        if (node == null) {
            return;
        }
        dfs(node.left, temp);
        temp.add(node.key);
        dfs(node.right, temp);
    }
}
