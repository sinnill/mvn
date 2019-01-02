import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SLibSuite extends FunSuite {
  test("someLibraryMethod is always true") {
    def library = new JLib()
    assert(library.someLibraryMethod)
  }
}