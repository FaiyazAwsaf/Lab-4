import java.io.*;
import java.util.*;

public class CsvTransactionParser implements TransactionParser {
    @Override
    public List<Transaction> parse(String filePath) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String date = values[0].trim();
                double amount = Double.parseDouble(values[1].trim());
                String description = values[2].trim();
                transactions.add(new Transaction(date, amount, description));
            }
        }
        return transactions;
    }
}
