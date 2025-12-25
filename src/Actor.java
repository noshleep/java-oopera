class Actor extends Person {
    int height;

    Actor(String name, String surname, Gender gender, int height) {
        super(name, surname, gender);
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + " рост: " + height;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Actor)) {
            return false;
        }
        Actor actor = (Actor) obj;
        return actor.name.equals(this.name) && actor.surname.equals(this.surname) && actor.height == this.height;
    }
}
