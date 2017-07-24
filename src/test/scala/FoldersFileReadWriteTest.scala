import java.io.{File,FileNotFoundException}

import org.scalatest.FunSuite


class FoldersFileReadWriteTest extends FunSuite {

  val fileObj = new FolderFilesReadWrite

  test("Testing read function with existing file")
  {
    val file = new File("src/test/testFiles/testRead.txt")
    assert(fileObj.read(file) == "test")
  }

  test("Testing write function with valid directory path")
  {
    val file = new File("testWrite.txt")
    assert(fileObj.write(file, "content", "src/test/testFiles"))

  }

  test("Testing read function with non-existsing file")
  {
    intercept[FileNotFoundException] {
      val file = new File("Invalid.txt")
      fileObj.read(file)

    }

  }

  test("Testing write function with invalid directory path")
  {
    val file = new File("testWrite.txt")
    intercept[FileNotFoundException] {
      fileObj.write(file, "content", "/home/Scala_03")
    }
  }

}