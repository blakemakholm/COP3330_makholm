import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {
    @Test
    void test_getBmi(){
        BodyMassIndex a = new BodyMassIndex(74, 175);
        assertEquals(22.466216216216218, a.getBmi());
        // every other test inadvertently tests the getBmi() method, but this does specifically.
    }

    //Testing the bmi calculations for each category
    @Test
    void test_BodyMassIndex_underWeight(){
        BodyMassIndex a = new BodyMassIndex(79, 160);
        assertEquals(18.022752763980133, a.getBmi());
    }

    @Test
    void test_BodyMassIndex_normalWeight(){
        BodyMassIndex a = new BodyMassIndex(74, 175);
        assertEquals(22.466216216216218, a.getBmi());
    }

    @Test
    void test_BodyMassIndex_overWeight(){
        BodyMassIndex a = new BodyMassIndex(69, 190);
        assertEquals(28.0550304557866, a.getBmi());
    }

    @Test
    void test_BodyMassIndex_obese(){
        BodyMassIndex a = new BodyMassIndex(55, 170);
        assertEquals(39.50743801652893, a.getBmi());
    }

    //Testing the categories
    @Test
    void test_getCategory_underWeight(){
        BodyMassIndex a = new BodyMassIndex(79, 160);
        assertEquals("underweight", a.getCategory(a.getBmi()));
    }

    @Test
    void test_getCategory_normalWeight(){
        BodyMassIndex a = new BodyMassIndex(74, 175);
        assertEquals("normal weight", a.getCategory(a.getBmi()));
    }

    @Test
    void test_getCategory_overWeight(){
        BodyMassIndex a = new BodyMassIndex(69, 190);
        assertEquals("overweight", a.getCategory(a.getBmi()));
    }

    @Test
    void test_getCategory_obese(){
        BodyMassIndex a = new BodyMassIndex(55, 170);
        assertEquals("obese", a.getCategory(a.getBmi()));
    }
}