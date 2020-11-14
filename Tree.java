package com.company;

public class Tree {
    private class Node {
        int data;
        Node left;
        Node right;

        //конструктор
        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    //указатель на корень дерева
    public Node head = null;

    //метод добавления элемента в дерево
    public void add(int data) {
        //создаем новый узел
        Node node = new Node(data, null, null);
        //если дерево пустое, то запишем новый узел в качестве корня
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;
        //итеративно найдем место для нового элемента
        while (true) {
            //если новый элемент меньше текущего и у текущего есть потомок, то перейдем к этому потомку
            if (data < current.data && current.left != null) {
                current = current.left;
                continue;
            }
            //аналогично предыдущему
            if (data >= current.data && current.right != null) {
                current = current.right;
                continue;
            }
            //если новый элемент меньше текущего и у текущего нет левого потомка
            //(если б он был, мы бы не дошли до этого, итерация завершилась бы выше),
            //запишем новый элемент в качестве левого потомка для текущего
            if (data < current.data) {
                current.left = node;
                //аналогично, если больше либо равен
            } else current.right = node;
            return;
        }
    }

    //этот метод вызывается из класса Main
    public void straightPrint() {
        if (head == null) {
            System.out.println("В дереве нет элементов.");
            return;
        }
        System.out.println("Прямой обход дерева.");
        //вызов рекурсивного метода для обхода дерева
        straight(head);
        System.out.println();
    }

    //метод для рекурсивного прямого обхода
    private void straight(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            straight(node.left);
            straight(node.right);
        }
    }
 //метод, который вызывается из другого класса
    public void reversePrint() {
        if (head == null) {
            System.out.println("В дереве нет элементов.");
            return;
        }
        System.out.println("Обратный обход дерева.");
        //вызов рекурсивного метода
        reverse(head);
        System.out.println();
    }

    //метод для рекурсивного обратного обхода
    private void reverse(Node node) {
        if (node != null) {
            reverse(node.left);
            reverse(node.right);
            System.out.print(node.data + " ");
        }
    }
    //метод вызывается из другого класса
    public void simmetricPrint() {
        if (head == null) {
            System.out.println("В дереве нет элементов.");
            return;
        }
        System.out.println("Симметричный обход дерева.");
        //вызов рекурсивного метода для обхода
        symmetric(head);
        System.out.println();
    }

    //метод для рекурсивного симметричного обхода
    private void symmetric(Node node) {
        if (node != null) {
            symmetric(node.left);
            System.out.print(node.data + " ");
            symmetric(node.right);
        }
    }
//метод поиска элемента, который вызывается из другого класса
    public void search(int key) {
        if (head == null) {
            System.out.println("В дереве нет элементов.");
            return;
        }
        if (srch(head, key) != null) {
            System.out.println("Такой элемент есть.");
        } else {
            System.out.println("Такого элемента нет.");
        }
    }

    //рекурсивный метод поиска
    //возвращает ссылку на элемент
    private Node srch(Node current, int key) {
        if (current == null) return null;
        if (key == current.data) return current;
        if (key < current.data) return srch(current.left, key);
        return srch(current.right, key);
    }

    public void delete(int key) {
        if (head == null) {
            System.out.println("В дереве нет элементов.");
            return;
        }
        remove(head, key);
    }


    //рекурсивный
    private Node remove(Node current, int key) {
        if (current == null) return null;
        if (key < current.data) current.left = remove(current.left, key);
        else if (key > current.data) current.right = remove(current.right, key);
        else {
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;
            current.data = min(current.right);
            current.right = remove(current.right, current.data);
        }
        return current;
    }

    private int min(Node current) {
        int min = current.data;
        while (current.left != null) {
            min = current.left.data;
            current = current.left;
        }
        return min;
    }

}
