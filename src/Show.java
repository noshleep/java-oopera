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
        return title + " (" + duration + " мин), режиссер: " + director;
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

    public boolean replaceActor(String surname, Actor newActor) {
        boolean found = false;
        for (int i = 0; i < listOfActors.size(); i++) {
            if (listOfActors.get(i).getSurname().equalsIgnoreCase(surname)) {
                listOfActors.set(i, newActor);
                found = true;
            }
        }
        return found;
    }
}


