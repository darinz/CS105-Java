// Solution_Library.java
// Sample solution for the Library class in the Library Book Tracker project

import java.util.ArrayList;

public class Solution_Library {
    private ArrayList<Solution_Book> books;
    private ArrayList<Solution_Member> members;

    // Constructor
    public Solution_Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Add a new book
    public void addBook(Solution_Book book) {
        books.add(book);
    }

    // Add a new member
    public void addMember(Solution_Member member) {
        members.add(member);
    }

    // Find a book by its ID
    public Solution_Book findBookById(int id) {
        for (Solution_Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    // Find a member by their ID
    public Solution_Member findMemberById(int id) {
        for (Solution_Member m : members) {
            if (m.getMemberId() == id) return m;
        }
        return null;
    }

    // Check out a book to a member
    public boolean checkOutBook(int bookId, int memberId) {
        Solution_Book book = findBookById(bookId);
        Solution_Member member = findMemberById(memberId);
        if (book != null && member != null && !book.isCheckedOut()) {
            book.checkOut(member);
            return true;
        }
        return false;
    }

    // Return a book
    public boolean returnBook(int bookId) {
        Solution_Book book = findBookById(bookId);
        if (book != null && book.isCheckedOut()) {
            book.returnBook();
            return true;
        }
        return false;
    }

    // Print the status of all books
    public void printBookStatus() {
        for (Solution_Book b : books) {
            System.out.println(b);
        }
    }
} 