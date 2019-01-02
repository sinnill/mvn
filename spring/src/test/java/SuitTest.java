import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.*;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectPackages("one")
@SelectClasses(one.JUnit.class)
//@IncludePackages("one")
public class SuitTest {
}