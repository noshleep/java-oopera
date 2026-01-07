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
            System.out.println("9. Удалить актера из спектакля");
            System.out.println("10. Заменить актера в спектакле на другого");
            System.out.println("11. Показать полную информацию о спектакле");
            System.out.println("0. Выход");
            System.out.println("Выбор: ");

            String command = scanner.nextLine().trim();
            switch (command) {
                case "1":
                    new Actor("", "", Gender.MALE, 0).createActor();
                    break;
                case "2":
                    new Director("", "", Gender.MALE, 0).createDirector();
                    break;
                case "3":
                    new MusicAuthor("", "", Gender.MALE).createMusicAuthor();
                    break;
                case "4":
                    new Choreographer("", "", Gender.MALE).createChoreographer();
                    break;
                case "5":
                    new Show("", 0, null).createShow();
                    break;
                case "6":
                    Opera.createOpera();
                    break;
                case "7":
                    new Ballet
                            ("",
                                    0,
                                    null,
                                    null,
                                    "",
                                    null
                            )
                            .createBallet();
                    break;
                case "8":
                    new Actor("", "", Gender.MALE, 0).assignActor();
                    break;
                case "9":
                    new Actor("", "", Gender.MALE, 0).removeActorFromShow();
                    break;
                case "10":
                    replaceActorInShow();
                    break;
                case "11":
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

    private static void replaceActorInShow() {
        if (shows.isEmpty()) {
            System.out.println("Нет спектаклей для редактирования!");
            return;
        }
        System.out.println("Выберите спектакль для замены актёра:");
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
            System.out.println("В этом спектакле нет актёров для замены!");
            return;
        }
        System.out.println("Введите фамилию актёра, которого хотите заменить: ");
        String surnameToReplace = scanner.nextLine();
        if (actors.isEmpty()) {
            System.out.println("Нет доступных актёров для замены!");
            return;
        }
        System.out.println("Выберите нового актёра:");
        for (int i = 0; i < actors.size(); i++) {
            System.out.println((i + 1) + ". " + actors.get(i));
        }
        int actorIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (actorIndex < 0 || actorIndex >= actors.size()) {
            System.out.println("Некорректный выбор актёра");
            return;
        }
        Actor newActor = actors.get(actorIndex);
        selectedShow.replaceActor(surnameToReplace, newActor);
    }
}



