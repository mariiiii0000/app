import java.util.ArrayList;

public class MonthReport {
    // Yellow
    // Необязательно писать тип данных в дженериках, когда создаем коллекцию
    ArrayList<Transaction> transactions_month = new ArrayList<Transaction>();

    void printReportsMonth(){
        for (Transaction transaction : transactions_month) {
            transaction.printMonthReport();


        }

    }
    double sumReportsMonth(boolean isExpense){
        double sum = 0;
        for (Transaction transaction : transactions_month){
            if (transaction.isExpense == isExpense){
                sum += transaction.priceOf1 * transaction.quantity;

            }

        }
        return sum;
    }

}

