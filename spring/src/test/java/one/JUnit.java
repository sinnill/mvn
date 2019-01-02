package one;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("junit test class")
public class JUnit {
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
    assertEquals(1,2);
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
