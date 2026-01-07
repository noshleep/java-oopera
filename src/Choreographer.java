class Choreographer extends Person {
    public Choreographer(String name, String surname, Gender gender) {
        super(name, surname, gender);
    }

    public void createChoreographer() {
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
        Main.choreographers.add(new Choreographer(name, surname, gender));
        System.out.println("Хореограф создан");
    }
}

