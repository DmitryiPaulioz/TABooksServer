package com.epam.httpserver.book;

/**
 * Created by Dmitryi_Paulioz on 4/11/2017.
 */
public class Book {
    private String title;
    private String authorName;
    private int pageCount;
    private int yearOfEdition;
    private int id;

    public Book(String title, String authorName, int pageCount, int yearOfEdition, int id) {
        this.title = title;
        this.authorName = authorName;
        this.pageCount = pageCount;
        this.yearOfEdition = yearOfEdition;
        this.id = id;
    }

    public Book(){
        title = "Wizard of Earthsea";
        authorName = "Ursula K. Le Guin";
        pageCount = 205;
        yearOfEdition = 1968;
        id = 1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getYearOfEdition() {
        return yearOfEdition;
    }

    public void setYearOfEdition(int yearOfEdition) {
        this.yearOfEdition = yearOfEdition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "\nTitle: " + title +
                "\nAuthor: " + authorName +
                "\nPage count: " + pageCount +
                "\nYear of edition: " + yearOfEdition +
                "\n";

    }
}
