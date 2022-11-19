import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static int getRandomInt(int low, int up) {
        int val = (int) (Math.random() * up);
        return (val + low) % up;
    }

    private static void PrintHelp() {
        System.out.println("/r - choose random student");
        System.out.println("/l - list of student with grades");
        System.out.println("/e - exit program");
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(0, "A"),
                new Student(1, "B"),
                new Student(2, "C")
        };
        Table table = new Table(students);
        boolean isExit = false;
        Scanner sc = new Scanner(System.in);


        while (!isExit) {
            System.out.print(">");
            String cmd = sc.nextLine();
            if (Objects.equals(cmd, "/e")) {
                isExit = true;
            } else if (Objects.equals(cmd, "/r")) {
                boolean f = false;
                for (int i = 0; i < students.length; i++) {
                    if (!table.HasBeenAsked(i))
                        f = true;
                }
                if (!f) {
                    System.out.println("Всех студентов уже спросили!");
                    continue;
                }
                int id = getRandomInt(0, students.length);
                while (table.HasBeenAsked(id)) {
                    id = getRandomInt(0, students.length);
                }
                table.SetAsked(id);
                System.out.println("Отвечает студент " + students[id].getName());
                System.out.println("Присутствует на паре?");
                System.out.print(">");
                char ans = sc.nextLine().charAt(0);
                boolean was = switch (ans) {
                    case 'y' -> true;
                    default -> false;
                };
                table.setWas(id, was);
                if (was) {
                    int mark = getRandomInt(1, 10);
                    table.setMark(id, mark);
                    System.out.println("Оценка за ответ: " + mark);
                }
            } else if (Objects.equals(cmd, "/l")) {
                table.Print();
            } else {
                PrintHelp();
            }
        }
    }
}