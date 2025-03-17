package org.example.Client;

import org.example.ConnectionManager;
import org.example.Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class ClientMenu {

    private static ClientRepository clientRepository = new ClientRepository();
    public static void clientMenu(Scanner scanner){
        clientRepository.createTable();
        boolean isExit = true;
        while(isExit){
            System.out.println("""
                    \nMenu clients
                    1.View one
                    2.View All
                    3.Add
                    4.Update
                    5.Delete
                    6.Main menu
                    """);

            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice){
                case 1->viewOne(scanner);
                case 2->viewAll();
                case 3->add(scanner);
                case 4->update(scanner);
                case 5->delete(scanner);
                case 6->//main menu;
                    isExit = false;
                default ->{
                    System.out.println("invalid command");
                }


            }
        }
    }

    public static void viewAll(){;
        clientRepository.get();
    }

    public static void add(Scanner scanner){
        System.out.print("Enter id: ");
        int id = scanner.nextInt();

        System.out.print("Enter name: ");
        String name = scanner.next();

        clientRepository.add(id, name);
    }
    public static void viewOne(Scanner scanner){
        System.out.print("Enter id client: ");
        int id = scanner.nextInt();
        clientRepository.getById(id);
    }

    public static void delete(Scanner scanner){
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        clientRepository.delete(id);
    }

    public static void update(Scanner scanner){
        System.out.print("Enter id: ");
        int id = scanner.nextInt();

        System.out.println("Enter name: ");
        String name = scanner.next();
        clientRepository.update(id, name);
    }



}
