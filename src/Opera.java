class Opera extends MusicalShow {
    private int choirSize;

    public Opera(String title, int duration, Director director, MusicAuthor musicAuthor, String librettoText, int choirSize) {
        super(title, duration, director, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }

    public int getChoirSize() {
        return choirSize;
    }

    @Override
    public String toString() {
        return super.toString() + ", хор: " + choirSize + " человек";
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Размер хора: " + choirSize + " человек");
    }
}


