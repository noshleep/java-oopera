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
            System.out.println("1. Создать актера");
            System.out.println("2. Создать режиссера");
            System.out.println("3. Создать музыкального автора");
            System.out.println("4. Создать хореографа");
            System.out.println("5. Создать обычный спектакль");
            System.out.println("6. Создать оперный спектакль");
            System.out.println("7. Создать балетный спектакль");
            System.out.println("8. Показать список актеров");
            System.out.println("9. Показать список режиссеров");
            System.out.println("10. Показать список музыкальных авторов");
            System.out.println("11. Показать список хореографов");
            System.out.println("12. Распределить актера по спектаклям");
            System.out.println("13. Удалить актера из спектакля");
            System.out.println("14. Заменить актера в спектакле на другого");
            System.out.println("15. Показать полную информацию о спектакле");
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
                    printActors();
                    break;
                case "9":
                    printDirectors();
                    break;
                case "10":
                    printMusicAuthors();
                    break;
                case "11":
                    printChoreographers();
                    break;
                case "12":
                    assignActor();
                    break;
                case "13":
                    removeActorFromShow();
                    break;
                case "14":
                    replaceActorInShow();
                    break;
                case "15":
                    findShow();
                    break;
                case "0":
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }

    private static void createActor() {
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
        System.out.println("Актер создан");
    }

    private static void createDirector() {
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
        System.out.println("Режиссер создан");
    }

    private static void createMusicAuthor() {
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

    private static void createChoreographer() {
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

    private static void createShow() {
        System.out.println("Название: ");
        String title = scanner.nextLine();
        for (Show show : shows)
            if (show.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Спектакль уже существует");
                return;
            }
        if (directors.isEmpty()) {
            System.out.println("Нет режиссеров!");
            return;
        }
        for (int i = 0; i < directors.size(); i++) {
            System.out.println((i + 1) + ". " + directors.get(i));
        }
        System.out.println("Выберите режиссера: ");
        String indexStr = scanner.nextLine();
        Director director = directors.get(Integer.parseInt(indexStr) - 1);
        System.out.println("Длительность: ");
        String durStr = scanner.nextLine();
        int duration = Integer.parseInt(durStr);
        shows.add(new Show(title, duration, director));
        System.out.println("Спектакль создан");
    }

    private static void createBallet() {
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
        System.out.println("Выберите режиссера: ");
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

    private static void createOpera() {
        System.out.println("Название: ");
        String title = scanner.nextLine();
        for (Show show : shows)
            if (show.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Опера уже существует");
                return;
            }
        if (directors.isEmpty() || musicAuthors.isEmpty()) {
            System.out.println("Нет режиссеров или музыкальных авторов!");
            return;
        }
        for (int i = 0; i < directors.size(); i++) {
            System.out.println((i + 1) + ". " + directors.get(i));
        }
        System.out.println("Выберите режиссера: ");
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

    private static void printActors() {
        if (actors.isEmpty()) {
            System.out.println("Актеров нет");
            return;
        }
        for (int i = 0; i < actors.size(); i++) {
            System.out.println((i + 1) + ". " + actors.get(i));
        }
    }

    private static void printDirectors() {
        if (directors.isEmpty()) {
            System.out.println("Режиссеров нет");
            return;
        }
        for (int i = 0; i < directors.size(); i++) {
            System.out.println((i + 1) + ". " + directors.get(i));
        }
    }

    private static void printMusicAuthors() {
        if (musicAuthors.isEmpty()) {
            System.out.println("Музыкальных авторов нет");
            return;
        }
        for (int i = 0; i < musicAuthors.size(); i++) {
            System.out.println((i + 1) + ". " + musicAuthors.get(i));
        }
    }

    private static void printChoreographers() {
        if (choreographers.isEmpty()) {
            System.out.println("Хореографов нет");
            return;
        }
        for (int i = 0; i < choreographers.size(); i++) {
            System.out.println((i + 1) + ". " + choreographers.get(i));
        }
    }

    private static void assignActor() {
        if (Main.actors.isEmpty()) {
            System.out.println("Нет актеров!");
            return;
        }
        for (int i = 0; i < Main.actors.size(); i++) {
            System.out.println((i + 1) + ". " + Main.actors.get(i));
        }
        System.out.println("Выберите актера: ");
        Actor actor = Main.actors.get(Integer.parseInt(Main.scanner.nextLine()) - 1);
        System.out.println("Количество спектаклей: ");
        int count = Integer.parseInt(Main.scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Название спектакля: ");
            String title = Main.scanner.nextLine();
            boolean found = false;
            for (Show show : Main.shows) {
                if (show.getTitle().equalsIgnoreCase(title)) {
                    if (show.getListOfActors().contains(actor)) {
                        System.out.println("Актер уже добавлен");
                    } else {
                        show.getListOfActors().add(actor);
                        System.out.println("Актер добавлен");
                    }
                    found = true;
                }
            }
            if (!found) System.out.println("Спектакль не найден");
        }
    }

    private static void removeActorFromShow() {
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
            System.out.println("В спектакле нет актеров!");
            return;
        }
        System.out.println("Актеры в спектакле:");
        for (int i = 0; i < targetShow.getListOfActors().size(); i++) {
            System.out.println((i + 1) + ". " + targetShow.getListOfActors().get(i));
        }
        System.out.println("Выберите номер актера для удаления: ");
        int index = Integer.parseInt(Main.scanner.nextLine()) - 1;
        if (index < 0 || index >= targetShow.getListOfActors().size()) {
            System.out.println("Неверный номер актера!");
            return;
        }
        Actor removed = targetShow.getListOfActors().remove(index);
        System.out.println("Актер " + removed + " удален из спектакля " + targetShow.getTitle());
    }

    private static void replaceActorInShow() {
        if (shows.isEmpty()) {
            System.out.println("Нет спектаклей для редактирования!");
            return;
        }
        System.out.println("Выберите спектакль для замены актера:");
        for (int i = 0; i < shows.size(); i++) {
            System.out.println((i + 1) + ". " + shows.get(i).getTitle());
        }
        int showIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (showIndex < 0 || showIndex >= shows.size()) {
            System.out.println("Некорректный выбор спектакля");
            return;
        }
        Show selectedShow = shows.get(showIndex);
        if (selectedShow.getListOfActors().isEmpty()) {
            System.out.println("В этом спектакле нет актеров для замены!");
            return;
        }
        System.out.println("Введите фамилию актера, которого хотите заменить: ");
        String surnameToReplace = scanner.nextLine();
        if (actors.isEmpty()) {
            System.out.println("Нет доступных актеров для замены!");
            return;
        }
        System.out.println("Выберите нового актера:");
        for (int i = 0; i < actors.size(); i++) {
            System.out.println((i + 1) + ". " + actors.get(i));
        }
        int actorIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (actorIndex < 0 || actorIndex >= actors.size()) {
            System.out.println("Некорректный выбор актера");
            return;
        }
        Actor newActor = actors.get(actorIndex);
        if (selectedShow.replaceActor(surnameToReplace, newActor)) {
            System.out.println("Актер заменен");
        } else {
            System.out.println("Актер не найден");
        }
    }

    private static void findShow() {
        if (shows.isEmpty()) {
            System.out.println("Нет спектаклей!");
            return;
        }
        System.out.println("Название спектакля: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Show show : shows) {
            if (show.getTitle().equalsIgnoreCase(title)) {
                show.showInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Спектакль не найден");
        }
    }
}



