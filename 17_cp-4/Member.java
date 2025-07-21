// Member.java
// Represents a library member

public class Member {
    private String name;
    private int memberId;

    // Constructor
    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // Getters
    public String getName() { return name; }
    public int getMemberId() { return memberId; }

    @Override
    public String toString() {
        return "Member: " + name + " (ID: " + memberId + ")";
    }
} 