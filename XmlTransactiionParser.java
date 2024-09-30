import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlTransactiionParser implements TransactionParser{
    @Override
    public List<Transaction> parse(String filePath) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
//        ObjectMapper mapper = new ObjectMapper();
//        Transaction[] transactionsArray = mapper.readValue(new File(filePath), Transaction[].class);
        return transactions;
    }
}