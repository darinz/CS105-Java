// Library.java
// Manages books and members

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    public Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getMemberId() == id) return m;
        }
        return null;
    }

    public boolean checkOutBook(int bookId, int memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);
        if (book != null && member != null && !book.isCheckedOut()) {
            book.checkOut(member);
            return true;
        }
        return false;
    }

    public boolean returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book != null && book.isCheckedOut()) {
            book.returnBook();
            return true;
        }
        return false;
    }

    public void printBookStatus() {
        for (Book b : books) {
            System.out.println(b);
        }
    }
} 