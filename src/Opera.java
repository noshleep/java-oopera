class Opera extends MusicalShow {
    private int choirSize;

    public Opera(String title, int duration, Director director, MusicAuthor musicAuthor, String librettoText, int choirSize) {
        super(title, duration, director, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }

    public int getChoirSize() {
        return choirSize;
    }

    static void createOpera() {
        System.out.println("Название: ");
        String title = Main.scanner.nextLine();
        for (Show show : Main.shows)
            if (show.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Опера уже существует");
                return;
            }
        if (Main.directors.isEmpty() || Main.musicAuthors.isEmpty()) {
            System.out.println("Нет режиссёров или музыкальных авторов!");
            return;
        }
        for (int i = 0; i < Main.directors.size(); i++) {
            System.out.println((i + 1) + ". " + Main.directors.get(i));
        }
        System.out.println("Выберите режиссёра: ");
        Director director = Main.directors.get(Integer.parseInt(Main.scanner.nextLine()) - 1);
        for (int i = 0; i < Main.musicAuthors.size(); i++) {
            System.out.println((i + 1) + ". " + Main.musicAuthors.get(i));
        }
        System.out.println("Выберите музыкального автора: ");
        MusicAuthor author = Main.musicAuthors.get(Integer.parseInt(Main.scanner.nextLine()) - 1);
        System.out.println("Длительность: ");
        int duration = Integer.parseInt(Main.scanner.nextLine());
        System.out.println("Либретто: ");
        String libretto = Main.scanner.nextLine();
        System.out.println("Размер хора: ");
        int choir = Integer.parseInt(Main.scanner.nextLine());
        Main.shows.add(new Opera(title, duration, director, author, libretto, choir));
        System.out.println("Опера создана");
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


