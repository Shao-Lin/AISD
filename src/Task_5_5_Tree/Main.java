package Task_5_5_Tree;

import java.util.*;

class Task {
    private static class Node<T> {
        Node<T> left, right;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    private static Node test1() {
        Node<Integer> root = new Node<Integer>(1);
        Node<Integer> n11 = new Node<Integer>(2);
        Node<Integer> n12 = new Node<Integer>(3);
        Node<Integer> n21 = new Node<Integer>(4);
        Node<Integer> n22 = new Node<Integer>(5);
        Node<Integer> n23 = new Node<Integer>(6);
        Node<Integer> n24 = new Node<Integer>(7);
        Node<Integer> n31 = new Node<Integer>(8);
        Node<Integer> n32 = new Node<Integer>(9);
        Node<Integer> n33 = new Node<Integer>(10);
        Node<Integer> n34 = new Node<Integer>(11);
        Node<Integer> n41 = new Node<Integer>(12);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;

        n33.left = n41;
        return root;
    }

    private static Node<Integer> test2() {
        Node<Integer> root = new Node<Integer>(2);
        Node<Integer> n11 = new Node<Integer>(7);
        Node<Integer> n12 = new Node<Integer>(5);
        Node<Integer> n21 = new Node<Integer>(2);
        Node<Integer> n22 = new Node<Integer>(6);
        Node<Integer> n23 = new Node<Integer>(9);
        Node<Integer> n31 = new Node<Integer>(5);
        Node<Integer> n32 = new Node<Integer>(8);
        Node<Integer> n33 = new Node<Integer>(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.right = n23;

        n22.left = n31;
        n22.right = n32;
        n23.left = n33;


        return root;
    }

    public static Node dfsDeleteLeaves(Node root) {
        if (root == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node nodeParent = null; // родитель
        Stack<Node> saveParent = new Stack<>();
        saveParent.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node.left == null && node.right == null && getLevel(root, node, 1) < maxDepth(root)) { // проверка основного условия
                stack.pop();
                if(saveParent.peek() != nodeParent && saveParent.peek().right == node){
                    nodeParent = saveParent.pop();
                }
                if (nodeParent.left == null)
                    nodeParent.right = null;
                    // если у родителя один потомок
                else if (nodeParent.right == null)
                    nodeParent.left = null;

                else {                                       //если потомков 2
                    if (nodeParent.left.left == null && nodeParent.left.right == null)
                        nodeParent.left = null;
                    else
                        nodeParent.right = null;
                }
            } else
                nodeParent = stack.pop();
            if(node.left != null){
                if(nodeParent.left.left != null || nodeParent.left.right != null)
                saveParent.push(nodeParent);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (stack.size() == 1 && getLevel(root, node, 1) == maxDepth(root)) {
                nodeParent = root;  // для последнего проверяемого узла из левого поддерева, чтобы переопределить родителя для правого поддерева
                saveParent.push(root);
            }
        }
        return root;
    }

    public static int getLevel(Node root, Node target, int level) { // функция для нахождения уровня конкретного узла
        if (root == null) {
            return -1; // Узел не найден
        }

        if (root == target) {
            return level; // Узел найден, возвращаем его уровень
        }

        int leftLevel = getLevel(root.left, target, level + 1); // Поиск уровня в левом поддереве
        if (leftLevel != -1) {
            return leftLevel; // Узел найден в левом поддереве
        }

        int rightLevel = getLevel(root.right, target, level + 1); // Поиск уровня в правом поддереве
        return rightLevel; // Узел найден в правом поддереве или отсутствует в дереве
    }

    public static int maxDepth(Node root) {  // функция для нахождения макс уровня дерева
        if (root == null) {
            return 0;
        }

        return maxDepthHelper(root, 1); // Вызываем вспомогательную функцию с начальным уровнем 1
    }

    private static int maxDepthHelper(Node node, int level) {
        if (node == null) {
            return level - 1; // Возвращаем текущий уровень минус 1 (т.к. не учитываем уровень пустого узла)
        }

        int leftDepth = maxDepthHelper(node.left, level + 1);
        int rightDepth = maxDepthHelper(node.right, level + 1);
        return Math.max(leftDepth, rightDepth);
    }

    private static void outputTree(Node node, int level) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(node.data);
        outputTree(node.right, level + 1);
        outputTree(node.left, level + 1);
    }


    public static void main(String[] args) {
        outputTree(test1(), 1);
        System.out.println("-----------------------------------");
        outputTree(dfsDeleteLeaves(test1()), 1);
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        outputTree(test2(), 1);
        System.out.println("-----------------------------------");
        outputTree(dfsDeleteLeaves(test2()), 1);
    }
}

