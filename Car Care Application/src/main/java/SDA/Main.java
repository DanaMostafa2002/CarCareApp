package SDA;

import SDA.Controllers.AdminController;
import SDA.Controllers.UserController;
import SDA.Models.Vehicle.Vehicle;
import SDA.Services.Service;
import SDA.enums.Promocodes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Vehicle vehicle = new Vehicle();

        System.out.println("* W E L C O M E   T O   O U R   C A R   C A R E   C E N T E R *");
        // HOME PAGE MENU
        int choice = 0;
        while (choice != 3) {
            System.out.println();
            System.out.println("1. Admin panel");
            System.out.println("2. User panel");
            System.out.println("3. Exit system");
            System.out.print("Choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                // ADMIN PANEL MENU
                case 1 -> {
                    int adminChoice = 0;
                    AdminController controller = new AdminController();
                    while (adminChoice != 6) {
                        System.out.println();
                        System.out.println("1. Calculate total income");
                        System.out.println("2. Get vehicles count");
                        System.out.println("3. Enforce service package");
                        System.out.println("4. Add discount to services");
                        System.out.println("5. View all user used services");
                        System.out.println("6. Exit admin panel menu");
                        System.out.print("Choice: ");
                        adminChoice = Integer.parseInt(input.nextLine());
                        switch (adminChoice) {
                            case 1 -> {         // CALCULATE TOTAL INCOME
                                System.out.println();
                                System.out.println("The center total income is " + controller.calculateTotalIncome());
                            }
                            case 2 -> {         // GET VEHICLES COUNT
                                System.out.println();
                                System.out.println(controller.getVehiclesCount());
                            }
                            case 3 -> {         // ENFORCE SERVICE PACKAGE
                                System.out.println();
                            }
                        }
                    }
                }
                // USER PANEL MENU
                case 2 -> {
                    int userChoice = 0;
                    UserController controller = new UserController();
                    while (userChoice != 6) {
                        System.out.println();
                        System.out.println("1. Clean in vehicle");
                        System.out.println("2. Clean out vehicle");
                        System.out.println("3. Show available services");
                        System.out.println("4. Pay for a service");
                        System.out.println("5. Check discounts");
                        System.out.println("6. Exit user panel menu");
                        System.out.print("Choice: ");
                        userChoice = Integer.parseInt(input.nextLine());
                        switch (userChoice) {
                            case 1 -> {         // CLEAN IN VEHICLE
                                System.out.println();
                                System.out.print("Enter vehicle model name: ");
                                String modelName = input.nextLine();
                                System.out.print("Enter vehicle identification number: ");
                                String identificationNumber = input.nextLine();
                                System.out.print("Enter vehicle model year: ");
                                int modelYear = Integer.parseInt(input.nextLine());
                                System.out.print("Enter vehicle width: ");
                                double width = Double.parseDouble(input.nextLine());
                                System.out.print("Enter vehicle length: ");
                                double length = Double.parseDouble(input.nextLine());
                                System.out.print("Did you have parcode ? (y/n) :");
                                String in = input.next();
                                if (in.equals("y")){
                                    System.out.print("enter promocode : ");
                                    in = input.next();
                                    if (in.equals(Promocodes.FIRST_TIME.toString())||
                                            in.equals(Promocodes.WELCOME.toString()) ||
                                            in.equals(Promocodes.CARE_CARE.toString())){
                                            vehicle.setPromocode(Promocodes.WELCOME);
                                    }
                                }
                                System.out.print("Did you wont to Subscribe to membership ? (y/n) :");
                                in = input.next();
                                if (in.equals("y")){
                                    controller.SubscribeToMembership(vehicle);
                                }
                                System.out.print("Enter vehicle passenger type (1.Regular 2.Include kids 3.Include elderly): ");
                                int type = Integer.parseInt(input.nextLine());
                                System.out.println();
                                if (controller.cleanInVehicle(modelName, identificationNumber, modelYear, width, length, type) == 1) {
                                    System.out.println("Vehicle cleaned in successfully.");
                                } else {
                                    System.out.println("All workers are busy, Would you like subscribing to a waiting list ?");
                                    System.out.println("1.Yes 2.No");
                                    System.out.print("Choice: ");
                                    int subscriptionChoice = Integer.parseInt(input.nextLine());
                                    if (subscriptionChoice == 1) {
                                        controller.subscribeToWaitingList();
                                    } else {
                                        System.out.println("See you soon.");
                                    }
                                }
                            }
                            case 2 -> {         // CLEAN OUT VEHICLE
                                System.out.println();
                                System.out.print("Enter vehicle identification number: ");
                                String identificationNumber = input.nextLine();
                                double fees = controller.cleanOutVehicle(identificationNumber);
                                if (fees != -1) {
                                    System.out.println("Your cleaning fees is " + fees);
                                } else {
                                    System.out.println("No identification number found.");
                                }
                            }
                            case 3 -> {         // SHOW ALL SERVICES
                                System.out.println();
                                for(Service service: controller.askForService()){
                                    System.out.println("- " + service.getServiceName());
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}