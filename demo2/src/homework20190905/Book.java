package homework20190905;

public class Book {
    private String name;
    private double value;         //书的价格
    private int bookID;       //书的自身ID

    static int id;        //总体书的序列ID
    static int total;      //书的总体

    public Book(){
        ++id;
        bookID=id;
        ++total;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public int getBookID() {
        return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public static void main(String[] args) {
        Book[] book=new Book[50];
        for(int i=0;i<book.length;i++){
            book[i]=new Book();
            book[i].setName("Book"+i);
            book[i].setValue(100+i);
            book[i].setBookID(book[i].getBookID());
            //System.out.println(book[i].getName());
            System.out.println(book[i].getBookID());
        }
    }
}
