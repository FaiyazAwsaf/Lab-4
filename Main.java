public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = "src/transactions.csv";
        TransactionParser parser;

        // Choose parser based on file extension
        if (filePath.endsWith(".csv")) {
            parser = new CsvTransactionParser();
        } else if (filePath.endsWith(".json")) {
            parser = new JsonTransactionParser();
        } else if (filePath.endsWith(".xml")) {
            parser = new Js
        } else {
            throw new IllegalArgumentException("Unsupported file format");
        }

        BankTransactionAnalyzer analyzer = new BankTransactionAnalyzer(parser, filePath);
        analyzer.calculateProfit();
        analyzer.transactionsInMonth("02-2017");
        analyzer.topExpenses();
        analyzer.highestExpenditure();
    }
}
