class Actor extends Person {
    private int height;

    public Actor(String name, String surname, Gender gender, int height) {
        super(name, surname, gender);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return super.toString() + " рост: " + height;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void createActor() {
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
            } else {
                System.out.println("Ошибка! Введите М или Ж.");
            }
        }
        System.out.println("Рост: ");
        String heightStr = Main.scanner.nextLine();
        int height = Integer.parseInt(heightStr);
        Main.actors.add(new Actor(name, surname, gender, height));
        System.out.println("Актёр создан");
    }

    public void assignActor() {
        if (Main.actors.isEmpty()) {
            System.out.println("Нет актёров!");
            return;
        }
        for (int i = 0; i < Main.actors.size(); i++) {
            System.out.println((i + 1) + ". " + Main.actors.get(i));
        }
        System.out.println("Выберите актёра: ");
        Actor actor = Main.actors.get(Integer.parseInt(Main.scanner.nextLine()) - 1);
        System.out.println("Количество спектаклей: ");
        int count = Integer.parseInt(Main.scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Название спектакля: ");
            String title = Main.scanner.nextLine();
            boolean found = false;
            for (Show show : Main.shows) {
                if (show.getTitle().equalsIgnoreCase(title)) {
                    show.addActor(actor);
                    found = true;
                }
            }
            if (!found) System.out.println("Спектакль не найден");
        }
    }

    public void removeActorFromShow() {
        if (Main.shows.isEmpty()) {
            System.out.println("Нет созданных спектаклей!");
            return;
        }
        System.out.println("Название спектакля: ");
        String title = Main.scanner.nextLine();
        Show targetShow = null;
        for (Show show : Main.shows) {
            if (show.getTitle().equalsIgnoreCase(title)) {
                targetShow = show;
                break;
            }
        }
        if (targetShow == null) {
            System.out.println("Спектакль не найден!");
            return;
        }
        if (targetShow.getListOfActors().isEmpty()) {
            System.out.println("В спектакле нет актёров!");
            return;
        }
        System.out.println("Актёры в спектакле:");
        for (int i = 0; i < targetShow.getListOfActors().size(); i++) {
            System.out.println((i + 1) + ". " + targetShow.getListOfActors().get(i));
        }
        System.out.println("Выберите номер актёра для удаления: ");
        int index = Integer.parseInt(Main.scanner.nextLine()) - 1;
        if (index < 0 || index >= targetShow.getListOfActors().size()) {
            System.out.println("Неверный номер актёра!");
            return;
        }
        Actor removed = targetShow.getListOfActors().remove(index);
        System.out.println("Актёр " + removed + " удалён из спектакля " + targetShow.getTitle());
    }
}
