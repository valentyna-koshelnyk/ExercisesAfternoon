package W9_Exercises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Book  {
    private String title;
    private String author;
    private int publicationYear;
    StringBuilder sb = new StringBuilder();
    private List<Book> bookList = new ArrayList<>();
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString(){
        return String.valueOf(sb.append(" | " + title).append(" | " + author).append(" | " + publicationYear));
    }

}
