import java.util.ArrayList;

class Show {
    protected String title;
    protected int duration;
    protected Director director;
    private final ArrayList<Actor> listOfActors = new ArrayList<>();

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Director getDirector() {
        return director;
    }

    public ArrayList<Actor> getListOfActors() {
        return listOfActors;
    }

    @Override
    public String toString() {
        return title + " (" + duration + " мин), режиссёр: " + director.name + " " + director.surname;
    }

    public void addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            System.out.println("Актер уже добавлен");
        } else {
            listOfActors.add(actor);
            System.out.println("Актер добавлен");
        }
    }

    public void createShow() {
        System.out.println("Название: ");
        String title = Main.scanner.nextLine();
        for (Show show : Main.shows)
            if (show.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Спектакль уже существует");
                return;
            }
        if (Main.directors.isEmpty()) {
            System.out.println("Нет режиссёров!");
            return;
        }
        for (int i = 0; i < Main.directors.size(); i++) {
            System.out.println((i + 1) + ". " + Main.directors.get(i));
        }
        System.out.println("Выберите режиссёра: ");
        String indexStr = Main.scanner.nextLine();
        Director director = Main.directors.get(Integer.parseInt(indexStr) - 1);
        System.out.println("Длительность: ");
        String durStr = Main.scanner.nextLine();
        int duration = Integer.parseInt(durStr);
        Main.shows.add(new Show(title, duration, director));
        System.out.println("Спектакль создан");
    }

    public void showInfo() {
        System.out.println("Название: " + getTitle());
        System.out.println("Длительность: " + duration + " мин");
        System.out.println("Режиссер: " + director);
        if (listOfActors.isEmpty()) {
            System.out.println("Актеры отсутствуют");
        } else {
            System.out.println("Актеры: ");
            for (Actor actor : listOfActors) {
                System.out.println(" - " + actor);
            }
        }
    }

    public void replaceActor(String surname, Actor newActor) {
        boolean found = false;
        for (int i = 0; i < listOfActors.size(); i++) {
            Actor currentActor = listOfActors.get(i);
            if (currentActor.getSurname().equalsIgnoreCase(surname)) {
                listOfActors.set(i, newActor);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Актера с такой фамилией не существует");
        } else {
            System.out.println("Актеры с такой фамилией '" + surname + "' заменены на " + newActor);
        }
    }
}


