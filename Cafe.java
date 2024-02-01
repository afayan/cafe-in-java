import java.util.Scanner;

public class Cafe extends Menu{
    //add item
    //remove item
    //display items
     static Scanner sc = new Scanner(System.in);
     static Menu m1 = new Menu();

     public static void main(String args[]) {
        int option1 = 0;
        Scanner sc1 = new Scanner(System.in); // Corrected the Scanner variable name

        System.out.println("Welcome to the Shittiest cafe on Earth!");

         while (option1!=4) {
        System.out.println("1. Add Item\n2. Delete Item\n3. Display Items\n4. Exit");
        
        System.out.print("Enter your choice: ");
        option1 = sc1.nextInt();

        

        // Perform actions based on the user's choice

       
            
       
        switch (option1) {
            case 1:
                // Add item logic
                additem();

                break;
            case 2:
                // Delete item logic

                try {
                     DeleteItem();
                } catch (Exception e) {
                    System.out.println("Exception here in main function case 2");
                }
               
                break;
            case 3:
                // Display items logic
                DisplayItems();
                break;
            case 4:
                System.out.println("Exiting the Shittiest cafe on Earth. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
 }
        // Close the scanner to avoid resource leaks
        //sc1.close();
    }
        

    static void additem() {
        System.out.println("Enter the name, price, and calories\n");
    
      sc.nextLine(); // Consume the newline character

       

        System.out.print("Enter the name: ");
        String name = sc.nextLine();

        float price = 0;
        int cals = 0;
    
        // Handle invalid input for price
        while (true) {
            try {
                System.out.print("Enter the price: ");
                price = sc.nextFloat();
                sc.nextLine(); // Consume the newline character after reading the float
                break; // Break out of the loop if input is valid
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input for price. Please enter a valid float.");
                sc.nextLine(); // Consume the invalid input
            }}


            System.out.println("enter the calories ");
            cals = sc.nextInt();

             Items newItem = new Items(name, price, cals);
                m1.AddItem(newItem);
        }
    
    static void DeleteItem(){
        System.out.println("enter index number");
        Scanner sc3 = new Scanner(System.in);
        int indexN = sc3.nextInt();
        m1.deleteItem(indexN);
    }

    static void DisplayItems(){
       m1.displayItems();
    }
}
