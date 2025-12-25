class Person {
    String name, surname;
    Gender gender;

    Person(String name, String surname, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + gender + ")";
    }
}

