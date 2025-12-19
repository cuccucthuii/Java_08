package HomeWork.K2;

public class Books {
    String title;
    String author;
    double price;

    public Books(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" + "title=" + title + ", author=" + author + ", price=" + price + '}';
    }

}
