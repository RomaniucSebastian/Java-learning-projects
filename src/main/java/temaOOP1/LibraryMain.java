package temaOOP1;

import org.apache.commons.lang3.ArrayUtils;

public class LibraryMain {
    public static void main(String[] args) {

        Library library1 = new Library();
        library1.setName("Carturesti");
        library1.setAdress("Str. Libertatii");
        library1.setBooks(createBooks());

        System.out.println("lista de carti este: ");
        listBooks(library1.getBooks());
    }

    private static void listBooks(Book[] book) {
        System.out.println("acestea sunt cartile: ");
        for (Book books : book) {
            listAlbums(books.getAlbums());
            listNovels(books.getNovels());
        }
    }

    private static void listNovels(Novel[] novel) {
        for (Novel novels : novel) {
            System.out.println("Novel: " + novels.getName());
        }
    }

    private static void listAlbums(Album[] album) {
        for (Album albums : album) {
            System.out.println("Album: " + albums.getName());
        }
    }

    private static Book[] createBooks() {
        Book book2 = new Book();
        book2.setNovels(createNovels());
        book2.setAlbums(createAlbum());

        return new Book[]{book2};
    }

    private static Album[] createAlbum() {
        Album album1 = new Album();
        album1.setName("Culture");
        album1.setPages(55);
        album1.setPaperquality("good");

        Album album2 = new Album();
        album2.setName("cooking");
        album2.setPages(49);
        album2.setPaperquality("mediu");

        Album album3 = new Album();
        album3.setName("Finance");
        album3.setPages(45);
        album3.setPaperquality("good");

        Album album4 = new Album();
        album4.setName("Science");
        album4.setPages(75);
        album4.setPaperquality("best");

        Album album5 = new Album();
        album5.setName("History");
        album5.setPages(65);
        album5.setPaperquality("bad");

        Album[] albumList = new Album[]{album1, album2, album3, album4};


        return albumList;
    }

    private static Album[] addAlbum(Album album5, Album[] albumList) {
        albumList = ArrayUtils.add(albumList, album5);
        return albumList;
    }

    private static Album[] removeAlbum(Album[] albumList) {
        albumList = ArrayUtils.remove(albumList, albumList.length - 1);
        return albumList;
    }

    public static Novel[] createNovels() {
        Novel novel1 = new Novel();
        novel1.setName("Secrest's of France");
        novel1.setPages(25);
        novel1.setType("Mystery");

        Novel novel2 = new Novel();
        novel2.setName(" Kings and beggers");
        novel2.setPages(35);
        novel2.setType("History");

        Novel novel3 = new Novel();
        novel3.setName("Aliens");
        novel3.setPages(15);
        novel3.setType("SF");

        Novel novel4 = new Novel();
        novel4.setName("Unsolved crimes");
        novel4.setPages(32);
        novel4.setType("Mystery");

        Novel novel5 = new Novel();
        novel5.setName("Space travel");
        novel5.setPages(66);
        novel5.setType("SF");

        Novel[] novelList = new Novel[]{novel1, novel2, novel3, novel4};


        return novelList;
    }

    private static Novel[] addNovels(Novel novel5, Novel[] novelList) {
        novelList = ArrayUtils.add(novelList, novel5);
        return novelList;
    }

    private static Novel[] removeNovel(Novel[] novelList) {
        novelList = ArrayUtils.remove(novelList, novelList.length - 1);
        return novelList;
    }
}
