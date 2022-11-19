public class Table {
    private Student[] students;
    private int[] marks;
    private boolean[] list;
    private boolean[] answered;

    public Table(Student[] students) {
        this.students = students;
        marks = new int[students.length];
        list = new boolean[students.length];
        answered = new boolean[students.length];
    }

    public boolean HasBeenAsked(int id) {
        return answered[id];
    }

    public void SetAsked(int id) {
        answered[id] = true;
    }

    public void setWas(int id, boolean was) {
        list[id] = was;
    }

    public void setMark(int id, int mark) {
        marks[id] = mark;
    }


    public void Print() {
        for (Student s: students) {
            if (list[s.getId()])
                System.out.println(s.getName() + " | " + marks[s.getId()]);
        }
    }
}
