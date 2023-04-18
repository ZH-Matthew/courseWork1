import java.util.Scanner;

public class EmployeeBook {
    private final Employee[] data = new Employee[10];

    Scanner sc = new Scanner(System.in);

    public void addEmployee(String fullname, int department, int wage) { //добавить сотрудника (протестирован)
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

    public void removeEmployee(String fio) {  //удалить сотрудника (протестирован)
        for (int i = 0; i < data.length; i++) {
            if (data[i].getFullname().equals(fio)) {
                System.out.println(data[i].getFullname() + " удален");
                data[i] = null;
                return;
            }
        }
    }

    public void changeEmployee(String fio) { //изменить данные сотрудника (протестирован)
        System.out.println("Какие данные вы хотели бы изменить?");
        System.out.println("Для изменения ЗП введите в консоль: 1 , для изменения отдела введите: 2, для выхода введите: 0");
        int a = sc.nextInt();
        while (true) {
            if (a == 1) {
                System.out.println("Какую заработную плату вы хотите установить в качестве новой? Введите значение в консоль:");
                int b = sc.nextInt();
                for (Employee datum : data) {
                    if (datum != null) {
                        if (datum.getFullname().equals(fio)) {
                            datum.setWage(b);
                            System.out.println("Данные сохранены!");
                        }
                    }
                }break;
            } else if (a == 2) {
                System.out.println("В какой отдел вы хотели бы перевести сотрудника? Введите номер отдела в консоль:");
                int b = sc.nextInt();
                if (0 < b && b < 6) {
                    for (Employee datum : data) {
                        if (datum != null) {
                            if (datum.getFullname().equals(fio)) {
                                datum.setDepartment(b);
                                System.out.println("Данные сохранены!");
                            }
                        }
                    }break;
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

    public void printAllFullNameByDept() { // печать ФИО по отделам (протестиован)

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



    public void findEmployeeByWageMore(int a) { //сотрудник с ЗП больше указаной (протестирован)
        System.out.println("Сотрудники с ЗП больше " + a + " :");
        for (Employee datum : data) {
            if (datum != null) {
                if (datum.getWage() >= a) {
                    System.out.println("ФИО : " + datum.getFullname() + " , ЗП: " + datum.getWage() + " , ID: " + datum.getId());
                }
            }
        }
    }

    public void findEmployeeByWageLess(int a) { //сотрудник с меньше указаной (протеститрован)
        System.out.println("Сотрудники с ЗП меньше " + a + " :");
        for (Employee datum : data) {
            if (datum != null) {
                if (datum.getWage() < a) {
                    System.out.println("ФИО : " + datum.getFullname() + " , ЗП: " + datum.getWage() + " , ID: " + datum.getId());
                }
            }
        }
    }

    public void printAllEmployeeInDept(int dept) { //напечатать всех сотрудников указанного отдела (протестировано)
        System.out.println("Все сотрудники отдела N"+dept +" : " );
        for (Employee datum : data) {
            if (datum != null) {
                if (datum.getDepartment() == dept) {
                    System.out.println("ФИО : " + datum.getFullname() + " , ЗП: " + datum.getWage() + " , ID: " + datum.getId());
                }
            }
        }
    }

    public void recalculateSalaryInDept(int dept, int per) { //проиндексировать ЗП по отделу (протестировано)
        for (Employee datum : data) {
            if (datum != null) {
                if (datum.getDepartment() == dept) {
                    datum.setWage(datum.getWage() + datum.getWage() / 100 * per);
                }
            }
        }
        System.out.println("Зарплата в отделе N" + dept + " проиндексирована!");
    }

    public void calcAverageWageInDept(int dept) { //посчитать среднюю ЗП по отделу (протестировано)
        int sum = 0;
        int count = 0;
        for (Employee datum : data) {
            if (datum != null) {
                if (datum.getDepartment() == dept) {
                    sum = sum + datum.getWage();
                    count++;
                }
            }
        }
        System.out.println("Средняя зарплата в отделе N" + dept + " : " + sum / count);
    }

    public void findEmployeeMaxWageInDept(int dept) { //узнать сотрудника с максимальной ЗП в отделе (протестировано)
        Employee max = data[0];
        for (Employee datum : data) {
            if (datum != null) {
                if (datum.getDepartment() == dept) {
                    max = datum;
                    break;
                }
            }
        }
        for (Employee datum : data) {
            if (datum != null) {
                if (datum.getDepartment() == dept && datum.getWage() > max.getWage()) {
                    max = datum;
                }
            }
        }
        System.out.println("С максимальной зарплатой в отделе N" + dept + " " + max);
    }

    public void findEmployeeMinWageInDept(int dept) { //узнать сотрудника с минимальной ЗП в отделе (протестировано)
        Employee min = data[0];
        for (Employee datum : data) { //данный цикл находит 1 сотрудника из нужного отдела и берет его в качестве исходника для сравнения
            if (datum != null) {
                if (datum.getDepartment() == dept) {
                    min = datum;
                    break;
                }
            }
        }
        for (Employee datum : data) { // этот цикл сравнивает всех остальных сотрудников нужного отдела с исходником и меняется местами если условие соблюдено
            if (datum != null) {
                if (datum.getDepartment() == dept && datum.getWage() < min.getWage()) {
                    min = datum;
                }
            }
        }
        System.out.println("С самой низкой зарплатой в отделе N" + dept + " " + min);
    }

    public void recalculateSalary(int per) { //проиндексировать все ЗП (протестировано)
        for (Employee datum : data) {
            if (datum != null) {
                datum.setWage(datum.getWage() + datum.getWage() / 100 * per);
            }
        }
        System.out.println("Зарплата у всех сотрудников проиндексирована!");
    }

    public void printAllData() { //печать всех данных (протестирован)
        for (Employee datum : data) {
            if (datum != null) {
                System.out.println(datum);
            }
        }
    }

    public void calcAllCostsPerMonth() { // посчитать расходы по ЗП всех сотрудников за месяц (протестирован)
        int sum = 0;
        for (Employee datum : data) {
            if (datum != null) {
                sum = sum + datum.getWage();
            }
        }
        System.out.println("Сумма расходов на зарплаты в месяц : " + sum);
    }

    public void findEmployeeMinWage() { //найти сотрудника с минимальной ЗП (протестирован)
        Employee min = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] != null) {
                if (data[i].getWage() < min.getWage()) {
                    min = data[i];
                }
            }
        }
        System.out.println("С самой низкой зарплатой: " + min);
    }

    public void findEmployeeMaxWage() { // //найти сотрудника с максимальной ЗП (протестирован)
        Employee max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] != null) {
                if (data[i].getWage() > max.getWage()) {
                    max = data[i];
                }
            }
        }
        System.out.println("С самой высокой зарплатой: " + max);
    }

    public void calcAverageWage() { // посчитать среднюю ЗП по всем сотрудникам (протестировано)
        int sum = 0;
        int count = 0;
        for (Employee datum : data) {
            if (datum != null) {
                sum = sum + datum.getWage();
                count++;
            }
        }
        System.out.println("Средняя зарплата : " + sum / count);
    }

    public void printAllFullName() { //распечатать ФИО всех сотрудников (протестировано)
        System.out.println("ФИО всех сотрудников: ");
        for (Employee datum : data) {
            if (datum != null) {
                System.out.println(datum.getFullname());
            }
        }
    }
}

