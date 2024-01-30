import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    private  static PhoneBook instance = null;
    private Map<String, String> book = new TreeMap<>();

    private PhoneBook(){}

    public static PhoneBook getInstance(){
        if(instance == null){
            instance = new PhoneBook();
        }
        return instance;
    }

    public int add(String name, String number){
        if(book.containsKey(name)){
            return book.size();
        }
        book.put(name, number);
        return book.size();
    }
}
