import java.io.File

class FileDataToUppercase extends FolderFilesReadWrite {

  def ConvertToUpperCase(inputPath: String, outputPath: String, fileExtension: String): Boolean = {

    val fileList = fileExtension match {
      case "all" => new File(inputPath).listFiles().toList

      case _ => {
        val fileListCheck = new File(inputPath).listFiles().filter(f => f.getName.endsWith(fileExtension)).toList

        if(fileListCheck.isEmpty)
        {
          throw new Exception("File Does exist.!!")
        }
        else
        {
          fileListCheck
        }
      }
    }

    val fileContentList = fileList.map(read(_)).map(_.toUpperCase())

    val fileContentTupleList = fileList.zip(fileContentList)

    val checkResult = fileContentTupleList.map(t=>write(t._1,t._2,outputPath))

    if(checkResult.contains(false))
    {
      false
    }
    else
    {
      true
    }
  }


}