package seviceImpl;

import models.Book;
import database.Database;
import models.Library;
import models.Reader;
import service.LibraryService;

import java.util.Collections;
import java.util.List;

public class BookServiceImpl implements service.BookService {

    @Override
    public Book saveBook(Long libraryId, Book book) {
        for(Library library:Database.libraries){
            if(library.getId()== libraryId){
                library.getBooks().add(book);
                return book;

            }
        }

        System.out.println("not found");
        return null;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
            for (Library library : Database.libraries) {
                if (library.getId()==(libraryId)) {
                    return library.getBooks();
                }
            }
            return Collections.emptyList();
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        Library library = new LibraryServiceImpl().getLibraryById(libraryId);
        for (Book book: library.getBooks()){
            if (book.getId().equals(bookId)){
                return book;
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId){
        for(Library library: Database.libraries) {
            if (library.getId() == libraryId) {
                for (Reader reader : Database.readers) {
                    if (reader.getId() == libraryId) {
                        library.getReaders();
                    }
                }
            }
        }return "Success full delete";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library : Database.libraries) {
            if (library != null) {
                library.getBooks().clear();
            }
        }
    }
}