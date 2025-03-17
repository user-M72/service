package org.example;

import org.example.Client.ClientMenu;
import org.example.service.ServicesMenu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isExit= true;
        while(isExit){
            System.out.println("""
                    \nMenu
                    1.Clients
                    2.Services
                    3.Requests
                    4.Exit
                    """);

            Scanner menu = new Scanner(System.in);
            int choice = menu.nextInt();
            switch (choice){
                case 1-> ClientMenu.clientMenu(menu);
                case 2-> ServicesMenu.servicesMenu(menu);
                case 3-> {}//RequestMenu.requestMenu(menu);
                case 4-> isExit = false;

                default -> System.out.println("error");
            }
        }
    }
}