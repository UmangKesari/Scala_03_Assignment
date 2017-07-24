import org.scalatest.FunSuite

class FileDataToUppercaseTest extends FunSuite {

  val toUppercaseData = new FileDataToUppercase

  test("Testing upperCase for all extensions")
  {
    assert(toUppercaseData.ConvertToUpperCase("src/test/testFiles", "src/test/CapitalizeOutput", "all"))

  }

  test("Testing upperCase for selected extensions")
  {
    assert(toUppercaseData.ConvertToUpperCase("src/test/testFiles", "src/test/CapitalizeOutput", ".log"))

  }

  test("Testing upperCase for invalid extension")
  {
    intercept[Exception]
      {
        toUppercaseData.ConvertToUpperCase("src/test/testFiles", "src/test/CapitalizedOutput", ".invalid")
      }

  }

}
