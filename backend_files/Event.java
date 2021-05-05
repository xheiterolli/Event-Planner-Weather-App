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

    public String get_title() {
        return title;
    }

    public String get_description() {
        return description;
    }

    public int get_date() {
        return date;
    }

    public int get_month() {
        return month;
    }

    public int get_year() {
        return year;
    }

    @Override
    public String toString() {
        return title + "\n" + description + "\n" +
                "Date: " + month + "/" + date + "/" + year + "\n-------------------------------------------\n";
    }
}
