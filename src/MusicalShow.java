class MusicalShow extends Show {
    private MusicAuthor musicAuthor;
    private String librettoText;

    public MusicalShow(String title, int duration, Director director, MusicAuthor musicAuthor, String librettoText) {
        super(title, duration, director);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public MusicAuthor getMusicAuthor() {
        return musicAuthor;
    }

    public String getLibrettoText() {
        return librettoText;
    }

    public void printLibretto() {
        System.out.println("Либретто " + title + ":");
        System.out.println(librettoText);
    }

    @Override
    public String toString() {
        return super.toString() + ", музыкальный автор: " + musicAuthor;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Музыкальный автор: " + musicAuthor);
        System.out.println("Либретто: ");
        System.out.println(librettoText);
    }
}


