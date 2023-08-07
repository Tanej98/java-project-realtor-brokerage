package com.cestar.view;

import java.util.InputMismatchException;
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
			try {
				System.out.println("\nSelect option \n\t1.display\n\t2.insert\n\t3.update\n\t4.delete\n\t5.exit");
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
	                default:
	                	throw new InputMismatchException();
	            }
			}
			catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("\n$$Enter valid input$$");
				continue;
			}
		}
		sc.close();
	}

}
