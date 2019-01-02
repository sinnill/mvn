import org.junit.Test;
import static org.junit.Assert.*;

public class JLibTest {
    @Test public void testSomeLibraryMethod() {
        JLib classUnderTest = new JLib();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
}