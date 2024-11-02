import java.util.ArrayList;

public class ReportManager {
    // Yellow+
    // Лучше создать константу (неизменяемую переменную для хранения количества месяцев),
    // чтобы в случае увеличения количества отчетов, меньше было кода изменять
    // Например, так:
    final int monthCount = 3;
    MonthReport[] monthReports = new MonthReport[monthCount];
    YearReport yearReport = new YearReport();
    FileReader fileReader = new FileReader();
    ReportManager(){
        for (int i = 0; i < monthReports.length; i++){
            monthReports[i] = new MonthReport();
        }
    }
    // Yellow
    // Не очень удачное название метода
    // Я бы назвал isReportsEqual()
    boolean compareSums(){
        boolean isEqual = true;
        for (int i = 0; i < monthReports.length; i++){
            // Yellow+
            // Повторяющийся код в двух условных конструкциях
            // Можно поставить логический оператор ИЛИ, совместив два условия в одно
            // + тк условие очень громоздкое получается, лучше сначала запихнуть значение его в логическую переменную
            // boolean isSumsEqual = ... || ...
            boolean isSumsEqual = monthReports[i].sumReportsMonth(true) != yearReport.sumReportsYear(i+1, true);
            boolean isSumsEqual2 = monthReports[i].sumReportsMonth(false) != yearReport.sumReportsYear(i+1, false);
            if (isSumsEqual || isSumsEqual2){
                isEqual = false;
                System.out.println("Обнаружены несоответствия в месяце под номером: " + (i+1));

            }
        }
        return isEqual;
    }


    void readAllReportsMonth() {
        readReportsMonth(0, "m.202101.csv");
        readReportsMonth(1, "m.202102.csv");
        readReportsMonth(2, "m.202103.csv");

    }

    void printMonthReports(){
        int month = 1;
        for (MonthReport report : monthReports) {
            System.out.println("     ");
            System.out.println("MONTH - " + month);
            month++;
            report.printReportsMonth();
        }
    }




    boolean areLoadedYear(){
        return !(yearReport.transactions_year.isEmpty());
    }
    boolean areLoadedMonth(){
        boolean monthsLoaded = true;
        for (MonthReport monthReport: monthReports){
            if (monthReport.transactions_month.isEmpty()){
                // Red+
                // Если мы встретили пустой месяц, мы опускаем флаг
                // В таком случае необязательно идти дальше
                // и мы можем оборвать цикл с помощью break
                monthsLoaded = false;
                break;
            }
        }
        return  monthsLoaded;
    }

    // Red+
    // Лучше не копировать логику двух предыдущих месяцев
    // А просто возвращать из совмещенное значение
    // return areLoadedYear() && areLoadedMonth();
    boolean areLoadedAll(){
        return areLoadedYear() && areLoadedMonth();

    }

    void printYearReport(){
        yearReport.printReportsYear();
    }
    // Yellow+
    // Методы, которые связаны друг с другом желательно группировать в классе
    // Например, этот метод схож с методом по считыванию месячных отчетов
    // Логично поставить их недалеко друг от друга

    void readReportsMonth(int monthNumber, String fileName){
        ArrayList<String> lines = fileReader.readFileContents(fileName);
        MonthReport monthReport = monthReports[monthNumber];
        for (int i = 1; i < lines.size(); i++){
            String line = lines.get(i);
            String[] lineContents = line.split(",");
            String name = lineContents[0];
            boolean isExpense = Boolean.parseBoolean(lineContents[1]);
            int quantity = Integer.parseInt(lineContents[2]);
            double priceOf1 = Double.parseDouble(lineContents[3]);
            Transaction transaction = new Transaction(name, isExpense, quantity, priceOf1);
            monthReport.transactions_month.add(transaction);


        }

    }

    void readReportYear(){
        ArrayList<String> lines = fileReader.readFileContents("y.2021.csv");
        for (int i = 1;i < lines.size();i++){
            String line = lines.get(i);
            String[] lineContents = line.split(",");
            int month = Integer.parseInt(lineContents[0]);
            int amount = Integer.parseInt(lineContents[1]);
            boolean isExpense = Boolean.parseBoolean(lineContents[2]);
            TransactionYear transactionYear = new TransactionYear(month, amount, isExpense);
            yearReport.transactions_year.add(transactionYear);

        }
    }


}

