//
// Created by Bob Zwolinski on 2019-04-05.
//

public class Book {

    public enum CoverType {
        HARDCOVER,
        SOFTCOVER
    };

    final static double PAGE_THICKNESS = 0.002;
    final static double HARD_COVER_THICKNESS = 0.25;
    final static double SOFT_COVER_THICKNESS = 0.004;

    private String title;
    private String author;
    private int edition;
    private int pages;
    private CoverType cover_type = CoverType.SOFTCOVER;

    Book(String title, String author) {
        // Store the title as lower case to simplify comparisons and command line directives.
        this.title = title.toLowerCase();
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getEdition() {
        return this.edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public CoverType getCoverType() {
        return this.cover_type;
    }

    public void setCoverType(CoverType cover_type) {
        this.cover_type = cover_type;
    }

    // Returns the thickness of the book.
    public double getThickness() {
        double pages_thickness = getPages() * PAGE_THICKNESS;
        double cover_thickness = 0.0;
        switch (getCoverType()) {
            case HARDCOVER:
                cover_thickness = 2 * HARD_COVER_THICKNESS;
                break;
            case SOFTCOVER:
                cover_thickness = 2 * SOFT_COVER_THICKNESS;
                break;
            default:
                cover_thickness = 2 * SOFT_COVER_THICKNESS;
        }
        return cover_thickness + pages_thickness;

    }

    // Implements == operator for use by std::find.
    public boolean equals(Book other) {
        return this.title == other.title && this.author == other.author;
    }

}
