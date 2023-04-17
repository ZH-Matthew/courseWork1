
public class Main {
    public static Employee[] data = new Employee[10];

    public static void main(String[] args) {
        data[0] = new Employee("Умник Виктор Петрович", 1, 51000);
        data[1] = new Employee("Ворчун Андрей Николаевич", 2, 52000);
        data[2] = new Employee("Весельчак Людвиг Аристархович", 3, 53000);
        data[3] = new Employee("Соня Виталий Андреевич", 4, 54000);
        data[4] = new Employee("Скромник Федор Матвеевич", 5, 55000);
        data[5] = new Employee("Чихун Иосиф Виссарионович", 1, 56000);
        data[6] = new Employee("Простак Иван Иванович", 2, 57000);


        printAllData();
        calcAllCostsPerMonth();
        findEmployeeMinWage();
        findEmployeeMaxWage();
        calcAverageWage();
        printAllFullName();
        findEmployeeMinWageInDept(2);
        findEmployeeMaxWageInDept(1);
        calcAverageWageInDept(2);
        printAllEmployeeInDept(4);
        findEmployeeByWageLess(54000); //вывод сотрудников с зарплатой меньше заданой
        findEmployeeByWageMore(54000); // вывод сотрудников с зарплатой выше (или равной заданной)

        recalculateSalary(13); //индексацию поставил последней, чтобы было нагляднее, иначе все методы возьмут проиндексированные данные
        printAllData();//вызвал все данные для проверки изменений
        recalculateSalaryInDept(2, 10);
        printAllData();
    }

    public static void findEmployeeByWageMore(int a) {
        System.out.println("Сотрудники с ЗП больше "+ a + " :");
        for (int i = 0; i < Employee.idCount; i++) {
            if (data[i].getWage()>= a){
                System.out.println("ФИО : " + data[i].getFullname() + " , ЗП: " + data[i].getWage() + " , ID: " + data[i].getId());
            }
        }
    }
    public static void findEmployeeByWageLess(int a) {
        System.out.println("Сотрудники с ЗП меньше "+ a + " :");
        for (int i = 0; i < Employee.idCount; i++) {
            if (data[i].getWage()<a){
                System.out.println("ФИО : " + data[i].getFullname() + " , ЗП: " + data[i].getWage() + " , ID: " + data[i].getId());
            }
        }
    }
    public static void printAllEmployeeInDept(int dept) {
        for (int i = 0; i < Employee.idCount; i++) {
            if (data[i].getDepartment() == dept) {
                System.out.println("Сотрудники отдела N" + dept + " :");
                System.out.println("ФИО : " + data[i].getFullname() + " , ЗП: " + data[i].getWage() + " , ID: " + data[i].getId());
            }
        }
    }

    public static void recalculateSalaryInDept(int dept, int per) { //проиндексировать ЗП по отделу
        for (int i = 0; i < Employee.idCount; i++) {
            if (data[i].getDepartment() == dept) {
                data[i].setWage(data[i].getWage() + data[i].getWage() / 100 * per);
            }
        }
        System.out.println("Зарплата в отделе N" + dept + " проиндексирована!");
    }

    public static void calcAverageWageInDept(int dept) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < Employee.idCount; i++) {
            if (data[i].getDepartment() == dept) {
                sum = sum + data[i].getWage();
                count++;
            }
        }
        System.out.println("Средняя зарплата в отделе N" + dept + " : " + sum / count);
    }

    public static void findEmployeeMaxWageInDept(int dept) {
        Employee max = data[0];
        for (int i = 0; i < Employee.idCount; i++) {
            if (data[i].getDepartment() == dept) {
                max = data[i];
                break;
            }
        }
        for (int i = 0; i < Employee.idCount; i++) {
            if (data[i].getDepartment() == dept && data[i].getWage() > max.getWage()) {
                max = data[i];
            }
        }
        System.out.println("С максимальной зарплатой в отделе N" + dept + " " + max);
    }

    public static void findEmployeeMinWageInDept(int dept) {
        Employee min = data[0];
        for (int i = 0; i < Employee.idCount; i++) { //данный цикл находит 1 сотрудника из нужного отдела и берет его в качестве исходника для сравнения
            if (data[i].getDepartment() == dept) {
                min = data[i];
                break;
            }
        }
        for (int i = 0; i < Employee.idCount; i++) { // этот цикл сравнивает всех остальных сотрудников нужного отдела с исходником и меняется местами если условие соблюдено
            if (data[i].getDepartment() == dept && data[i].getWage() < min.getWage()) {
                min = data[i];
            }
        }
        System.out.println("С самой низкой зарплатой в отделе N" + dept + " " + min);
    }

    public static void recalculateSalary(int per) { //проиндексировать ЗП
        for (int i = 0; i < Employee.idCount; i++) {
            data[i].setWage(data[i].getWage() + data[i].getWage() / 100 * per);
        }
        System.out.println("Зарплата у всех сотрудников проиндексирована!");
    }

    public static void printAllData() {  //Вариант 1
        for (int i = 0; i < Employee.idCount; i++) {
            System.out.println(data[i]);
        }
    }
 /*
    public static void printAllData() { //Вариант 2
        for (Employee datum : data) {
            if (datum != null) {
                System.out.println(datum);
            } else {
                break;
            }
        }
    }
  */

    public static void calcAllCostsPerMonth() {
        int sum = 0;
        for (int i = 0; i < Employee.idCount; i++) {
            sum = sum + data[i].getWage();
        }
        System.out.println("Сумма затрат на зарплаты в месяц : " + sum);
    }

    public static void findEmployeeMinWage() {
        Employee min = data[0];
        for (int i = 1; i < Employee.idCount; i++) {
            if (data[i].getWage() < min.getWage()) {
                min = data[i];
            }
        }
        System.out.println("С самой низкой зарплатой: " + min);
    }

    public static void findEmployeeMaxWage() {
        Employee max = data[0];
        for (int i = 1; i < Employee.idCount; i++) {
            if (data[i].getWage() > max.getWage()) {
                max = data[i];
            }
        }
        System.out.println("С самой высокой зарплатой: " + max);
    }

    public static void calcAverageWage() {
        int sum = 0;
        for (int i = 0; i < Employee.idCount; i++) {
            sum = sum + data[i].getWage();
        }
        System.out.println("Средняя зарплата : " + sum / Employee.idCount);
    }

    public static void printAllFullName() {
        for (int i = 0; i < Employee.idCount; i++) {
            System.out.println("Сотрудник " + (i + 1) + " : " + data[i].getFullname());
        }
    }
}