package org.example.Streams.Bibliotheksverwaltung;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private static int idCounter = 0;
    private String name;
    private int memberId;
    private List<Book> borrowedBooks;

    public Member(String name) {
        this.name = name;
        this.memberId = ++idCounter;
        this.borrowedBooks = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", memberId=" + memberId +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}