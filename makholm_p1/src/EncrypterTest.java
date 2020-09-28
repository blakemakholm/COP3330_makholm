import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EncrypterTest {
    @Test
    void test1234to0189() {
        Encrypter e = new Encrypter();
        assertEquals("2867", e.encrypt("9051"));
    }

    @Test
    void test0189to1234() {
        Decrypter d = new Decrypter();
        assertEquals("9051", d.decrypt("2867"));
    }
}
