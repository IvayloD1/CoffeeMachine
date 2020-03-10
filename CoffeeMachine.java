package machine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeMachine {

    public static void showAmount(int water, int milk, int beans, int cups, int money) {
        System.out.printf("The coffee machine has: %d ml water,%d ml milk,%d g coffee beans,%d disposable cups and %d $%n", water, milk, beans, cups, money);
    }

    public static boolean isOutOfResources(int water, int milk, int beans, int cups, String option) {
        if (cups - 1 < 0) {
            System.out.println("Sorry, not enough cups!");
            return true;
        } else if ((option.equals("1") && water - 250 < 0) || (option.equals("1") && beans - 16 < 0)) {
            System.out.println("Sorry, not enough ingredients for espresso");
            return true;
        } else if ((option.equals("2") && water - 350 < 0) || (option.equals("2") && milk - 75 < 0) || (option.equals("2") && beans - 20 < 0)) {
            System.out.println("Sorry, not enough ingredients for latte");
            return true;
        } else if ((option.equals("3") && water - 200 < 0) || (option.equals("3") && milk - 100 < 0) || (option.equals("3") && beans - 12 < 0)) {
            System.out.println("Sorry, not enough ingredients for cappuccino");
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String action;
        boolean on = true;

        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        while (on) {
            System.out.println("Write action(buy, fill, take, remaining, exit):");
            action = s.nextLine();

            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
                    String buyOption = s.nextLine();

                    if (buyOption.equals("1") || buyOption.equals("2") || buyOption.equals("3")) {
                        if (isOutOfResources(water, milk, beans, cups, buyOption)) {
                            break;
                        } else {
                            System.out.println("I have enough resources for a coffee");
                        }
                    }
                    switch (buyOption) {
                        case "1":
                            water -= 250;
                            beans -= 16;
                            cups--;
                            money += 4;
                            break;
                        case "2":
                            water -= 350;
                            milk -= 75;
                            beans -= 20;
                            cups--;
                            money += 7;
                            break;
                        case "3":
                            water -= 200;
                            milk -= 100;
                            beans -= 12;
                            cups--;
                            money += 6;
                            break;
                        case "back":
                            break;
                        default:
                            System.out.println("Please, enter a valid option!");
                            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
                            s.nextLine();
                    }
                    break;

                case "fill":
                    try {
                        Scanner scan = new Scanner(System.in);
                        System.out.println("Write how many ml of water do you want to add: ");
                        water += scan.nextInt();
                        System.out.println("Write how many ml of milk do you want to add: ");
                        milk += scan.nextInt();
                        System.out.println("Write how many grams of coffee beans do you want to add: ");
                        beans += scan.nextInt();
                        System.out.println("Write how many disposable cups of coffee do you want to add: ");
                        cups += scan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("You have entered a non-numeric value!");
                    }
                    break;
                case "take":
                    System.out.println("I am giving  you: " + money + " $");
                    money = 0;
                    break;
                case "remaining":
                    showAmount(water, milk, beans, cups, money);
                    break;
                case "exit":
                    on = false;
                    break;
                default:
                    break;
            }
        }
    }
}












