package seviceImpl;

import database.Database;
import models.Library;
import models.Reader;
import service.LibraryService;

import java.util.List;

public class ReaderServiceImpl implements service.ReaderService {


//    private final LibraryService libraryService;
//
//    public ReaderServiceImpl(LibraryService libraryService) {
//        this.libraryService = libraryService;


    @Override
    public void saveReader(Reader reader) {
        Database.readers.add(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return Database .readers;
    }

    @Override
    public Reader getReaderById(Long id) {
      for(Reader reader : Database.readers)
          if(reader.getId()==id){
              return reader;
          }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Reader oldreader : Database.readers) {
            if (oldreader.getId() == id) {
                oldreader.setFullName(reader.getFullName());
                oldreader.setEmail(reader.getEmail());
                return oldreader;
            }
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
       for(Library library : Database.libraries){
           if(library.getId()== libraryId){
               for(Reader reader: Database.readers){
                   if(reader.getId()==readerId){
                       library.getReaders();
                   }
                }
            }}}}

