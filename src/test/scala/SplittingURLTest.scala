import java.io.{File, FileNotFoundException}
import org.scalatest.FunSuite



class SplittingURLTest extends FunSuite {

  val splitURLObj = new SplittingURL
  val ReadWriteObj = new FolderFilesReadWrite

  test("Testing with URL with Query Parameters")
  {
    splitURLObj.splitFile("src/test/testFiles/URLWithQueryParams.txt", "src/test/SplittingURLOutput")
    val file = new File("src/test/SplitURLOutput/URLWithQueryParams.txt")
    assert(ReadWriteObj.read(file) == "Protocol -> https \n Host -> google \n " +
      "Domain -> co.in \n Query Params -> Map(gfe_rd -> cr)")
  }

  test("Testing splitting URL File with invalid input path")
  {
    intercept[FileNotFoundException]
      {
        splitURLObj.splitFile("/invalid", "src/test/SplitURLOutput")
      }
  }

  test("Testing splitFile with invalid output path")
  {
    intercept[FileNotFoundException] {
      splitURLObj.splitFile("src/test/testFiles/URLs.txt", "/home/knoldus")
    }
  }

  test("Testing with invalid URL")
  {
    splitURLObj.splitFile("src/test/testFiles/invalidURL.txt", "src/test/SplitURLOutput")
    val file = new File("src/test/SplitURLOutput/invalidURL.txt")
    val str = ReadWriteObj.read(file)
    assert(str == "Invalid URL Address \n ")
  }

  test("Testing with URL with Query Parameters")
  {
    splitURLObj.splitFile("src/test/testFiles/URLWithQueryParams.txt", "src/test/SplitURLOutput")
    val file = new File("src/test/SplitURLOutput/URLWithQueryParams.txt")
    assert(ReadWriteObj.read(file) == "Protocol -> https \n Host -> google \n " +
      "Domain -> co.in \n Query Params -> Map(gfe_rd -> cr) ")
  }

  test("Testing with URL without Query Parameters")
  {
    splitURLObj.splitFile("src/test/testFiles/URLWithoutQueryParams.txt", "src/test/SplitURLOutput")
    val file = new File("src/test/SplitURLOutput/URLWithoutQueryParams.txt")
    assert(ReadWriteObj.read(file) == "Protocol -> https\nHost -> google\nDomain -> com\n")
  }

  test("Testing splitFile with collection of different URLs")
  {
    assert(splitURLObj.splitFile("src/test/testFiles/URLs.txt", "src/test/SplitURLOutput"))
  }

}