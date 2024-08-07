package org.example.Streams.Bibliotheksverwaltung;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

public class Library {

        private List<Book> books;
        private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }
    public void addMember(Member member) {
        this.members.add(member);
    }


    // Ein Buch an ein Mitglied ausleihen.
        public void borrowBook(int memberId, Book book) {
            Member member = members.stream()
                    .filter(m -> m.getMemberId() == memberId)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Member not found"));
            if (!member.getBorrowedBooks().contains(book)) {
                member.borrowBook(book);
                book.incrementBorrowCount();
            }
        }

        public void returnBook(int memberId, Book book) {
            Member member = members.stream()
                    .filter(m -> m.getMemberId() == memberId)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Member not found"));
                     member.returnBook(book);
                     if (member.getBorrowedBooks().remove(book)) {
                     book.decrementBorrowCount();
                     } else {
                                throw new IllegalArgumentException("Book not found in member's borrowed list");
            }
        }


        public List<Book> searchBookByGenre(String genre) {
            return books.stream()
                    .filter(book->book.getGenre().equalsIgnoreCase(genre))
                    .collect(Collectors.toList());
        }

        public List<String> showAllAutors(){
            return books.stream()
                    .map(Book::getAuthor)
                    .collect(Collectors.toSet())
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
        }


        public List<Book> infoBookByMembers(int memberId){
            Member member = members.stream()
                    .filter(m -> m.getMemberId() == memberId)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Member not found"));
            return member.getBorrowedBooks();
        }

        public List<Book> topFiveBooks(){
        return books.stream()
                .sorted((b1,b2)->Integer.compare(b2.getBorrowCount(), b1.getBorrowCount()))
                .limit(5)
                .collect(Collectors.toList());
        }

        public double avrgYears(){
        return books.stream()
                .mapToInt(q->q.getPublicationYear())
                .average()
                .getAsDouble();
        }

         public Map<String, List<Book>> groupBooksByGenre() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
    }
}
