import java.util.*;
import java.util.stream.Collectors;

public class BankTransactionAnalyzer {
    private List<Transaction> transactions;

    public BankTransactionAnalyzer(TransactionParser parser, String filePath) throws Exception {
        this.transactions = parser.parse(filePath);
    }

    public void calculateProfit() {
        double totalAmount = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
        if (totalAmount > 0) {
            System.out.println("Profit: " + totalAmount);
        } else {
            System.out.println("Loss: " + Math.abs(totalAmount));
        }
    }

    public void transactionsInMonth(String monthYear) {
        long transactionCount = transactions.stream()
                .filter(t -> t.getDate().substring(3).equals(monthYear))
                .count();
        System.out.println("Number of transactions in " + monthYear + ": " + transactionCount);
    }

    public void topExpenses() {
        List<Double> topExpenses = transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .map(t -> Math.abs(t.getAmount()))
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("Top 10 expenses: " + topExpenses);
    }

    public void highestExpenditure() {
        Map<String, Double> categorySpending = transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .collect(Collectors.groupingBy(Transaction::getDescription,
                        Collectors.summingDouble(Transaction::getAmount)));

        String highestCategory = Collections.min(categorySpending.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Category with the highest expenditure: " + highestCategory);
    }
}
