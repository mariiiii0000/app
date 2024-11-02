// Red++
// Не принято использовать в названии переменных, классов и методов нижние подчеркивания
// Какой-то imposter из питона получается)(((((((((((((((((((((((
// YearTransaction
public class TransactionYear {
    int month;
    int amount;
    boolean isExpense;

    TransactionYear(int month, int amount, boolean isExpense){
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
