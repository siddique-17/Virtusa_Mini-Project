import java.util.Scanner;

public class LibraryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Add User");
            System.out.println("6. View Users");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine(); 
                    BookDAO.addBook(title, author, qty);
                    break;

                case 2:
                    BookDAO.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter keyword: ");
                    String key = sc.next();
                    BookDAO.searchBook(key);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    BookDAO.deleteBook(id);
                    break;

                case 5:
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    UserDAO.addUser(name, email);
                    break;

                case 6:
                    UserDAO.viewUsers();
                    break;

                case 7:
                    System.out.print("Book ID: ");
                    int bId = sc.nextInt();
                    System.out.print("User ID: ");
                    int uId = sc.nextInt();
                    TransactionDAO.issueBook(bId, uId);
                    break;

                case 8:
                    System.out.print("Transaction ID: ");
                    int tId = sc.nextInt();
                    TransactionDAO.returnBook(tId);
                    break;

                case 9:
                    System.out.println("👋 Exiting...");
                    System.exit(0);
            }
        }
    }
}