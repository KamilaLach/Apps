import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;


public class App extends JFrame{
    public App(){
        super("Welcome in the Bookstore!");

        int width= Toolkit.getDefaultToolkit().getScreenSize().width;
        int height= Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(900,800);
        int w= this.getSize().height;
        int sz=this.getSize().width;
        this.setLocation((width-sz)/2, (height-w)/2);

        prepareDate();
        initComponents();
        listener();

        this.setDefaultCloseOperation(3);
    }

    JPanel BookPanel = new JPanel();
    JPanel BookPanelBox = new JPanel();
    JLabel TitleSearch = new JLabel("Title: ");
    JTextField TypeTitleSearch = new JTextField("", 12);
    JLabel AuthorSeach = new JLabel("Author: ");
    JTextField TypeAuthorSeach = new JTextField("", 12);
    JButton search = new JButton("search");

    JPanel MainPanel = new JPanel();
    JPanel mainpanel = new JPanel();

    String[] CategoryName;
    JComboBox ChooseCategory;
    JComboBox sorting;

    String columns[] = {"TITLE", "AUTHOR", "CONDITION", "PRICE", "PUBLISH YEAR"};
    JTable BookTable = new JTable();
    JScrollPane Scroll = new JScrollPane(BookTable);
    TableModel TableBookAuthor;

    JButton buy = new JButton("BUY");
    JButton reserve = new JButton("RESERVE");
    JButton unbook = new JButton("UNBOOK");
    JPanel buttons = new JPanel();
    JButton refresh = new JButton("REFRESH");

    List<Bookstore> BookCategoryO;
    List<Bookstore> BookCategoryF;
    List<Bookstore> BookCategoryB;

