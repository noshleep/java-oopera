class Ballet extends MusicalShow {
    private Choreographer choreographer;

    public Ballet(
            String title,
            int duration,
            Director director,
            MusicAuthor musicAuthor,
            String librettoText,
            Choreographer choreographer
    ) {
        super(title, duration, director, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }

    public Choreographer getChoreographer() {
        return choreographer;
    }

    public void createBallet() {
        System.out.println("Название: ");
        String title = Main.scanner.nextLine();
        for (Show show : Main.shows)
            if (show.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Балет уже существует");
                return;
            }
        if (Main.directors.isEmpty() || Main.musicAuthors.isEmpty() || Main.choreographers.isEmpty()) {
            System.out.println("Нет необходимых сотрудников!");
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
        for (int i = 0; i < Main.choreographers.size(); i++) {
            System.out.println((i + 1) + ". " + Main.choreographers.get(i));
        }
        System.out.println("Выберите хореографа: ");
        Choreographer ch = Main.choreographers.get(Integer.parseInt(Main.scanner.nextLine()) - 1);
        System.out.println("Длительность: ");
        int duration = Integer.parseInt(Main.scanner.nextLine());
        System.out.println("Либретто: ");
        String libretto = Main.scanner.nextLine();
        Main.shows.add(new Ballet(title, duration, director, author, libretto, ch));
        System.out.println("Балет создан");
    }

    @Override
    public String toString() {
        return super.toString() + ", хореограф: " + choreographer;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Хореограф: " + choreographer);
    }
}


