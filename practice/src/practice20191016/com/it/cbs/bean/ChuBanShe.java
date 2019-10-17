/**
 * <一句话功能简述>
 * <存放出版社信息>
 *
 * @author sunmeng
 * @create 2019/10/16   10:43
 */
package practice20191016.com.it.cbs.bean;

public class ChuBanShe {
	private int book_no;          //总编号
	private String type_no;        //分类号
	private String book_name;       //书名
	private String author;          //作者
	private String publisher;         //出版单位
	private double price;              //单价

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public String getType_no() {
		return type_no;
	}

	public void setType_no(String type_no) {
		this.type_no = type_no;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ChuBanShe{" +
				"book_no=" + book_no +
				", type_no='" + type_no + '\'' +
				", book_name='" + book_name + '\'' +
				", author='" + author + '\'' +
				", publisher='" + publisher + '\'' +
				", price=" + price +
				'}';
	}
}
