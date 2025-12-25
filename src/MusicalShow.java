class MusicalShow extends Show {
    MusicAuthor musicAuthor;
    String librettoText;

    MusicalShow(String title, int duration, Director director, MusicAuthor musicAuthor, String librettoText) {
        super(title, duration, director);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    void printLibretto() {
        System.out.println("Либретто " + title + ":");
        System.out.println(librettoText);
    }
}


