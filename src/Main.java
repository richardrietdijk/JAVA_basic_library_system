import java.util.Scanner;

class LibrarySystem {
    private static String[] titles = new String[100];
    private static String[] authors = new String[100];
    private static int[] quantities = new int[100];
    private static int bookCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Library!");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4)");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    borrowBooks();
                    break;
                case 3:
                    returnBooks();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void addBooks() {
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();
        System.out.print("Enter the quantity to add: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        // Check if book already exists, if yes, update quantity
        int index = findBook(title);
        if (index != -1) {
            quantities[index] += quantity;
        } else {
            titles[bookCount] = title;
            quantities[bookCount] = quantity;
            bookCount++;
        }
        System.out.println("Book added successfully!");
    }

    private static void borrowBooks() {
        System.out.print("Enter the title of the book you want to borrow: ");
        String title = scanner.nextLine();
        System.out.print("Enter the quantity to borrow: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        int index = findBook(title);
        if (index != -1 && quantities[index] >= quantity) {
            quantities[index] -= quantity;
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("That amount is unavailable!");
        }
    }

    private static void returnBooks() {
        System.out.print("Enter the title of the book you want to return: ");
        String title = scanner.nextLine();
        System.out.print("Enter the quantity to return: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        int index = findBook(title);
        if (index != -1) {
            quantities[index] += quantity;
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("This book does not belong to our library system.");
        }
    }

    // Helper method to find book index in the array
    private static int findBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (titles[i].equals(title)) {
                return i;
            }
        }
        return -1; // Book not found
    }
}
