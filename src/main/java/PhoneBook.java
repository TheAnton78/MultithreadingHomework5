import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    private  static PhoneBook instance = null;
    public Map<String, String> book = new TreeMap<>(Comparator.naturalOrder());

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

    public String findByNumber(String number){
        BiMap<String, String> biMap = HashBiMap.create(book);
        return biMap.inverse().get(number);
    }

    public String findByName(String name){
        return book.get(name);
    }

    public void printAllNames(){

    }
}
