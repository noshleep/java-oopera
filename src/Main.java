import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Show> shows = new ArrayList<>();
    static ArrayList<Actor> actors = new ArrayList<>();
    static ArrayList<Director> directors = new ArrayList<>();
    static ArrayList<MusicAuthor> musicAuthors = new ArrayList<>();
    static ArrayList<Choreographer> choreographers = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Создать актёра");
            System.out.println("2. Создать режиссёра");
            System.out.println("3. Создать музыкального автора");
            System.out.println("4. Создать хореографа");
            System.out.println("5. Создать обычный спектакль");
            System.out.println("6. Создать оперный спектакль");
            System.out.println("7. Создать балетный спектакль");
            System.out.println("8. Распределить актёра по спектаклям");
            System.out.println("9. Убрать актёра из спектакля");
            System.out.println("10. Показать всех действующих лиц спектакля");
            System.out.println("11. Показать либретто оперы");
            System.out.println("12. Показать либретто балета");
            System.out.println("0. Выход");

            System.out.println("Выбор: ");
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1":
                    createActor();
                    break;
                case "2":
                    createDirector();
                    break;
                case "3":
                    createMusicAuthor();
                    break;
                case "4":
                    createChoreographer();
                    break;
                case "5":
                    createShow();
                    break;
                case "6":
                    createOpera();
                    break;
                case "7":
                    createBallet();
                    break;
                case "8":
                    assignActor();
                    break;
                case "9":
                    removeActorFromShow();
                case "10":
                    showActors();
                    break;
                case "11":
                    showOperaLibretto();
                    break;
                case "12":
                    showBalletLibretto();
                    break;
                case "0":
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }

    static void createActor() {
        System.out.println("Имя: ");
        String name = scanner.nextLine();
        System.out.println("Фамилия: ");
        String surname = scanner.nextLine();

        Gender gender;
        while (true) {
            System.out.println("Пол (М/Ж): ");
            String g = scanner.nextLine().trim().toUpperCase();
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
        String heightStr = scanner.nextLine();
        int height = Integer.parseInt(heightStr);

        actors.add(new Actor(name, surname, gender, height));
        System.out.println("Актёр создан");
    }

    static void createDirector() {
        System.out.println("Имя: ");
        String name = scanner.nextLine();
        System.out.println("Фамилия: ");
        String surname = scanner.nextLine();

        Gender gender;
        while (true) {
            System.out.println("Пол (М/Ж): ");
            String g = scanner.nextLine().trim().toUpperCase();
            if (g.equals("М")) {
                gender = Gender.MALE;
                break;
            } else if (g.equals("Ж")) {
                gender = Gender.FEMALE;
                break;
            } else System.out.println("Ошибка! Введите М или Ж.");
        }

        System.out.println("Количество спектаклей: ");
        String countStr = scanner.nextLine();
        int count = Integer.parseInt(countStr);

        directors.add(new Director(name, surname, gender, count));
        System.out.println("Режиссёр создан");
    }

    static void createMusicAuthor() {
        System.out.println("Имя: ");
        String name = scanner.nextLine();
        System.out.println("Фамилия: ");
        String surname = scanner.nextLine();

        Gender gender;
        while (true) {
            System.out.println("Пол (М/Ж): ");
            String g = scanner.nextLine().trim().toUpperCase();
            if (g.equals("М")) {
                gender = Gender.MALE;
                break;
            } else if (g.equals("Ж")) {
                gender = Gender.FEMALE;
                break;
            } else System.out.println("Ошибка! Введите М или Ж.");
        }

        musicAuthors.add(new MusicAuthor(name, surname, gender));
        System.out.println("Музыкальный автор создан");
    }

    static void createChoreographer() {
        System.out.println("Имя: ");
        String name = scanner.nextLine();
        System.out.println("Фамилия: ");
        String surname = scanner.nextLine();

        Gender gender;
        while (true) {
            System.out.println("Пол (М/Ж): ");
            String g = scanner.nextLine().trim().toUpperCase();
            if (g.equals("М")) {
                gender = Gender.MALE;
                break;
            } else if (g.equals("Ж")) {
                gender = Gender.FEMALE;
                break;
            } else System.out.println("Ошибка! Введите М или Ж.");
        }

        choreographers.add(new Choreographer(name, surname, gender));
        System.out.println("Хореограф создан");
    }

    static void createShow() {
        System.out.println("Название: ");
        String title = scanner.nextLine();

        for (Show show : shows)
            if (show.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Спектакль уже существует");
                return;
            }

        if (directors.isEmpty()) {
            System.out.println("Нет режиссёров!");
            return;
        }
        for (int i = 0; i < directors.size(); i++) {
            System.out.println((i + 1) + ". " + directors.get(i));
        }
        System.out.println("Выберите режиссёра: ");
        String indexStr = scanner.nextLine();
        Director director = directors.get(Integer.parseInt(indexStr) - 1);

        System.out.println("Длительность: ");
        String durStr = scanner.nextLine();
        int duration = Integer.parseInt(durStr);

        shows.add(new Show(title, duration, director));
        System.out.println("Спектакль создан");
    }

    static void createOpera() {
        System.out.println("Название: ");
        String title = scanner.nextLine();
        for (Show show : shows)
            if (show.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Опера уже существует");
                return;
            }

        if (directors.isEmpty() || musicAuthors.isEmpty()) {
            System.out.println("Нет режиссёров или музыкальных авторов!");
            return;
        }
        for (int i = 0; i < directors.size(); i++) {
            System.out.println((i + 1) + ". " + directors.get(i));
        }
        System.out.println("Выберите режиссёра: ");
        Director director = directors.get(Integer.parseInt(scanner.nextLine()) - 1);

        for (int i = 0; i < musicAuthors.size(); i++) {
            System.out.println((i + 1) + ". " + musicAuthors.get(i));
        }
        System.out.println("Выберите музыкального автора: ");
        MusicAuthor author = musicAuthors.get(Integer.parseInt(scanner.nextLine()) - 1);

        System.out.println("Длительность: ");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.println("Либретто: ");
        String libretto = scanner.nextLine();
        System.out.println("Размер хора: ");
        int choir = Integer.parseInt(scanner.nextLine());

        shows.add(new Opera(title, duration, director, author, libretto, choir));
        System.out.println("Опера создана");
    }

    static void createBallet() {
        System.out.println("Название: ");
        String title = scanner.nextLine();
        for (Show show : shows)
            if (show.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Балет уже существует");
                return;
            }

        if (directors.isEmpty() || musicAuthors.isEmpty() || choreographers.isEmpty()) {
            System.out.println("Нет необходимых сотрудников!");
            return;
        }
        for (int i = 0; i < directors.size(); i++) {
            System.out.println((i + 1) + ". " + directors.get(i));
        }
        System.out.println("Выберите режиссёра: ");
        Director director = directors.get(Integer.parseInt(scanner.nextLine()) - 1);

        for (int i = 0; i < musicAuthors.size(); i++) {
            System.out.println((i + 1) + ". " + musicAuthors.get(i));
        }
        System.out.println("Выберите музыкального автора: ");
        MusicAuthor author = musicAuthors.get(Integer.parseInt(scanner.nextLine()) - 1);

        for (int i = 0; i < choreographers.size(); i++) {
            System.out.println((i + 1) + ". " + choreographers.get(i));
        }
        System.out.println("Выберите хореографа: ");
        Choreographer ch = choreographers.get(Integer.parseInt(scanner.nextLine()) - 1);

        System.out.println("Длительность: ");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.println("Либретто: ");
        String libretto = scanner.nextLine();

        shows.add(new Ballet(title, duration, director, author, libretto, ch));
        System.out.println("Балет создан");
    }

    static void assignActor() {
        if (actors.isEmpty()) {
            System.out.println("Нет актёров!");
            return;
        }
        for (int i = 0; i < actors.size(); i++) {
            System.out.println((i + 1) + ". " + actors.get(i));
        }
        System.out.println("Выберите актёра: ");
        Actor actor = actors.get(Integer.parseInt(scanner.nextLine()) - 1);

        System.out.println("Количество спектаклей: ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("Название спектакля: ");
            String title = scanner.nextLine();
            boolean found = false;
            for (Show show : shows) {
                if (show.getTitle().equalsIgnoreCase(title)) {
                    show.addActor(actor);
                    found = true;
                }
            }
            if (!found) System.out.println("Спектакль не найден");
        }
    }

    static void removeActorFromShow() {
        if (shows.isEmpty()) {
            System.out.println("Нет созданных спектаклей!");
            return;
        }

        System.out.println("Название спектакля: ");
        String title = scanner.nextLine();
        Show targetShow = null;

        for (Show show : shows) {
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
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= targetShow.getListOfActors().size()) {
            System.out.println("Неверный номер актёра!");
            return;
        }

        Actor removed = targetShow.getListOfActors().remove(index);
        System.out.println("Актёр " + removed + " удалён из спектакля " + targetShow.getTitle());
    }

    static void showActors() {
        System.out.println("Название спектакля: ");
        String title = scanner.nextLine();
        boolean found = false;

        for (Show show : shows) {
            if (show.getTitle().equalsIgnoreCase(title)) {
                found = true;

                System.out.println("Действующие лица спектакля " + show.getTitle() + ":");

                if (show.director != null) {
                    System.out.println("Режиссёр: " + show.director);
                }

                if (show.getListOfActors().isEmpty()) {
                    System.out.println("Актёры: отсутствуют");
                } else {
                    System.out.println("Актёры:");
                    for (Actor actor : show.getListOfActors()) {
                        System.out.println(" - " + actor);
                    }
                }

                if (show instanceof MusicalShow ms && ms.musicAuthor != null) {
                    System.out.println("Музыкальный автор: " + ms.musicAuthor);
                }

                if (show instanceof Ballet ballet && ballet.choreographer != null) {
                    System.out.println("Хореограф: " + ballet.choreographer);
                }

                if (show instanceof Opera opera) {
                    System.out.println("Хор: " + opera.choirSize + " человек");
                }
            }
        }

        if (!found) System.out.println("Спектакль не найден");
    }

    static void showOperaLibretto() {
        System.out.println("Название оперы: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Show show : shows) {
            if (show instanceof Opera && show.getTitle().equalsIgnoreCase(title)) {
                ((Opera) show).printLibretto();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Опера не найдена");
        }
    }

    static void showBalletLibretto() {
        System.out.println("Название балета: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Show show : shows) {
            if (show instanceof Ballet && show.getTitle().equalsIgnoreCase(title)) {
                ((Ballet) show).printLibretto();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Балет не найден");
        }
    }
}

