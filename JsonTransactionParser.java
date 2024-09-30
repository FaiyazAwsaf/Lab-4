import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class JsonTransactionParser implements TransactionParser {
    @Override
    public List<Transaction> parse(String filePath) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
//        ObjectMapper mapper = new ObjectMapper();
//        Transaction[] transactionsArray = mapper.readValue(new File(filePath), Transaction[].class);
        return transactions;
    }
}
