//import java.io.FileNotFoundException
//
//import java.nio.file.NoSuchFileException

import org.scalatest.FunSuite



class UniqueWordsInFileTest extends FunSuite {

  val uniqueWordsObj = new UniqueWordsInFile

  test("Testing uniqueWords with valid path")
  {
    assert(uniqueWordsObj.countUniqueWordsFileList("src/test/testFiles", "src/test/WordCountOutput"))
  }

  test("Testing uniqueWords with invalid path")
  {
    intercept[NullPointerException]
      {
        uniqueWordsObj.countUniqueWordsFileList("/home/invalid", "src/test/testFiles/UniqueWordsCountOutput")
      }
  }

}