package org.example.Streams.Bibliotheksverwaltung;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("Book 1", "Author 1", "Thriller", 2000);
        Book book2 = new Book("Book 2", "Author 2", "Fantasy", 2023);
        Book book3 = new Book("Book 3", "Author 3", "Horror", 2010);
        Book book4 = new Book("Book 4", "Author 3", "Fantasy", 2001);
        Member member1 = new Member("Yan");
        Member member2 = new Member("Igor");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addMember(member1);
        library.addMember(member2);

        library.borrowBook(member1.getMemberId(),book1);
        library.borrowBook(member2.getMemberId(), book2);
        library.borrowBook(member1.getMemberId(),book3);
        library.borrowBook(member2.getMemberId(),book3);
        library.borrowBook(member1.getMemberId(),book2);

        System.out.println("Borrowed Books von den Mitglidern zurückgeben.");

        for(Member member : library.getMembers()) {
            System.out.println("Borrowed Books von " + member.getName());
            System.out.println(member.getBorrowedBooks());
        }

        //        library.returnBook(member1.getMemberId(), book1);
        //        System.out.println("--------------------");
        //        System.out.println(member1.getBorrowedBooks());
        //        System.out.println(member2.getBorrowedBooks());

        System.out.println("--------------------");
        System.out.println("Liste aller Bücher eines bestimmten Genres, z.B Fantasy");
        System.out.println(library.searchBookByGenre("Fantasy"));

        System.out.println("--------------------");
        System.out.println("Liste aller Autoren ohne Duplikate");
        System.out.println(library.showAllAutors());

        System.out.println("--------------------");
        System.out.println("Liste aller Bücher, die von einem bestimmten Mitglied ausgeliehen wurden");
        System.out.println("Borrowed Books von " + member1.getName());
        System.out.println(library.infoBookByMembers(member1.getMemberId()));

        System.out.println("--------------------");
        System.out.println("Top 5 der meistgeliehenen Bücher");
        System.out.println(library.topFiveBooks());

        System.out.println("--------------------");
        System.out.println("Durchschnittliches Veröffentlichungsjahr der Bücher");
        System.out.println(library.avrgYears());

        System.out.println("--------------------");
        System.out.println("Gruppierung der Bücher nach Genre");
        System.out.println(library.groupBooksByGenre());

    }
}
