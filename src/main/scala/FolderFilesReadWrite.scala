import java.io.{File, PrintWriter}

import scala.io.Source.fromFile

  class FolderFilesReadWrite extends FileReadWrite{

    override def read(f: File): String = {

      fromFile(f).getLines.mkString("\n")

    }

    override def write(filename: File, data: String, directoryPath: String): Boolean = {

      new File(directoryPath).mkdir()
      val printWriter = new PrintWriter(directoryPath + "/" + filename.getName)
      try {

        printWriter.write(data)
        true

      }
      catch{

        case exc: Exception =>println("Error in read / Write to File " + exc)
                              false

      }
      finally {

        printWriter.close()

      }
    }

  }

}
