// Solution_Main.java
// Sample solution for demonstrating the Library Book Tracker system

public class Solution_Main {
    public static void main(String[] args) {
        Solution_Library library = new Solution_Library();

        // Add books
        Solution_Book b1 = new Solution_Book("1984", "George Orwell", 1);
        Solution_Book b2 = new Solution_Book("The Hobbit", "J.R.R. Tolkien", 2);
        Solution_Book b3 = new Solution_Book("To Kill a Mockingbird", "Harper Lee", 3);
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        // Add members
        Solution_Member m1 = new Solution_Member("Alice", 100);
        Solution_Member m2 = new Solution_Member("Bob", 101);
        library.addMember(m1);
        library.addMember(m2);

        // Initial status
        System.out.println("Initial status:");
        library.printBookStatus();
        System.out.println();

        // Alice checks out The Hobbit
        System.out.println("-- Alice checks out \"The Hobbit\" --");
        library.checkOutBook(2, 100);
        library.printBookStatus();
        System.out.println();

        // Alice returns The Hobbit
        System.out.println("-- Alice returns \"The Hobbit\" --");
        library.returnBook(2);
        library.printBookStatus();
    }
} 