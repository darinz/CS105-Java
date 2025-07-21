# Mini Checkpoint Project: Library Book Tracker

## Overview

You are tasked with designing a simple system to help a small library keep track of its books and members. The system should allow the library to:

- Add new books and members
- Check out books to members
- Return books
- View the status of books (available/checked out and by whom)

This project is open-ended: you can decide how to structure your classes and methods, but you must use Object Oriented Programming principles.

## Requirements

1. **Classes**
   - At minimum, create the following classes:
     - `Book`
     - `Member`
     - `Library`
   - You may add more classes if you wish.

2. **Book**
   - Fields: title, author, unique ID, checked out status, and (optionally) who has it checked out.
   - Methods: getters/setters, and any others you find useful.

3. **Member**
   - Fields: name, unique member ID, and (optionally) a list of books checked out.
   - Methods: getters/setters, and any others you find useful.

4. **Library**
   - Fields: a collection of books, a collection of members.
   - Methods:
     - Add a new book
     - Add a new member
     - Check out a book to a member
     - Return a book
     - Print the status of all books

5. **Main Method**
   - Create a `main` method to demonstrate your system:
     - Add at least 3 books and 2 members.
     - Check out and return books.
     - Print the status of all books after each operation.

6. **OOP Principles**
   - Use encapsulation (private fields, public getters/setters).
   - Use constructors to initialize objects.
   - Use methods to perform actions.
   - (Optional) Use inheritance or interfaces if you want to extend the project.

## Tips

- Focus on clear, readable code.
- Add comments to explain your logic.
- You do not need to handle user input or file I/O—just demonstrate functionality in your `main` method.

## Example Output

```
Book: "1984" by George Orwell [Available]
Book: "The Hobbit" by J.R.R. Tolkien [Checked out by: Alice]
Book: "To Kill a Mockingbird" by Harper Lee [Available]

-- Alice checks out "The Hobbit" --

Book: "1984" by George Orwell [Available]
Book: "The Hobbit" by J.R.R. Tolkien [Checked out by: Alice]
Book: "To Kill a Mockingbird" by Harper Lee [Available]

-- Alice returns "The Hobbit" --

Book: "1984" by George Orwell [Available]
Book: "The Hobbit" by J.R.R. Tolkien [Available]
Book: "To Kill a Mockingbird" by Harper Lee [Available]
```
