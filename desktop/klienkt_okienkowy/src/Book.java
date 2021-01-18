public class Book implements Comparable<Book>{

    public String title;
    public String author;
    public BookCondition condition;
    public double price;
    public int PublishYear;
    public boolean reserved = false;
    private int counter = 1;

    //konstruktor
    public Book(String title, String author, BookCondition condition, double price, int PublishYear) {
        this.title = title;
        this.author = author;
        this.PublishYear = PublishYear;
        this.condition = condition;
        this.price = price;
        //  this.counter=counter;
    }

    public String getAuthor() {return author;}
    public String getTitle() {return title;}
    public int getPublishYear(){return PublishYear;}
    public double getPrice() {return price;}
    public BookCondition getCondition() {return condition;}
    public void getCounterinc(){this.counter++;}

    @Override
    public int compareTo(Book book) {
        // compareToIgnoCase - ignoruje małe i duże litery
        return this.getAuthor().compareToIgnoreCase(book.getAuthor());
    }

    public String getTip(){
        String reservation;
        if(reserved){
            reservation= "Reserved";
        }else reservation= "Not reserved";
        String tip = null;
        tip = "Title: " + title + ", author: " + author + ", condition: " + condition + ", reservation: " + reservation;
        return tip;
    }

    public void setReserved(boolean reserved){this.reserved=reserved;}

}
