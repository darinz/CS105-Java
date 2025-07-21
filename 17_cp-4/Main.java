// Main.java
// Demonstrates the Library Book Tracker system

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books
        Book b1 = new Book("1984", "George Orwell", 1);
        Book b2 = new Book("The Hobbit", "J.R.R. Tolkien", 2);
        Book b3 = new Book("To Kill a Mockingbird", "Harper Lee", 3);
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        // Add members
        Member m1 = new Member("Alice", 100);
        Member m2 = new Member("Bob", 101);
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