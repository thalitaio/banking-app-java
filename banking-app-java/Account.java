import java.util.Scanner;

public class Account {
    // Class variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    // Clas constructor
    Account(String cname, String cid){
        customerName = cname;
        customerID = cid;
    }

    // Function for depositing money
    void deposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    // Funcion for withdrawing money
    void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured.");
        }
    }
    // Function showing the main menu
    void showMenu(){
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Exit");

        do{
            System.out.println();
            System.out.println("Enter an option: ");
            char optional = sc.next().charAt(0);
            option = Character.toUpperCase(optional);
            System.out.println();

            switch(option){
                //case A allows the user to check their account balance
                case 'A':
                    System.out.println("==========================");
                    System.out.println("Balance = $ " + balance);
                    System.out.println("==========================");
                    System.out.println();
                    break;
                
                //case B allows the user to deposit money
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                // Case C allows user to withdraw money from their account 
                case 'C':
                System.out.println("Enter an amount to withdraw: ");
                int amount2 = sc.nextInt();
                withdraw(amount2);
                System.out.println();
                break;

                //Case D allows user to view most recent transaction
                case 'D':
                System.out.println("==========================");
                getPreviousTransaction();
                System.out.println("==========================");
                System.out.println();
                break;

                //Case E exits
                case 'E':
                System.out.println("==========================");
                break;

                default:
                System.out.println("Error: invalid option. Please enter A, B, C, D or E.");
                break;
            }
        } while (option != 'E');
        System.out.println("Thank you for banking with us!");
    }
}
