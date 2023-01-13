package task3

import java.io.File

fun main() {
    val file = File("D:\\KPI\\lab14\\src\\task3\\fileTask3.txt")
    val firstFile = File("D:\\KPI\\lab14\\src\\task3\\firstFile.txt")
    val secondFile = File("D:\\KPI\\lab14\\src\\task3\\secondFile.txt")
    var counter = 1
    firstFile.printWriter().use { writer ->
        file.forEachLine { line ->
            if(counter % 2 == 1) {
                writer.println(line)
            }
            counter++
        }
    }
    counter = 1
    secondFile.printWriter().use { writer ->
        file.forEachLine { line ->
            if(counter % 2 == 0) {
                writer.println(line)
            }
            counter++
        }
    }
}
