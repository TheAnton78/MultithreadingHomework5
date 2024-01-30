import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class PhoneBookTest {

    @ParameterizedTest
    @CsvSource(value = {
            "Petya, +79194691234, 1",
            "Katya, +79084561234, 2",
            "Anya, +79129463754, 3",
            "Petya, +79123758473, 3",
            "Masha, +79084671324, 4",
            "Artem, +79198352946, 5",
    })
    void addTest(String name, String number, int result){
        PhoneBook phoneBook = PhoneBook.getInstance();
        int actual = phoneBook.add(name, number);
        Assertions.assertEquals(actual, result);
    }
}
