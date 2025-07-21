// Solution_Member.java
// Sample solution for the Member class in the Library Book Tracker project

public class Solution_Member {
    private String name;
    private int memberId;

    // Constructor
    public Solution_Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // Getters
    public String getName() { return name; }
    public int getMemberId() { return memberId; }

    // String representation
    @Override
    public String toString() {
        return "Member: " + name + " (ID: " + memberId + ")";
    }
} 