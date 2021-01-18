import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class Bookstore {
    private final String nameBookstore;
    private final int maxBookstoreCapacity;
    private List<Book> BookList = new ArrayList<Book>();
    private final Map<Book, Integer> count = new LinkedHashMap<>();

    public Bookstore(String nameBookstore, int maxBookstoreCapacity) {
        this.maxBookstoreCapacity=maxBookstoreCapacity;
        this.nameBookstore=nameBookstore;
    }

    public void addProduct(Book newBook) {
//        int counter = 0;
//        for (Book book: BookList) {
//            counter += book.getCounter();
//        }

        if(BookList.size()>=maxBookstoreCapacity) {
            System.err.println("There is no more space for another book");
        }
        else {
            if(BookList.contains(newBook)) {
                newBook.getCounterinc();
                count.put(newBook, count.get(newBook)+1);
            }
            else {
                BookList.add(newBook);
                count.put(newBook, 1);
            }
        }
    }

    public void removeProduct(Book soldBook) {BookList.remove(soldBook);}
    public List<Book> getBookList() {return BookList;}
    public String getNameBookstore() {return nameBookstore;}

}
