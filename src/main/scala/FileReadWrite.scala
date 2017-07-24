import java.io.File

trait FileReadWrite {

  def read(filename: File): String

  def write(filename: File, data: String, directoryPath: String): Boolean
}