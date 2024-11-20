package seviceImpl;

import database.Database;
import models.Library;

import java.util.List;

public class LibraryServiceImpl implements service.LibraryService {
   // Database database = new Database();

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
         Database.libraries.addAll(libraries);
         return Database.libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return Database.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : Database.libraries) {
            if (library.getId()==(id)) {
                return library;
            }}
        return null;
        }
    @Override
    public Library updateLibrary(Long id, Library library) {

        for (Library oldlibrary : Database.libraries) {
            if (library.getId() == id) {
                oldlibrary.setName(library.getName());
                oldlibrary.setAddress(library.getAddress());
                System.out.println(oldlibrary);
                return oldlibrary;
            }
        }
        return null;

    }

    @Override
    public String deleteLibrary(Long id) {
        for (Library library: Database.libraries){
            if (library.getId().equals(id)){
                Database.libraries.remove(library);
                return "Deleted successfully";
            }
        }
        return "Library " +id +" not found";
    }

}


