
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ReportManager reportManager = new ReportManager();
        while (true){

            printMenu();
            int command = scanner.nextInt();
            if (command == 1){
                reportManager.readAllReportsMonth();
                System.out.println("Готово!!");


            } else if (command == 2){
                reportManager.readReportYear();
                System.out.println("Готово!!");


            } else if (command == 3){
                if (reportManager.areLoadedAll()){
                    if (reportManager.compareSums()){
                        System.out.println("Сверка прошла успешно! Несоответствий не обнаружено)");
                    }

                } else {
                    System.out.println("для начала вызовите 1 и 2 команды!!");
                }

            } else if (command == 4){
                if (reportManager.areLoadedMonth()) {
                    reportManager.printMonthReports();
                } else {
                    System.out.println("для начала вызовите 1 командy!!");
                }
            } else if (command == 5){
                if (reportManager.areLoadedYear()) {
                    reportManager.printYearReport();
                } else {
                    System.out.println("для начала вызовите 2 командy!!");
                }

            } else if (command == 0){
                return;
            } else {
                System.out.println("Такой команды нет.");
            }
        }
    }
    public static void printMenu(){
        System.out.println("Выберите команду:");
        System.out.println("1 - Считать все месячные отчеты.");
        System.out.println("2 - Считать годовой отчет.");
        System.out.println("3 - Сверить отчеты.");
        System.out.println("4 - Вывести информацию обо всех месячных отчетах.");
        System.out.println("5 - Вывести информацию о годовом отчете.");
        System.out.println("0 - Выход из программы.");

    }
}