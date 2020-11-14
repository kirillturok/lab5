package com.company;

import java.util.Scanner;

public class Main {

    static Tree tree = new Tree();

    public static void main(String[] args) {
        System.out.println("Введите элементы дерева.");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] num = str.split("\\s+");
        for (int i=0; i<num.length;i++){
            if (num[i].matches("\\d+")) {
                tree.add(Integer.parseInt(num[i]));
                //System.out.println(Integer.parseInt(num[i])+" ");
            }
        }
        int select;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Введите\n1 - добавить элемент\n2 - поиск элемента\n3 - удаление элемента\n4 - прямой обход\n5 - симметричный обход\n6 - обратный обход\n0 - заершить программу");
            while (!scanner.hasNextInt()){
                System.out.println("Введена неверная операция.\nПовторите ввод.");
                scanner.next();
            }
            select=scanner.nextInt();
            switch (select){
                case 1:{
                    add();
                    break;
                }
                case 2:{
                    search();
                    break;
                }
                case 3:{
                    delete();
                    break;
                }
                case 4:{
                    tree.straightPrint();
                    break;
                }
                case 5:{
                    tree.simmetricPrint();
                    break;
                }
                case 6:{
                    tree.reversePrint();
                    break;
                }
                case 0: System.exit(0);
                default:{
                    System.out.println("Такой операции нет.");
                    continue;
                }
            }
        }while(true);
    }

    private static void add(){
        System.out.println("Введите элемент.");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()){
            System.out.println("Необходимо ввести целое число. Повторите ввод.");
            scanner.next();
        }
        tree.add(scanner.nextInt());
    }

    private static void search(){
        System.out.println("Введите элемент");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()){
            System.out.println("Необходимо ввести целое число. Повторите ввод.");
            scanner.next();
        }
        tree.search(scanner.nextInt());
    }

    private static void delete(){
        System.out.println("Введите элемент");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()){
            System.out.println("Необходимо ввести целое число. Повторите ввод.");
            scanner.next();
        }
        tree.delete(scanner.nextInt());
    }
}
