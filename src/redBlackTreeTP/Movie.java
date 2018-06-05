package redBlackTreeTP;

public class Movie {

    private String name;
    private String category;
    private String director;
    private int year;
    private int minutes;

    public Movie(String name, String category, String director, int year, int minutes) {
        this.name = name;
        this.category = category;
        this.director = director;
        this.year = year;
        this.minutes = minutes;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                ", minutes=" + minutes +
                '}';
    }
}
