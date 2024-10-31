public class Transaction_year {
    int month;
    int amount;
    boolean isExpense;

    Transaction_year(int month, int amount, boolean isExpense){
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;


    }
    void printYearReport(){
        System.out.println("Month - " + month);
        System.out.println("Amount - " + amount);
        System.out.println("Expense - " + isExpense);
    }
}
