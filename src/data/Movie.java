package data;

import java.time.ZonedDateTime;

public class Movie implements Comparable<Movie>{

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long oscarsCount; //Значение поля должно быть больше 0, Поле может быть null
    private Integer length; //Поле может быть null, Значение поля должно быть больше 0
    private MovieGenre genre; //Поле может быть null
    private MpaaRating mpaaRating; //Поле не может быть null
    private Person director; //Поле не может быть null
    public Movie() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) throws Exception {
        if (id <= 0) {
            throw new Exception("Значение id должно быть больше 0");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null) {
            throw new Exception("Поле name не может быть null");
        } else if (name.isEmpty()) {
            throw new Exception("Поле name должно быть заполнено");
        }
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) throws Exception {
        if (coordinates == null) {
            throw new Exception("Поле coordinates не может быть null");
        }
        this.coordinates = coordinates;
    }

    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) throws Exception {
        if (creationDate == null) {
            throw new Exception("Поле creationDate не может быть null");
        }
        this.creationDate = creationDate;
    }

    public long getOscarsCount() {
        return oscarsCount;
    }

    public void setOscarsCount(Long oscarsCount) throws Exception {
        if (oscarsCount <= 0) {
            throw new Exception("Поле oscarsCount должно быть больше нуля");
        }
        this.oscarsCount = oscarsCount;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) throws Exception {
        if (length <= 0) {
            throw new Exception("Поле length должно быть больше нуля");
        }
        this.length = length;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) throws Exception {
        this.genre = genre;
    }

    public MpaaRating getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(MpaaRating mpaaRating) throws Exception {
        if (mpaaRating == null) {
            throw new Exception("Поле mpaaRating не может быть null");
        }
        this.mpaaRating = mpaaRating;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) throws Exception {
        if (director == null) {
            throw new Exception("Поле director не может быть null");
        }
        this.director = director;
    }
    public Movie(String name, Coordinates coordinates, long oscarsCount,Integer length, MovieGenre genre, MpaaRating mpaaRating, Person director) {
        this.name=name;
        this.coordinates=coordinates;
        this.oscarsCount=oscarsCount;
        this.length=length;
        this.genre=genre;
        this.mpaaRating=mpaaRating;
        this.director=director;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", oscarsCount=" + oscarsCount +
                ", length=" + length +
                ", genre=" + genre +
                ", mpaaRating=" + mpaaRating +
                ", director=" + director +
                '}';
    }
    @Override
    public int compareTo(Movie o) {
        if (o == null) {
            return 1;
        }
        return Long.compare(this.getOscarsCount(), o.getOscarsCount());
    }


}
