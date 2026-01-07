class Director extends Person {
    private int numberOfShows;

    public Director(String name, String surname, Gender gender, int numberOfShows) {
        super(name, surname, gender);
        this.numberOfShows = numberOfShows;
    }

    public int getNumberOfShows() {
        return numberOfShows;
    }

    @Override
    public String toString() {
        return super.toString() + " (Поставленных спектаклей: " + numberOfShows + ")";
    }

    public void createDirector() {
        System.out.println("Имя: ");
        String name = Main.scanner.nextLine();
        System.out.println("Фамилия: ");
        String surname = Main.scanner.nextLine();
        Gender gender;
        while (true) {
            System.out.println("Пол (М/Ж): ");
            String g = Main.scanner.nextLine().trim().toUpperCase();
            if (g.equals("М")) {
                gender = Gender.MALE;
                break;
            } else if (g.equals("Ж")) {
                gender = Gender.FEMALE;
                break;
            } else System.out.println("Ошибка! Введите М или Ж.");
        }
        System.out.println("Количество спектаклей: ");
        String countStr = Main.scanner.nextLine();
        int count = Integer.parseInt(countStr);
        Main.directors.add(new Director(name, surname, gender, count));
        System.out.println("Режиссёр создан");
    }
}
