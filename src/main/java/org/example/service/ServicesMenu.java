package org.example.service;

import java.util.Scanner;



public class ServicesMenu {
    private static ServicesRepository servicesRepository = new ServicesRepository();

    public static void servicesMenu(Scanner scanner){

        servicesRepository.createTable();
        boolean isExit = true;
        while(isExit){
            System.out.println("""
                    \nMenu services
                    1.View one
                    2.View All
                    3.Add
                    4.Update
                    5.Delete
                    6.Main menu
                    """);

            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch(choice){
                case 1-> viewOne(scanner);
                case 2-> viewAll();
                case 3->add(scanner);
                case 4->update(scanner);
                case 5->delete(scanner);
                case 6->//main menu();
                    isExit = false;
                default -> {
                    System.out.println("Invalid command");
                }
            }



        }
    }

    public static void viewOne(Scanner scanner){
        System.out.print("Enter id service: ");
        int id = scanner.nextInt();
        servicesRepository.getById(id);
    }
    public static void add(Scanner scanner){
        System.out.print("Enter id: ");
        int id = scanner.nextInt();

        System.out.print("Enter name: ");
        String name = scanner.next();

        servicesRepository.add(id,name);
    }
    public static void viewAll(){
        servicesRepository.get();
    }

    public static void update(Scanner scanner){
        System.out.print("Enter id: ");
        int id = scanner.nextInt();

        System.out.println("Enter name: ");
        String name = scanner.next();
        servicesRepository.update(id, name);
    }
    public static void delete(Scanner scanner){
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        servicesRepository.delete(id);
    }

}
