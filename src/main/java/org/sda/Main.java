package org.sda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sda.service.PeopleService;
import org.sda.service.PositionService;
import org.sda.util.HibernateUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        do {
            System.out.println("Enter your choice:\n1. Show actual position\n2. Show ISS speed\n3. Show number of people in space\n4. Show names of people in space\n5. Show names of crafts in space\n0. Exit");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println(PositionService.showActualPosition());
                    break;
                case 2:
                    System.out.println(PositionService.calculateSpeed());
                    break;
                case 3:
                    System.out.println(PeopleService.getNumberOfPeople());
                    break;
                case 4:
                    PeopleService.showNamesOfPeople();
                    break;
                case 5:
                    PeopleService.showNamesOfCrafts();
                    break;
                default:
                    System.out.println("Goodbye!");
            }
        } while (choice != 0);
    }
}