    public void setFonttoButton(JButton b) {
       b.setFont(new Font("Courier New", Font.BOLD, 16));
       b.setBackground(Color.WHITE);
       b.setForeground(Color.BLACK);
   }
    public void setFonttoJTextField(JTextField b) {
        b.setFont(new Font("Courier New", Font.BOLD, 16));
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLUE);
    }
    public void setFonttoComboBox(JComboBox b){
        b.setToolTipText("choose");
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLUE);
    }

     public void initComponents(){
         BookPanel.setBackground(Color.GRAY);
         MainPanel.setBackground(Color.GRAY);
         buttons.setBackground(Color.GRAY);
         BookPanelBox.setBackground(Color.GRAY);
         mainpanel.setBackground(Color.BLACK);
         setFonttoButton(buy);
         setFonttoButton(reserve);
         setFonttoButton(unbook);
         setFonttoButton(search);
         setFonttoButton(refresh);
         setFonttoJTextField(TypeTitleSearch);
         setFonttoJTextField(TypeAuthorSeach);

         BookPanel.add(TitleSearch);
         BookPanel.add(TypeTitleSearch);
         BookPanel.add(AuthorSeach);
         BookPanel.add(TypeAuthorSeach);
         BookPanel.add(search);

         search.setToolTipText("Find this book");
         ChooseCategory= new JComboBox(CategoryName);
         sorting = new JComboBox(columns);

         setFonttoComboBox(ChooseCategory);
         setFonttoComboBox(sorting);

         BookPanelBox.add(ChooseCategory);
         BookPanelBox.add(sorting);

         MainPanel.add(Scroll);

         buttons.add(buy);
         buttons.add(reserve);
         buttons.add(unbook);
         buttons.add(refresh);

         mainpanel.add(BookPanel);
         mainpanel.add(BookPanelBox);
         mainpanel.add(MainPanel);
         mainpanel.add(buttons);

        this.getContentPane().add(mainpanel);
    }

     public void prepareDate(){
         List<Bookstore> BookCategory = new ArrayList<>();

//CATEGORIES
         BookCategory.add(new Bookstore("Adventure", 100));
         BookCategory.add(new Bookstore("Fantasy", 100));
         BookCategory.add(new Bookstore("Historical", 100));
         BookCategory.add(new Bookstore("Horror", 100));
         BookCategory.add(new Bookstore("Novel", 100));
         BookCategory.add(new Bookstore("Romance", 100));
         BookCategory.add(new Bookstore("Sci-Fi", 100));


//LIST OF BOOKS
         Book book1 = new Book("Anna Karenina", "Leo Tolstoy", BookCondition.USED, 10, 1995);
         Book book2 = new Book("Anna Karenina", "Leo Tolstoy", BookCondition.NEW, 20, 2005);
         Book book3 = new Book("Anna Karenina", "Leo Tolstoy", BookCondition.NEW, 20, 2005);
         Book book4 = new Book("Anna Karenina", "Leo Tolstoy", BookCondition.NEW, 20, 2005);
         Book book5 = new Book("Anna Karenina", "Leo Tolstoy", BookCondition.NEW, 20, 2005);
         Book book6 = new Book("Don Quixote", "Miguel de Cervantes", BookCondition.USED, 8, 1987);
         Book book7 = new Book("Don Quixote", "Miguel de Cervantes", BookCondition.NEW, 19, 2009);
         Book book8 = new Book("Don Quixote", "Miguel de Cervantes", BookCondition.NEW, 19, 2009);
         Book book9 = new Book("Don Quixote", "Miguel de Cervantes", BookCondition.NEW, 19, 2009);
         Book book10 = new Book("Solaris", "Stanislaw Lem", BookCondition.NEW, 23, 2019);
         Book book11 = new Book("Solaris", "Stanislaw Lem", BookCondition.NEW, 23, 2019);
         Book book12 = new Book("Solaris", "Stanislaw Lem", BookCondition.NEW, 23, 2019);
         Book book13 = new Book("Solaris", "Stanislaw Lem", BookCondition.NEW, 23, 2019);
         Book book14 = new Book("Solaris", "Stanislaw Lem", BookCondition.USED, 15, 2019);
         Book book15 = new Book("The Hobbit, or There and Back Again", "J. R. R. Tolkien", BookCondition.USED, 13, 1994);
         Book book16 = new Book("The Hobbit, or There and Back Again", "J. R. R. Tolkien", BookCondition.USED, 13, 1994);
         Book book17 = new Book("The Hobbit, or There and Back Again", "J. R. R. Tolkien", BookCondition.NEW, 25, 2017);
         Book book18 = new Book("The Hobbit, or There and Back Again", "J. R. R. Tolkien", BookCondition.NEW, 25, 2017);
         Book book19 = new Book("The Hobbit, or There and Back Again", "J. R. R. Tolkien", BookCondition.NEW, 25, 2017);
         Book book20 = new Book("The Three Musketeers", "Alexandre Dumas", BookCondition.USED, 7, 1985);
         Book book21 = new Book("The Three Musketeers", "Alexandre Dumas", BookCondition.USED, 5, 1985);
         Book book22 = new Book("The Three Musketeers", "Alexandre Dumas", BookCondition.USED, 5, 1985);
         Book book23 = new Book("The Three Musketeers", "Alexandre Dumas", BookCondition.USED, 6, 1985);
         Book book24 = new Book("The Three Musketeers", "Alexandre Dumas", BookCondition.NEW, 19, 2018);
         Book book25 = new Book("The Three Musketeers", "Alexandre Dumas", BookCondition.NEW, 19, 2018);
         Book book26 = new Book("Treasure Island", "Robert Louis Stevenson", BookCondition.NEW, 20, 2013);
         Book book27 = new Book("Treasure Island", "Robert Louis Stevenson", BookCondition.NEW, 20, 2013);
         Book book28 = new Book("Treasure Island", "Robert Louis Stevenson", BookCondition.NEW, 20, 2013);
         Book book29 = new Book("Treasure Island", "Robert Louis Stevenson", BookCondition.USED, 10, 1999);
         Book book30 = new Book("Treasure Island", "Robert Louis Stevenson", BookCondition.USED, 4, 1999);
         Book book31 = new Book("War and Peace", "Leo Tolstoy", BookCondition.NEW, 27, 2016);
         Book book32 = new Book("War and Peace", "Leo Tolstoy", BookCondition.NEW, 27, 2016);
         Book book33 = new Book("War and Peace", "Leo Tolstoy", BookCondition.NEW, 27, 2016);
         Book book34 = new Book("War and Peace", "Leo Tolstoy", BookCondition.NEW, 27, 2016);
         Book book35 = new Book("War and Peace", "Leo Tolstoy", BookCondition.NEW, 27, 2016);
         Book book36 = new Book("War and Peace", "Leo Tolstoy", BookCondition.NEW, 27, 2016);

//Category ADVENTURE
         BookCategory.get(0).addProduct(book6);
         BookCategory.get(0).addProduct(book7);
         BookCategory.get(0).addProduct(book8);
         BookCategory.get(0).addProduct(book9);
         BookCategory.get(0).addProduct(book15);
         BookCategory.get(0).addProduct(book16);
         BookCategory.get(0).addProduct(book17);
         BookCategory.get(0).addProduct(book18);
         BookCategory.get(0).addProduct(book19);
         BookCategory.get(0).addProduct(book20);
         BookCategory.get(0).addProduct(book21);
         BookCategory.get(0).addProduct(book22);
         BookCategory.get(0).addProduct(book23);
         BookCategory.get(0).addProduct(book24);
         BookCategory.get(0).addProduct(book25);
         BookCategory.get(0).addProduct(book26);
         BookCategory.get(0).addProduct(book27);
         BookCategory.get(0).addProduct(book28);
         BookCategory.get(0).addProduct(book29);
         BookCategory.get(0).addProduct(book30);

//Category FANTASY
         BookCategory.get(1).addProduct(book15);
         BookCategory.get(1).addProduct(book16);
         BookCategory.get(1).addProduct(book17);
         BookCategory.get(1).addProduct(book18);
         BookCategory.get(1).addProduct(book19);

//Category HISTORICAL
         BookCategory.get(2).addProduct(book31);
         BookCategory.get(2).addProduct(book32);
         BookCategory.get(2).addProduct(book33);
         BookCategory.get(2).addProduct(book34);
         BookCategory.get(2).addProduct(book35);
         BookCategory.get(2).addProduct(book36);

//Category HORROR


//Category NOVEL
         BookCategory.get(4).addProduct(book1);
         BookCategory.get(4).addProduct(book2);
         BookCategory.get(4).addProduct(book3);
         BookCategory.get(4).addProduct(book4);
         BookCategory.get(4).addProduct(book5);
         BookCategory.get(4).addProduct(book20);
         BookCategory.get(4).addProduct(book21);
         BookCategory.get(4).addProduct(book22);
         BookCategory.get(4).addProduct(book23);
         BookCategory.get(4).addProduct(book24);
         BookCategory.get(4).addProduct(book25);
         BookCategory.get(4).addProduct(book26);
         BookCategory.get(4).addProduct(book27);
         BookCategory.get(4).addProduct(book28);
         BookCategory.get(4).addProduct(book29);
         BookCategory.get(4).addProduct(book30);
         BookCategory.get(4).addProduct(book31);
         BookCategory.get(4).addProduct(book32);
         BookCategory.get(4).addProduct(book33);
         BookCategory.get(4).addProduct(book34);
         BookCategory.get(4).addProduct(book35);
         BookCategory.get(4).addProduct(book36);

//Category ROMANCE
         BookCategory.get(5).addProduct(book1);
         BookCategory.get(5).addProduct(book2);
         BookCategory.get(5).addProduct(book3);
         BookCategory.get(5).addProduct(book4);
         BookCategory.get(5).addProduct(book5);
         BookCategory.get(5).addProduct(book31);
         BookCategory.get(5).addProduct(book32);
         BookCategory.get(5).addProduct(book33);
         BookCategory.get(5).addProduct(book34);
         BookCategory.get(5).addProduct(book35);
         BookCategory.get(5).addProduct(book36);

//Category SCI-FI
         BookCategory.get(6).addProduct(book10);
         BookCategory.get(6).addProduct(book11);
         BookCategory.get(6).addProduct(book12);
         BookCategory.get(6).addProduct(book13);
         BookCategory.get(6).addProduct(book14);


         BookCategoryO = BookCategory;
         BookCategoryF = BookCategoryO;
         BookCategoryB = BookCategoryO;

         List<Book> bookList = getBookList(BookCategory);

         TableBookAuthor = new AbstractTableModel() {
             public String getColumnName(int i){return columns[i];}
             @Override
             public int getRowCount() {return bookList.size();}
             @Override
             public int getColumnCount() {return columns.length;}

             @Override
             public Object getValueAt(int rowIndex, int columnIndex) {
                 if(columnIndex==0){
                     return bookList.get(rowIndex).getTitle();
                 }else if(columnIndex==1){
                     return bookList.get(rowIndex).getAuthor();
                 }else if(columnIndex==2){
                     return bookList.get(rowIndex).getCondition();
                 }else if (columnIndex==3){
                     return bookList.get(rowIndex).getPrice();
                 }else if(columnIndex==4){
                     return bookList.get(rowIndex).getPublishYear();
                 }
                 return "error";
             }
         };

         BookTable = new JTable(TableBookAuthor);
         Scroll.getViewport().add(BookTable);//= new JScrollPane(BookTable);

         Scroll= new JScrollPane(BookTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         Scroll.setPreferredSize(new Dimension(800,650));

         Set<String> dj = new HashSet<>();
         for(Bookstore carShowroom: BookCategoryO){
             dj.add(carShowroom.getNameBookstore());
         }

         int i=0;
         CategoryName = new String[dj.size()];
         for(String catName: dj){
             CategoryName[i] = catName;
             i++;
         }


         BookTable = new JTable(TableBookAuthor){
             public String getToolTipText(MouseEvent e) {
                 java.awt.Point p = e.getPoint();
                 int row = rowAtPoint(p);

                 List<Bookstore> BookCategory = BookCategoryO;
                 List<Book> booklist = getBookList(BookCategory);
                 Book tip = booklist.get(row);

                 return tip.getTip();
             }
         };
         Scroll.getViewport().add(BookTable);
     }

     public void listener(){
         search.setActionCommand("Search");
         search.addActionListener(new Events());

         ChooseCategory.setActionCommand("Category Choose");
         ChooseCategory.addActionListener(new Events());

         sorting.setActionCommand("Sorting");
         sorting.addActionListener(new Events());

         buy.setActionCommand("Buy");
         buy.addActionListener(new Events());

         reserve.setActionCommand("Reservation");
         reserve.addActionListener(new Events());

         unbook.setActionCommand("Unbook");
         unbook.addActionListener(new Events());

         refresh.setActionCommand("Refresh");
         refresh.addActionListener(new Events());
     }


     public class Events implements ActionListener{
         @Override
         public void actionPerformed(ActionEvent e) {
             String command = e.getActionCommand();
             int row = BookTable.getSelectedRow();

            switch (command) {
                case "Search": {
                    String title = TypeTitleSearch.getText();
                    String author = TypeAuthorSeach.getText();

                    List<Book> BookList = new ArrayList<>();
                    List<Bookstore> BookCategory = BookCategoryO;

                    for (Bookstore categories : BookCategory) {
                        for (Book books : categories.getBookList()) {
                            if (books.getAuthor().equals(author) && title.equals("")) {
                                BookList.add(books);
                            } else if (author.equals("") && books.getTitle().equals(title)) {
                                BookList.add(books);
                            } else if (books.getTitle().equals(title) && books.getAuthor().equals(author)) {
                                BookList.add(books);
                            }
                        }
                    }
                    if (BookList.size() == 0) {
                        JOptionPane.showMessageDialog(new JFrame(), "There is no such book in this bookstore", "MESSAGE", JOptionPane.ERROR_MESSAGE);
                    }

                    upDate(BookList);
                    break;
                }
                case "Category Choose": {
                    String bookName = (String) ChooseCategory.getSelectedItem();
                    BookCategoryO = BookCategoryB;
                    List<Bookstore> listBooks = new ArrayList<>();
                    for (Bookstore categories : BookCategoryO) {
                        if (categories.getNameBookstore().equals(bookName)) {
                            listBooks.add(categories);
                        }
                    }
                    List<Book> bList = getBookList(listBooks);
                    BookCategoryO = listBooks;
                    upDate(bList);
                    break;

                }
                case "Refresh":{
                    BookCategoryO = BookCategoryB;
                    BookCategoryF = BookCategoryB;
                    List<Book> BookList = getBookList(BookCategoryO);
                    upDate(BookList);
                    break;
                }
                case "Sorting": {
                    String sort = (String) sorting.getSelectedItem();
                    List<Bookstore> BookCategory = BookCategoryO;
                    List<Book> BookList = getBookList(BookCategory);

                    // assert sort != null;
                    switch (sort) {
                        case "TITLE":
                            BookList.sort(Comparator.comparing(Book::getTitle));
                            break;
                        case "AUTHOR":
                            BookList.sort(Comparator.comparing(Book::getAuthor));
                            break;
                        case "CONDITION":
                            BookList.sort(Comparator.comparing(Book::getCondition));
                            break;
                        case "PRICE":
                            BookList.sort(Comparator.comparingDouble(Book::getPrice));
                            break;
                        case "PUBLISH YEAR":
                            BookList.sort(Comparator.comparing(Book::getPublishYear));
                            break;
                        default:
                            break;
                    }
                    upDate(BookList);
                    break;
                }
                case "Buy": {
                    List<Bookstore> BookCategory = BookCategoryO;
                    List<Book> BookList = getBookList(BookCategory);
                    Book book = BookList.get(row);
                    for (Bookstore b : BookCategory) {
                        b.removeProduct(book);
                    }
                    BookCategoryO = BookCategory;
                    BookList = getBookList(BookCategory);
                    upDate(BookList);
                    JOptionPane.showMessageDialog(new JFrame(), "The purchase will be processed soon", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                case "Reservation": {
                    List<Bookstore> BookCategory = BookCategoryO;
                    List<Book> BookList = getBookList(BookCategory);
                    Book book = BookList.get(row);
                    book.setReserved(true);
                    BookCategoryO = BookCategory;
                    BookList = getBookList(BookCategory);
                    upDate(BookList);
                    JOptionPane.showMessageDialog(new JFrame(), "Book is reserved now", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                case "Unbook": {
                    List<Bookstore> BookCategory = BookCategoryO;
                    List<Book> BookList = getBookList(BookCategory);
                    Book book = BookList.get(row);
                    book.setReserved(false);
                    BookCategoryO = BookCategory;
                    BookList = getBookList(BookCategory);
                    upDate(BookList);
                    JOptionPane.showMessageDialog(new JFrame(), "Book is not reserved from now on", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
         }

     }

    public static void main(String[] args){
          new App().setVisible(true);
    }

    public void upDate(List<Book> BookList){
        TableBookAuthor = new AbstractTableModel() {
             public String getColumnName(int i){return columns[i];}
             @Override
             public int getRowCount() {
                 return BookList.size();
             }
             @Override
             public int getColumnCount() {
                 return columns.length;
             }

             @Override
             public Object getValueAt(int rowIndex, int columnIndex) {
                 if(columnIndex==0){
                     return BookList.get(rowIndex).getTitle();
                 }else if(columnIndex==1){
                     return BookList.get(rowIndex).getAuthor();
                 }else if(columnIndex==2){
                     return BookList.get(rowIndex).getCondition();
                 }else if (columnIndex==3){
                     return BookList.get(rowIndex).getPrice();
                 }else if(columnIndex==4){
                     return BookList.get(rowIndex).getPublishYear();
                 }
                 return "error";
             }
         };

        BookTable = new JTable(TableBookAuthor){
            public String getToolTipText(MouseEvent e ){
                java.awt.Point p = e.getPoint();
                int row = rowAtPoint(p);

                List<Bookstore> BookCategory= BookCategoryO;
                List<Book> BookList = getBookList(BookCategory);
                Book bo = BookList.get(row);

                return bo.getTip();
            }
        };
        Scroll.getViewport().add(BookTable);
    }

    List<Book> getBookList(List<Bookstore> BookCategory){
         List<Book> BookList= new ArrayList<>();
         for(Bookstore categories: BookCategory){
             BookList.addAll(categories.getBookList());
         }
         return BookList;
    }
}
