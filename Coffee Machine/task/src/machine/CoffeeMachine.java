package machine;
import java.util.Scanner;

public class CoffeeMachine {
    private Scanner scanner;
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    private CoffeeMachine() {
        this.scanner = new Scanner(System.in);
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        boolean status;
        do {
            status = machine.processAction();
        }
        while (status);
    }

    public void printState() {
        System.out.println("The coffee mashine has:\n" +
                String.format("%d of water \n", this.water) +
                String.format("%d of milk \n", this.milk) +
                String.format("%d of coffee beans \n", this.beans) +
                String.format("%d of disposable cups \n", this.cups) +
                String.format("%d of money \n", this.money));
    }

    public void processBuy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappucino, back - to main menue:");
        String type = this.scanner.nextLine();
        if (type.equals("back")) return;

        this.buy(Integer.valueOf(type));
    }

    private void processFill() {
        System.out.println("Write how many ml of water do you want to add:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int beans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups = scanner.nextInt();

        this.fill(water, milk, beans, cups);
    }

    private void processTake() {
        System.out.println(String.format("I gave you $%d", this.money));
        this.take();
    }

    private void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }

    private void take() {
        this.money = 0;
    }

    private void buy (int type) {
        int water = 0;
        int milk = 0;
        int beans = 0;
        int money = 0;

        switch (type) {
            case 1: {
                water = 250;
                milk = 0;
                beans = 16;
                money = 4;
                break;
            }
            case 2: {
                water = 350;
                milk = 75;
                beans = 20;
                money = 7;
                break;
            }
            case 3: {
                water = 200;
                milk = 100;
                beans = 12;
                money = 6;
                break;
            }
            default: {
                break;
            }
        }

        if (this.water < water) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.beans < beans) {
            System.out.println("Sorry, not enough beans!");
        } else if (this.cups < 1) {
            System.out.println("Sorry, not enough disposable cups");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= water;
            this.milk -= milk;
            this.beans -= beans;
            this.cups--;
            this.money += money;
        }
    }

    public boolean processAction () {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = this.scanner.nextLine();

        switch (action) {
            case "buy": {
                this.processBuy();
                break;
            }
            case "fill": {
                this.processFill();
                break;
            }
            case "take": {
                this.processTake();
                break;
            }
            case "remaining": {
                this.printState();
                break;
            }
            case "exit": {
                return false;
            }
            default: {
                break;
            }
        }
        return true;
    }
}





        /*System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");

        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            String action = scanner.nextLine();

            if (action.equals("buy")) {

                String selection = scanner.nextLine();

                if (selection.equals("1")) {
                    boolean enoughWater = water >= 250;
                    boolean enoughMilk = milk >= 0;
                    boolean enoughBeans = beans >= 16;
                    boolean enoughCups = cups > 0;
                    if (enoughWater && enoughMilk && enoughBeans && enoughCups) {
                        System.out.println("I have enough resources, making you a coffee!");
                        water -= 250;
                        beans -= 16;
                        cups -= 1;
                        money += 4;
                    } else {
                        System.out.println("Sorry, not enough resources");
                    }
                } else if (selection.equals ("2")) {
                    boolean enoughWater = water >= 350;
                    boolean enoughMilk = milk >= 75;
                    boolean enoughBeans = beans >= 20;
                    boolean enoughCups = cups > 0;
                    if (enoughWater && enoughMilk && enoughBeans && enoughCups) {
                        System.out.println("I have enough resources, making you a coffee!");
                        water -= 350;
                        milk -= 75;
                        beans -= 20;
                        cups -= 1;
                        money += 7;
                    } else {
                        System.out.println("Sorry, not enough resources");
                    }
                } else if (selection.equals("3")) {
                    boolean enoughWater = water >= 200;
                    boolean enoughMilk = milk >= 100;
                    boolean enoughBeans = beans >= 12;
                    boolean enoughCups = cups > 0;
                    if (enoughWater && enoughMilk && enoughBeans && enoughCups) {
                        System.out.println("I have enough resources, making you a coffee!");
                        water -= 200;
                        milk -= 100;
                        beans -= 12;
                        cups -= 1;
                        money += 6;
                    } else {
                        System.out.println("Sorry, not enough resources");
                    }
                }
            } else if (action.equals("fill")) {

            } else if (action.equals("take")) {

            } else if (action.equals("remaining")) {
                System.out.println("The coffee machine has:");
                System.out.println(water + " of water");
                System.out.println(milk + " of milk");
                System.out.println(beans + " of coffee beans");
                System.out.println(cups + " of disposable cups");
                System.out.println(money + " of money");
            } else if (action.equals("exit")) {
                keepGoing = false;
            }
        }

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int cupsWater = water / 200;
        int cupsMilk = milk / 50;
        int cupsBeans = coffeBeans / 15;

        int min = cupsWater < cupsMilk ? cupsWater < cupsBeans ? cupsWater : cupsBeans : cupsMilk < cupsBeans ?
                cupsMilk : cupsBeans;

        if (min == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (min > cups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (min - cups) + " more than that");
        } else {
            System.out.println("No, I can make only " + min + " cup(s) of coffee");
        }*/



        /*System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(cups * 200 + " ml of water");
        System.out.println(cups * 50 + " ml of milk");
        System.out.println(cups * 15 + " g of coffee beans");*/


        /*System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");*/
