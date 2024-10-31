import java.util.ArrayList;

public class ReportManager {
    MonthReport[] monthReports = new MonthReport[3];
    YearReport yearReport = new YearReport();
    FileReader fileReader = new FileReader();
    ReportManager(){
        for (int i = 0; i < monthReports.length; i++){
            monthReports[i] = new MonthReport();
        }
    }
    boolean compareSums(){
        boolean isEqual = true;
        int monthError = -1;
        for (int i = 0; i < monthReports.length; i++){
            if (monthReports[i].sumReportsMonth(true) != yearReport.sumReportsYear(i+1, true)){
                isEqual = false;
                monthError = i;

                break;
            }
            if (monthReports[i].sumReportsMonth(false) != yearReport.sumReportsYear(i+1, false)){
                isEqual = false;
                monthError = i;
                break;
            }
        }
        if (!isEqual){
            System.out.println("Обнаружены несоответствия в месяце под номером: " + (monthError+1));
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
    boolean areLoadedYear(){
        return !(yearReport.transactions_year.isEmpty());
    }
    boolean areLoadedMonth(){
        boolean monthsLoaded = true;
        for (MonthReport monthReport: monthReports){
            if (monthReport.transactions_month.isEmpty()){
                monthsLoaded = false;
            }
        }
        return  monthsLoaded;
    }

    boolean areLoadedAll(){
        boolean monthsLoaded = true;
        for (MonthReport monthReport: monthReports){
            if (monthReport.transactions_month.isEmpty()){
                monthsLoaded = false;
            }
        }
        return !(yearReport.transactions_year.isEmpty()) && monthsLoaded;
    }

    void printYearReport(){
        yearReport.printReportsYear();
    }

    void readReportYear(){
        ArrayList<String> lines = fileReader.readFileContents("y.2021.csv");
        for (int i = 1;i < lines.size();i++){
            String line = lines.get(i);
            String[] lineContents = line.split(",");
            int month = Integer.parseInt(lineContents[0]);
            int amount = Integer.parseInt(lineContents[1]);
            boolean isExpense = Boolean.parseBoolean(lineContents[2]);
            Transaction_year transactionYear = new Transaction_year(month, amount, isExpense);
            yearReport.transactions_year.add(transactionYear);

        }
    }


}

