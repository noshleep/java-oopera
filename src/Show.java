import java.util.ArrayList;

class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected ArrayList<Actor> listOfActors = new ArrayList<>();

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

    public ArrayList<Actor> getListOfActors() {
        return listOfActors;
    }

    @Override
    public String toString() {
        return title + " (" + duration + " мин), режиссер: " + director;
    }

    public void printDirector() {
        System.out.println("Режиссер: " + director);
    }

    public void printListOfActors() {
        if (listOfActors.isEmpty()) {
            System.out.println("Актеры отсутствуют");
        } else {
            System.out.println("Актеры: ");
            for (Actor actor : listOfActors) {
                System.out.println(" - " + actor);
            }
        }
    }

    public void showInfo() {
        System.out.println("Название: " + getTitle());
        System.out.println("Длительность: " + duration + " мин");
        printDirector();
        printListOfActors();
    }
}


