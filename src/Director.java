class Director extends Person {
    int numberOfShows;

    Director(String name, String surname, Gender gender, int numberOfShows) {
        super(name, surname, gender);
        this.numberOfShows = numberOfShows;
    }

    @Override
    public String toString() {
        return super.toString() + " (Поставленных спектаклей: " + numberOfShows + ")";
    }
}
