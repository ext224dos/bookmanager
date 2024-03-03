package bookmanager;

public class UnidentifiedBook {
    private final String name;
    private final int year;

    public UnidentifiedBook(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public UnidentifiedBook(UnidentifiedBook unidentifiedBook) {
        this(unidentifiedBook.getName(), unidentifiedBook.getYear());
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

}
