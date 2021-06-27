package temaOOP1;

public class Book {
    private String name;
    private int pages;
    private Album[] albums;
    private Novel[] novels;

    public Album[] getAlbums() {
        return albums;
    }

    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }

    public Novel[] getNovels() {
        return novels;
    }

    public void setNovels(Novel[] novels) {
        this.novels = novels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
