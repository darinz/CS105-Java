// Book.java
// Represents a book in the library

public class Book {
    private String title;
    private String author;
    private int id;
    private boolean isCheckedOut;
    private Member checkedOutBy; // null if available

    // Constructor
    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.isCheckedOut = false;
        this.checkedOutBy = null;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getId() { return id; }
    public boolean isCheckedOut() { return isCheckedOut; }
    public Member getCheckedOutBy() { return checkedOutBy; }

    public void checkOut(Member member) {
        isCheckedOut = true;
        checkedOutBy = member;
    }

    public void returnBook() {
        isCheckedOut = false;
        checkedOutBy = null;
    }

    @Override
    public String toString() {
        if (isCheckedOut && checkedOutBy != null) {
            return "Book: \"" + title + "\" by " + author + " [Checked out by: " + checkedOutBy.getName() + "]";
        } else {
            return "Book: \"" + title + "\" by " + author + " [Available]";
        }
    }
} 