import java.util.Scanner;

class BankAccount {
    // Data members
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Parameterized constructor to initialize account details
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money if sufficient balance is available
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount!");
        }
    }

    // Method to check and return the current balance
    public double checkBalance() {
        return balance;
    }

    // Method to display account details and balance
    public void displayAccount() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}

class BankAccountManagement {

    // Separate method to perform deposit operation
    public static void performDeposit(BankAccount account, Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
    }

    // Separate method to perform withdrawal operation
    public static void performWithdrawal(BankAccount account, Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read account details and initial balance from user
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.next();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Account Holder Name: ");
        String accHolder = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initBalance = scanner.nextDouble();

        // Create BankAccount object using the parameterized constructor
        BankAccount myAccount = new BankAccount(accNumber, accHolder, initBalance);

        // Display initial account details
        System.out.println("\nInitial Account Status:");
        myAccount.displayAccount();

        // Perform one deposit operation using a separate method
        System.out.println();
        performDeposit(myAccount, scanner);

        // Perform one withdrawal operation using a separate method
        System.out.println();
        performWithdrawal(myAccount, scanner);

        // Display the final account details
        myAccount.displayAccount();

        scanner.close();
    }
}
