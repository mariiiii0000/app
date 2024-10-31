import java.util.ArrayList;

public class YearReport {
    // Yellow
    // Необязательно писать тип данных в дженериках, когда создаем коллекцию
    ArrayList<Transaction_year> transactions_year = new ArrayList<Transaction_year>();

    void printReportsYear(){
        for (Transaction_year transactionYear: transactions_year){
            transactionYear.printYearReport();
        }
    }
    double sumReportsYear(int monthNumber, boolean isExpense){
        for (Transaction_year transactionYear: transactions_year){
            if (transactionYear.isExpense == isExpense && monthNumber == transactionYear.month){
                return transactionYear.amount;
            }
        }
        return 0;
    }


}
