import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class PhoneBookTest {

    @BeforeAll
    static void beforeAll(){
        PhoneBook phoneBook = PhoneBook.getInstance();
        phoneBook.book.put("Vasya", "+79124688544");
        phoneBook.book.put("Olya", "+79129678544");
        phoneBook.book.put("Kolya", "+79194689544");
        phoneBook.book.put("Masha", "+79084671324");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Petya, +79194691234, 5",
            "Katya, +79084561234, 6",
            "Anya, +79129463754, 7",
            "Petya, +79123758473, 7",
            "Masha, +79084671324, 7",
            "Artem, +79198352946, 8",
    })
    void addTest(String name, String number, int result){
        PhoneBook phoneBook = PhoneBook.getInstance();
        int actual = phoneBook.add(name, number);
        Assertions.assertEquals(actual, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "+79194689544, Kolya",
            "+79129678544, Olya",
            "+79084671324, Masha",
            "+79124688544, Vasya"
    })
    void findByNumberTest(String number, String name){
        PhoneBook phoneBook = PhoneBook.getInstance();
        String actual = phoneBook.findByNumber(number);
        Assertions.assertEquals(actual, name);
    }

}
