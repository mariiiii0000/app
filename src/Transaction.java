public class Transaction {
    String name;
    boolean isExpense;
    int quantity;
    double priceOf1;

    Transaction(String name, boolean isExpense, int quantity, double priceOf1){
        this.name = name;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.priceOf1 = priceOf1;
    }
    void printMonthReport(){
        System.out.println("Name - " + name);
        System.out.println("Expense - " + isExpense);
        System.out.println("Amount - " + quantity);
        System.out.println("Price of one - " + priceOf1);

    }


}
