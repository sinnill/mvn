import org.testng.annotations.Test;

public class TestDBConnection {
  
  @Test
  public void runOtherTest1() {
    System.out.println("@Test - runOtherTest1");
  }
  
  @Test
  public void runOtherTest2() {
    System.out.println("@Test - runOtherTest2");
  }
  @Test(expectedExceptions = ArithmeticException.class)
  public void divisionWithException() {
    int i = 1 / 0;
    System.out.println("After division the value of i is :"+ i);
  }
  
}