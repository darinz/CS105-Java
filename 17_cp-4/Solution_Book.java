// Solution_Book.java
// Sample solution for the Book class in the Library Book Tracker project

public class Solution_Book {
    private String title;
    private String author;
    private int id;
    private boolean isCheckedOut;
    private Solution_Member checkedOutBy; // null if available

    // Constructor
    public Solution_Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.isCheckedOut = false;
        this.checkedOutBy = null;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getId() { return id; }
    public boolean isCheckedOut() { return isCheckedOut; }
    public Solution_Member getCheckedOutBy() { return checkedOutBy; }

    // Check out the book to a member
    public void checkOut(Solution_Member member) {
        isCheckedOut = true;
        checkedOutBy = member;
    }

    // Return the book
    public void returnBook() {
        isCheckedOut = false;
        checkedOutBy = null;
    }

    // String representation
    @Override
    public String toString() {
        if (isCheckedOut && checkedOutBy != null) {
            return "Book: \"" + title + "\" by " + author + " [Checked out by: " + checkedOutBy.getName() + "]";
        } else {
            return "Book: \"" + title + "\" by " + author + " [Available]";
        }
    }
} 