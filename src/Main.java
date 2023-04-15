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
    }

    public static void printAllData() {
        for (int i = 0; i < Employee.getId(); i++) {
            System.out.println(data[i]);
        }
    }

    public static void calcAllCostsPerMonth() {
        int sum = 0;
        for (int i = 0; i < Employee.getId(); i++) {
            sum = sum + data[i].getWage();
        }
        System.out.println("Сумма затрат на зарплаты в месяц : " + sum);
    }

    public static void findEmployeeMinWage() {
        int min = data[0].getWage();
        String name = data[0].getFullname();
        for (int i = 1; i < Employee.getId(); i++) {
            if (data[i].getWage() < min) {
                min = data[i].getWage();
                name = data[i].getFullname();
            }
        }
        System.out.println("Сотрудник с самой низкой зарплатой: " + name);
    }

    public static void findEmployeeMaxWage() {
        int max = data[0].getWage();
        String name = data[0].getFullname();
        for (int i = 1; i < Employee.getId(); i++) {
            if (data[i].getWage() > max) {
                max = data[i].getWage();
                name = data[i].getFullname();
            }
        }
        System.out.println("Сотрудник с самой высокой зарплатой: " + name);
    }

    public static void calcAverageWage() {
        int sum = 0;
        for (int i = 0; i < Employee.getId(); i++) {
            sum = sum + data[i].getWage();
        }
        System.out.println("Средняя зарплата : " + sum / Employee.getId());
    }

    public static void printAllFullName() {
        for (int i = 0; i < Employee.getId(); i++) {
            System.out.println("Сотрудник " + (i + 1) + " : " + data[i].getFullname());
        }
    }
}