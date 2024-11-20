import database.Database;
import enums.Gender;
import enums.Genre;
import models.Book;
import models.Library;
import models.Reader;
import service.BookService;
import service.LibraryService;
import service.ReaderService;
import seviceImpl.BookServiceImpl;
import seviceImpl.LibraryServiceImpl;
import seviceImpl.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static database.Database.libraries;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    LibraryService libraryService = new LibraryServiceImpl();
        BookService bookService = new BookServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();

        // Sample libraries, books, and readers
        List<Library> libraries = new ArrayList<>();
        libraries.add(new Library(1L, "Bayalinova", "Sovetskii"));
        libraries.add(new Library(2L, "A.Osmonov", "Abdarahmanova"));

        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Kyzyl alma", "Ch.Aitmatov", Genre.ROMANCE));
        books.add(new Book(2L, "Erte kelgen turnalar", "Ch.Aitmatov", Genre.ROMANCE));

        List<models.Reader> readers = new ArrayList<>();
        readers.add(new models.Reader(1L, "Gulnyr", "g@gmail", "500360300", Gender.MALE));
        readers.add(new models.Reader(2L, "Sakina", "s@gmail", "777128562", Gender.MALE));

        while (true) {
            System.out.println("Меторду коруу учун танданыз:");
            System.out.println("1. Save Library");
            System.out.println("2. Get All Libraries");
            System.out.println("3. Get Library by ID");
            System.out.println("4. Update Library");
            System.out.println("5. Delete Library");
            System.out.println("6. Save Book");
            System.out.println("7. Get All Books");
            System.out.println("8. Get Book by ID");
            System.out.println("9. Clear Books");
            System.out.println("10. Save Reader");
            System.out.println("11. Get All Readers");
            System.out.println("12. Get Reader by ID");
            System.out.println("13. Update Reader");
            System.out.println("14. Assign Reader to Library");
            System.out.println("15. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1-> libraryService.saveLibrary(libraries);

                case 2-> System.out.println(libraryService.getAllLibraries());

                case 3-> System.out.println(libraryService.getLibraryById(1L));

                case 4->System.out.println(libraryService.updateLibrary(2L, new Library(2L, "Updated Library", "New Address")));
                    System.out.print(" library ID to update: ");

                case 5->System.out.println(libraryService.deleteLibrary(1L));

                    System.out.print("library ID to delete: ");

                case 6->System.out.println(bookService.saveBook(2L, new Book(3L, "New Book", "Author", Genre.ROMANCE)));
                    System.out.print("library ID for the book: ");

                case 7-> System.out.println(bookService.getAllBooks(1L));
                    System.out.print("library ID to get books: ");

                case 8-> System.out.println(bookService.getBookById(1L,2L));
                    System.out.print("library ID and book ID: ");

                case 9-> bookService.clearBooksByLibraryId(3L);
                    System.out.print(" library ID to clear books: ");

                case 10-> readerService.saveReader(new Reader(1L,));

                case 11->System.out.println(readerService.getAllReaders());
                    System.out.println("Getting all readers...");

                case 12->System.out.println(readerService.getReaderById(1L));
                    System.out.print(" Reader ID: ");

                case 13->System.out.println(readerService.updateReader(2L,new models.Reader(2L, "Updated Name", "updated@gmail.com", "123456789", Gender.FEMALE); ));
                    System.out.print(" Reader ID to update: ");

                case 14-> readerService.assignReaderToLibrary(1L, 1L);
//
                case 15->{
                    return;
                }

            }}}}






































