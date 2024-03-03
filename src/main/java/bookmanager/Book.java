package bookmanager;

public class Book extends UnidentifiedBook {
    private int id;

    public Book(String name, int year) {
        super(name, year);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


