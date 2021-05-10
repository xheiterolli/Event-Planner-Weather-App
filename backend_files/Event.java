public class Event {
    private String title;
    private String description;
    private String date;
    private String month;
    private String year;

    public Event() {

    }

    public Event(String title, String description, String month, String date, String year) {
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

    public String get_date() {
        return date;
    }

    public String get_month() {
        return month;
    }

    public String get_year() {
        return year;
    }

    @Override
    public String toString() {
        return title + "\n" + description + "\n" +
                "Date: " + month + "/" + date + "/" + year + "\n-------------------------------------------\n";
    }
}
