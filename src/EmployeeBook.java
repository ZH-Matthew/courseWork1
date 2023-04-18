import java.util.Scanner;

public class EmployeeBook {
    private final Employee[] data = new Employee[10];

    Scanner sc = new Scanner(System.in);

    public void addEmployee(String fullname, int department, int wage) { //добавить сотрудника
        if (Employee.idCount >= data.length) {
            System.out.println("Нельзя добавить сотрудника, закончилось место");
        } else {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == null) {
                    Employee newEmployee = new Employee(fullname, department, wage);
                    data[i] = newEmployee;
                    return;
                }
            }
        }
    }

    public void removeEmployee(String fio) {  //удалить сотрудника
        for (int i = 0; i < data.length; i++) {
            if (data[i].getFullname().equals(fio)) {
                System.out.println(data[i].getFullname() + " удален");
                data[i] = null;
                return;
            }
        }
    }

    public void changeEmployee(String fio) { //изменить данные сотрудника
        System.out.println("Какие данные вы хотели бы изменить?");
        System.out.println("Для изменения ЗП введите: 1 , для изменения отдела введите: 2, для выхода введите: 0");
        int a = sc.nextInt();
        while (true) {
            if (a == 1) {
                System.out.println("Какую заработную плату вы хотите установить в качестве новой? Введите значение в консоль:");
                int b = sc.nextInt();
                for (Employee datum : data) {
                    if (datum.getFullname().equals(fio)) {
                        datum.setWage(b);
                        System.out.println("Данные сохранены!");
                        break;
                    }
                }
            } else if (a == 2) {
                System.out.println("В какой отдел вы хотели бы перевести сотрудника? Введите номер отдела в консоль");
                int b = sc.nextInt();
                if (0 < b && b < 6) {
                    for (Employee datum : data) {
                        if (datum.getFullname().equals(fio)) {
                            datum.setDepartment(b);
                            System.out.println("Данные сохранены!");
                            break;
                        }
                    }
                } else {
                    System.out.println("Отдела с таким номером нет. Всего 5 отделов с 1 по 5 включительно");
                    break;
                }
            } else if (a == 0) {
                System.out.println("Пока-пока!");
                break;
            }
        }
    }

    public void printAllFullNameByDept() { // печать ФИО по отделам (рабочий)

        for (Employee datum : data) {
            if (datum != null) {
                if (datum.getDepartment() == 1) {
                    System.out.println("Сотрудники отдела N1: "+datum.getFullname());
                }
            }
        }
        for (Employee datum : data) {
            if (datum != null) {
                if (datum.getDepartment() == 2) {
                    System.out.println("Сотрудники отдела N2: "+datum.getFullname());
                }
            }
        }
        for (Employee datum : data) {
            if (datum != null) {
                if (datum.getDepartment() == 3) {
                    System.out.println("Сотрудники отдела N3: "+datum.getFullname());
                }
            }
        }
        for (Employee datum : data) {
            if (datum != null) {
                if (datum.getDepartment() == 4) {
                    System.out.println("Сотрудники отдела N4: "+datum.getFullname());
                }
            }
        }
        for (Employee datum : data) {
            if (datum != null) {
                if (datum.getDepartment() == 5) {
                    System.out.println("Сотрудники отдела N5: "+datum.getFullname());
                }
            }
        }
    }



    public void findEmployeeByWageMore(int a) {
        System.out.println("Сотрудники с ЗП больше " + a + " :");
        for (int i = 0; i < Employee.idCount; i++) {
            if (data[i].getWage() >= a) {
                System.out.println("ФИО : " + data[i].getFullname() + " , ЗП: " + data[i].getWage() + " , ID: " + data[i].getId());
            }
        }
    }

    public void findEmployeeByWageLess(int a) {
        System.out.println("Сотрудники с ЗП меньше " + a + " :");
        for (int i = 0; i < Employee.idCount; i++) {
            if (data[i].getWage() < a) {
                System.out.println("ФИО : " + data[i].getFullname() + " , ЗП: " + data[i].getWage() + " , ID: " + data[i].getId());
            }
        }
    }

    public void printAllEmployeeInDept(int dept) {
        for (int i = 0; i < Employee.idCount; i++) {
            if (data[i].getDepartment() == dept) {
                System.out.println("Сотрудники отдела N" + dept + " :");
                System.out.println("ФИО : " + data[i].getFullname() + " , ЗП: " + data[i].getWage() + " , ID: " + data[i].getId());
            }
        }
    }

    public void recalculateSalaryInDept(int dept, int per) { //проиндексировать ЗП по отделу
        for (int i = 0; i < Employee.idCount; i++) {
            if (data[i].getDepartment() == dept) {
                data[i].setWage(data[i].getWage() + data[i].getWage() / 100 * per);
            }
        }
        System.out.println("Зарплата в отделе N" + dept + " проиндексирована!");
    }

    public void calcAverageWageInDept(int dept) {
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

    public void findEmployeeMaxWageInDept(int dept) {
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

    public void findEmployeeMinWageInDept(int dept) {
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

    public void recalculateSalary(int per) { //проиндексировать ЗП
        for (int i = 0; i < Employee.idCount; i++) {
            data[i].setWage(data[i].getWage() + data[i].getWage() / 100 * per);
        }
        System.out.println("Зарплата у всех сотрудников проиндексирована!");
    }

    public void printAllData() {  //Вариант 1
        for (int i = 0; i < Employee.idCount; i++) {
            System.out.println(data[i]);
        }
    }

    public void calcAllCostsPerMonth() {
        int sum = 0;
        for (int i = 0; i < Employee.idCount; i++) {
            sum = sum + data[i].getWage();
        }
        System.out.println("Сумма затрат на зарплаты в месяц : " + sum);
    }

    public void findEmployeeMinWage() {
        Employee min = data[0];
        for (int i = 1; i < Employee.idCount; i++) {
            if (data[i].getWage() < min.getWage()) {
                min = data[i];
            }
        }
        System.out.println("С самой низкой зарплатой: " + min);
    }

    public void findEmployeeMaxWage() {
        Employee max = data[0];
        for (int i = 1; i < Employee.idCount; i++) {
            if (data[i].getWage() > max.getWage()) {
                max = data[i];
            }
        }
        System.out.println("С самой высокой зарплатой: " + max);
    }

    public void calcAverageWage() {
        int sum = 0;
        for (int i = 0; i < Employee.idCount; i++) {
            sum = sum + data[i].getWage();
        }
        System.out.println("Средняя зарплата : " + sum / Employee.idCount);
    }

    public void printAllFullName() {
        for (int i = 0; i < Employee.idCount; i++) {
            System.out.println("Сотрудник " + (i + 1) + " : " + data[i].getFullname());
        }
    }
}

