package com.cestar.view;

import java.util.Scanner;
import com.cestar.controller.controller;

/**
 * Menu program displays the main menu to the user and operates as per the user input
 * @author tanej
 * @author sanjay
 * @author tharun
 */
public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		controller ctlr = new controller();
		int choice = 0;
		System.out.println("Welcome to Realtor Brokerage");
		while(choice != 5) {
			System.out.println("Enter your choice \n1.display\n2.insert\n3.update\n4.delete\n5.exit");
			choice = sc.nextInt();

            switch(choice){
                case 1:
                    ctlr.displayController();
                    break;
                case 2:
                    ctlr.insertController();
                    break;
                case 3:
                    ctlr.updateController();
                    break;
                case 4:
                    ctlr.deleteController();
                    break;
                case 5:
                    choice = 5;
                    System.out.println("Thanks for using Realtor Brokerage!");
                    break;
            }
		}
		sc.close();
	}

}
