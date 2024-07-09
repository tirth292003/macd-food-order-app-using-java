import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class OrderItem {
    String name;
    int quantity;
    int price;

    public OrderItem(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}


class FoodOrder {
    Scanner sc = new Scanner(System.in);

    // McDonald's
    int meals1 = 90;
    int mealm1 = 120;
    int meall1 = 150;
    int meal2 = 179;
    int meal3 = 359;
    int meal4 = 129;
    int meal5 = 199;
    int meal6 = 249;
    int meal7 = 230;
    int meal8 = 385;
    int meal9 = 209;
    int meal10 = 385;
    int meal11 = 205;
    int meal12 = 210;
    int meal13 = 385;
    int meal14s = 90;
    int meal14m = 120;
    int meal14l = 150;
    int meal15s = 120;
    int meal15m = 150;
    int meal15l = 180;

    // McCafe
    int mochafrappe = 200;
    int coldcoffee = 150;
    int americano = 165;
    int chailatte = 160;
    int hotchocolate = 180;

    // Order details
    int ch;
    int chs;
    int quantity;
    static int total;
    List<OrderItem> orderList = new ArrayList<>();

    String again;
    String size;

    // Generate bill
    // public void generateBill() {
    //     System.out.println();
    //         System.out.println("****** Thank you for ordering *******");
    //         System.out.println("****** Your Bill is : *******");
    //         System.out.println("name"+"                     "+"price "+" quantity"+"  total");
    //     for (OrderItem item : orderList) {
    //         System.out.println(item.name +"   "+item.price+"  x   "+item.quantity + "  =   " + (item.price * item.quantity));
    //     }
    //     System.out.println("Total: " + total);
    // }
    public void generateBill() {
        System.out.println();
        System.out.println("         ****** Thank you for ordering *******");
        System.out.println("             ****** Your Bill is : *******");
        System.out.printf("%-30s %-10s %-10s %-10s\n", "Name", "Price", "Quantity", "Total");
        System.out.println("==============================================================");
        for (OrderItem item : orderList) {
            System.out.printf("%-30s %-10d %-10d %-10d\n", item.name, item.price, item.quantity, (item.price * item.quantity));
        }
        System.out.println("==============================================================");
        System.out.printf("%-30s %-10s %-10s %-10d\n", "Total:", "", "", total);

        try (FileWriter writer = new FileWriter("bill.txt")) {
            writer.write("         ****** Thank you for ordering *******\n");
            writer.write("             ****** Your Bill is : *******\n");
            writer.write(String.format("%-30s %-10s %-10s %-10s\n", "Name", "Price", "Quantity", "Total"));
            writer.write("==============================================================\n");
            for (OrderItem item : orderList) {
                writer.write(String.format("%-30s %-10d %-10d %-10d\n", item.name, item.price, item.quantity, (item.price * item.quantity)));
            }
            writer.write("==============================================================\n");
            writer.write(String.format("%-30s %-10s %-10s %-10d\n", "Total:", "", "", total));
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
    

    public void addItem(String name, int quantity, int price) {
        orderList.add(new OrderItem(name, quantity, price));
        total += quantity * price;
    }
}


class mcdonalds extends FoodOrder {
    public void displayMenu() {
        System.out.println("*********** Welcome To our McDonald's ***********");
        System.out.println("=========================================================================================");
        System.out.println("           1.Mexican cheesy fries (S,M,L)                                 (90,120,150)/- ");
        System.out.println("           2.McVeggie medium meal (medium fries + medium coke)                     179/- ");
        System.out.println("           3.McCheese burger medium meal                                           359/- ");
        System.out.println("           4.Corn and Cheese burger                                                129/- ");
        System.out.println("           5.Cheesy Veg Nuggets                                                    199/- ");
        System.out.println("           6.Mc Cheese Burger                                                      249/- ");
        System.out.println("           7.Mc Spicy Paneer meal                                                  230/- ");
        System.out.println("           8.McSaver Veg Maharaja Mac Meal (Medium Fries + Medium Coke)            385/- ");
        System.out.println("           9.Mexican McAloo Tikki Meal                                             209/- ");
        System.out.println("          10.McTriple cheese burger Meal                                           385/- ");
        System.out.println("          11.McAloo Tikki burger Meal                                              205/- ");
        System.out.println("          12.Big spicy Paneer wrap                                                 210/- ");
        System.out.println("          13.McSpicy Premium Meal                                                  385/- ");
        System.out.println("          14.Coke (S,M,L)                                                 (90,120,150)/- ");
        System.out.println("          15.Fanta Float (S,M,L)                                         (120,150,180)/- ");
        System.out.println("           0.exit                         	                                             ");
        System.out.println("=========================================================================================");
    }

    public void ordermcd() {
        while (true) {
            System.out.print("Enter Your Choice: ");
            ch = sc.nextInt();
            sc.nextLine(); // Consume newline left-over
            switch (ch) {
                case 1:
                    System.out.println("You have Selected Mexican Cheesy Fries");
                    System.out.println("Enter size (S,M,L): ");
                    size = sc.nextLine();
                    if (size.equalsIgnoreCase("S")) {
                        System.out.println("Enter the desired Quantity: ");
                        quantity = sc.nextInt();
                        addItem("Mexican Cheesy Fries (S)", quantity, meals1);
                    } else if (size.equalsIgnoreCase("M")) {
                        System.out.println("Enter the desired Quantity: ");
                        quantity = sc.nextInt();
                        addItem("Mexican Cheesy Fries (M)", quantity, mealm1);
                    } else if (size.equalsIgnoreCase("L")) {
                        System.out.println("Enter the desired Quantity: ");
                        quantity = sc.nextInt();
                        addItem("Mexican Cheesy Fries (L)", quantity, meall1);
                    } else {
                        System.out.println("Enter valid choice");
                    }
                    break;
                case 2:
                    System.out.println("You have Selected McVeggie Meal");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("McVeggie Meal", quantity, meal2);
                    break;
                case 3:
                    System.out.println("You have Selected Mc Cheese Burger Meal");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("Mc Cheese Burger Meal", quantity, meal3);
                    break;
                case 4:
                    System.out.println("You have Selected Corn and Cheese Burger");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("Corn and Cheese Burger", quantity, meal4);
                    break;
                case 5:
                    System.out.println("You have Selected Cheesy Veg Nuggets");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("Cheesy Veg Nuggets", quantity, meal5);
                    break;
                case 6:
                    System.out.println("You have Selected Mc Cheese Burger");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("Mc Cheese Burger", quantity, meal6);
                    break;
                case 7:
                    System.out.println("You have Selected Mc Spicy Paneer Meal");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("Mc Spicy Paneer Meal", quantity, meal7);
                    break;
                case 8:
                    System.out.println("You have Selected McSaver Veg Maharaja Mac Meal");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("McSaver Veg Maharaja Mac Meal", quantity, meal8);
                    break;
                case 9:
                    System.out.println("You have Selected Mexican McAloo Tikki Meal");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("Mexican McAloo Tikki Meal", quantity, meal9);
                    break;
                case 10:
                    System.out.println("You have Selected McTriple Cheese Burger Meal");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("McTriple Cheese Burger Meal", quantity, meal10);
                    break;
                case 11:
                    System.out.println("You have Selected McAloo Tikki Burger Meal");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("McAloo Tikki Burger Meal", quantity, meal11);
                    break;
                case 12:
                    System.out.println("You have Selected Big Spicy Paneer Wrap");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("Big Spicy Paneer Wrap", quantity, meal12);
                    break;
                case 13:
                    System.out.println("You have Selected McSpicy Premium Meal");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("McSpicy Premium Meal", quantity, meal13);
                    break;
                case 14:
                    System.out.println("You have Selected Coke (S,M,L)");
                    System.out.println("Enter size (S,M,L): ");
                    size = sc.nextLine();
                    if (size.equalsIgnoreCase("S")) {
                        System.out.println("Enter the desired Quantity: ");
                        quantity = sc.nextInt();
                        addItem("Coke (S)", quantity, meal14s);
                    } else if (size.equalsIgnoreCase("M")) {
                        System.out.println("Enter the desired Quantity: ");
                        quantity = sc.nextInt();
                        addItem("Coke (M)", quantity, meal14m);
                    } else if (size.equalsIgnoreCase("L")) {
                        System.out.println("Enter the desired Quantity: ");
                        quantity = sc.nextInt();
                        addItem("Coke (L)", quantity, meal14l);
                    } else {
                        System.out.println("Enter valid choice");
                    }
                    break;
                case 15:
                    System.out.println("You have Selected Fanta Float (S,M,L)");
                    System.out.println("Enter size (S,M,L): ");
                    size = sc.nextLine();
                    if (size.equalsIgnoreCase("S")) {
                        System.out.println("Enter the desired Quantity: ");
                        quantity = sc.nextInt();
                        addItem("Fanta Float (S)", quantity, meal15s);
                    } else if (size.equalsIgnoreCase("M")) {
                        System.out.println("Enter the desired Quantity: ");
                        quantity = sc.nextInt();
                        addItem("Fanta Float (M)", quantity, meal15m);
                    } else if (size.equalsIgnoreCase("L")) {
                        System.out.println("Enter the desired Quantity: ");
                        quantity = sc.nextInt();
                        addItem("Fanta Float (L)", quantity, meal15l);
                    } else {
                        System.out.println("Enter valid choice");
                    }
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            System.out.println();
            System.out.print("Do you wish to order anything else from MCD (Y/N): ");
            again = sc.next();
            if (again.equalsIgnoreCase("Y")) {
                ordermcd();
            } else if (again.equalsIgnoreCase("N")) {
                System.out.println("Welcome to McCafe");
                System.out.println("===================== McCafe Menu ===================");
                System.out.println("           1. Mocha Frappe         200/-");
                System.out.println("           2. Cold Coffee          150/-");
                System.out.println("           3. Americano            165/-");
                System.out.println("           4. Chai Latte           160/-");
                System.out.println("           5. Hot Chocolate        180/-");
                System.out.println("           0. Exit");
                System.out.println("=====================================================");
                orderMc();
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public void orderMc() {
        sc.nextLine();
        while (true) {
            System.out.print("Enter Your Choice: ");
            chs = sc.nextInt();
            switch (chs) {
                case 1:
                    System.out.println("You have Selected Mocha Frappe");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("Mocha Frappe", quantity, mochafrappe);
                    break;
                case 2:
                    System.out.println("You have Selected Cold Coffee");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("Cold Coffee", quantity, coldcoffee);
                    break;
                case 3:
                    System.out.println("You have Selected Americano");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("Americano", quantity, americano);
                    break;
                case 4:
                    System.out.println("You have Selected Chai Latte");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("Chai Latte", quantity, chailatte);
                    break;
                case 5:
                    System.out.println("You have Selected Hot Chocolate");
                    System.out.println("Enter the desired Quantity: ");
                    quantity = sc.nextInt();
                    addItem("Hot Chocolate", quantity, hotchocolate);
                    break;
                case 0:
                    generateBill();
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            System.out.println();
            System.out.print("Do you wish to order anything else from McCafe (Y/N): ");
            again = sc.next();
            if (again.equalsIgnoreCase("Y")) {
                orderMc();
            } else if (again.equalsIgnoreCase("N")) {
                generateBill();
                System.exit(1);
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}

public class order {
    public static void main(String[] args) {
        mcdonalds fo1 = new mcdonalds();
        fo1.displayMenu();
        fo1.ordermcd();
        fo1.orderMc();
    }
}
