package junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("junit test class")
public class JUnitTest {
  @BeforeAll
  static void initAll(){
    System.out.println("@BeforAll");
  }
  @BeforeEach
  void init(){
    System.out.println("@BeforEach");
  }
  @Test
  @DisplayName("myfirst test case")
  void normal(){
    System.out.println("test");
  
  }
  @Test
  void assertion(){
    assertEquals(2,2);
    assertEquals(3,3,"assertEquals 3=3");
    assertTrue('a'<'b',()->"message" + "mm");
    assertAll("person",
      ()->assertEquals(1,1,"assertEquals"),
      ()->assertEquals(3,3,"assertEquals")
    );
    Throwable throwable = assertThrows(IllegalArgumentException.class,
      ()->{throw new IllegalArgumentException("a message");});
    assertEquals("a message",throwable.getMessage());
    String s = assertTimeout(Duration.ofMillis(50), () -> "new");
    assertEquals("new",s);
    assertTimeoutPreemptively(Duration.ofMillis(10),()->{Thread.sleep(9);});
    assertTimeout(Duration.ofMillis(10),()->{Thread.sleep(9);});
  }
  @Test
  @Tag("hhh")
  void assume(TestInfo testInfo){
    System.out.println(testInfo);
    assumeTrue("dev".equals("dev"),()->"dev");
  }
  @Test
  @EnabledOnOs(OS.WINDOWS)
  @DisabledOnOs({OS.LINUX,OS.MAC})
  @EnabledOnJre(JRE.JAVA_11)
  @DisabledOnJre(JRE.JAVA_8)
  @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
  @DisabledIfSystemProperty(named = "ci-server", matches = "true")
//  @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
//  @EnabledIf(value = {
//    "load('nashorn:mozilla_compat.js')",
//    "importPackage(java.time)",
//    "",
//    "var today = LocalDate.now()",
//    "var tomorrow = today.plusDays(1)",
//    "tomorrow.isAfter(today)"
//  },
//    engine = "nashorn",
//    reason = "Self-fulfilling: {result}")
  void operating(){
  
  }
  @RepeatedTest(5)
  void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
    assertEquals(5, repetitionInfo.getTotalRepetitions());
  }
  @ParameterizedTest
  @ValueSource(ints = { 1, 2, 3 })
  void testWithValueSource(int argument) {
    assertTrue(argument > 0 && argument < 4);
  }
  @ParameterizedTest
  @MethodSource("stringProvider")
  void testWithSimpleMethodSource(String argument) {
    assertNotNull(argument);
  }
  
  static Stream<String> stringProvider() {
    return Stream.of("foo", "bar");
  }
  @ParameterizedTest
  @CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
  void testWithCsvSource(String first, int second) {
    assertNotNull(first);
    assertNotEquals(0, second);
  }
  @ParameterizedTest
  @CsvFileSource(resources = "/two-column.csv", numLinesToSkip = 1)
  void testWithCsvFileSource(String first, int second) {
    assertNotNull(first);
    System.out.println(first);
    assertNotEquals(0, second);
  }
  @Test
  @Disabled
  void disabled(){
    System.out.println("@Disabled");
  }
  @AfterEach
  void tearDown(){
    System.out.println("@AfterEach");
  }
  @AfterAll
  static void tearDownAll(){
    System.out.println("@AfterAll");
  }
}
