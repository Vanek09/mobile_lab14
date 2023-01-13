package task2

import java.io.File

fun main() {
    val file = File("D:\\KPI\\lab14\\src\\task2\\fileText2.txt")
    print("Enter name for file: ")
    val fileName = readLine()
    val tempFile = File("D:\\KPI\\lab14\\src\\task2\\$fileName.bak")
    tempFile.printWriter().use { writer ->
        file.forEachLine { line ->
            writer.println(line)
        }
    }
}
