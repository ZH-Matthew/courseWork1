public class Employee {
    private String fullname;
    private int department;
    private int wage;
    private final int id;

    public static int idCount = 0;

    public Employee(String fullname, int department, int wage) {
        this.fullname = fullname;
        this.department = department;
        this.wage = wage;
        this.id = idCount++;
    }

    public String getFullname() {
        return fullname;
    }

    public int getDepartment() {
        return department;
    }

    public int getWage() {
        return wage;
    }

    public int getId() {
        return id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Сотрудник:" +
                " ФИО : '" + fullname + '\'' +
                ", Отдел : " + department +
                ", Зарплата : " + wage +
                '.';
    }
}
