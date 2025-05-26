package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 464);
        Book book2 = new Book("Красная шапочка", 120);
        Book book3 = new Book("Колобок", 80);
        Book book4 = new Book("Волк и семеро козлят", 100);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        System.out.println("Список книг:");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getBookTitle() + " - " + books[i].getPageCount() + " стр.");
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        System.out.println("\nПосле перестановки книг (0 <-> 3):");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getBookTitle() + " - " + books[i].getPageCount() + " стр.");
        }

        System.out.println("\nКниги с названием 'Clean code':");
        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getBookTitle())) {
                System.out.println(books[i].getBookTitle() + " - " + books[i].getPageCount() + " стр.");
            }
        }
    }
}