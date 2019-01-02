import org.junit.Assert.assertEquals
import org.junit.Test

class KLibTest {
    @Test fun testMyLanguage() {
        assertEquals("KLib", KLib().kotlinLanguage().name)
        assertEquals(10, KLib().kotlinLanguage().hotness)
    }
}