public class Event {
    private String title;
    private String description;
    private int date;
    private int month;
    private int year;

    public Event() {

    }

    public Event(String title, String description, int month, int date, int year) {
        this.title = title;
        this.description = description;
        this.month = month;
        this.date = date;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + "\n" + description + "\n" +
                "Date: " + month + "/" + date + "/" + year + "\n-------------------------------------------\n";
    }
}
