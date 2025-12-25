import java.util.ArrayList;

class Show {
    String title;
    int duration;
    Director director;
    ArrayList<Actor> listOfActors = new ArrayList<>();

    Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
    }

    void addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            System.out.println("Актёр уже добавлен");
        } else {
            listOfActors.add(actor);
            System.out.println("Актёр добавлен");
        }
    }

    String getTitle() {
        return title;
    }

    public ArrayList<Actor> getListOfActors() {
        return listOfActors;
    }

    @Override
    public String toString() {
        return title + " (" + duration + " мин), режиссёр: " + director.name + " " + director.surname;
    }
}


