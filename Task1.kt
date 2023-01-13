package task1

import java.io.File

fun main() {
    val file = File("D:\\KPI\\lab14\\src\\task1\\fileTask1.txt")
    val strToMatch = "123"
    val strToReplace = "3218769"
    var fileText = ""
    file.forEachLine { line ->
        fileText += "$line\n"
    }
    file.printWriter().use { writer ->
        writer.println(fileText.replace(strToMatch, strToReplace))
    }
}