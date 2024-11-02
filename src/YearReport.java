import java.util.ArrayList;

public class YearReport {
    // Yellow+
    // Необязательно писать тип данных в дженериках, когда создаем коллекцию
    ArrayList<TransactionYear> transactions_year = new ArrayList<>();

    void printReportsYear(){
        for (TransactionYear transactionYear: transactions_year){
            transactionYear.printYearReport();
        }
    }
    double sumReportsYear(int monthNumber, boolean isExpense){
        for (TransactionYear transactionYear: transactions_year){
            if (transactionYear.isExpense == isExpense && monthNumber == transactionYear.month){
                return transactionYear.amount;
            }
        }
        return 0;
    }


}
