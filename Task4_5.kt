package task4_5

import java.io.File
import java.lang.Exception
import java.util.*

const val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
const val shiftKey = 5

fun main() {
    val file = File("D:\\KPI\\lab14\\src\\task4_5\\fileToCipher.txt")
    val scanner = Scanner(System.`in`)
    var cipher = ""
    println("Select option: ")
    println("1.Encrypt file")
    println("2.Decrypt file")
    try {
        when (scanner.nextInt()) {
            1 -> {
                file.forEachLine { line ->
                    cipher += "${encrypt(line)}\n"
                }
                file.printWriter().use { writer ->
                    writer.println(cipher)
                }
            }
            2 -> {
                file.forEachLine { line ->
                    cipher += "${decrypt(line)}\n"
                }
                file.printWriter().use { writer ->
                    writer.println(cipher)
                }
            }
        }
    } catch (e: Exception) {
        println("Incorrect input data")
        return
    }
}

fun encrypt(textToEncrypt: String): String {
    var cipherText = ""
    for (element in textToEncrypt) {
        val charPosition: Int = alphabet.indexOf(element)
        val keyVal = (shiftKey + charPosition) % 62
        val replaceVal = alphabet[keyVal]
        cipherText += replaceVal
    }
    return cipherText
}

fun decrypt(textToDecrypt: String): String {
    var decipherText = ""
    for (element in textToDecrypt) {
        val charPosition: Int = alphabet.indexOf(element)
        var keyVal = (charPosition - shiftKey) % 62
        if (keyVal < 0) {
            keyVal += alphabet.length
        }
        val replaceVal = alphabet[keyVal]
        decipherText += replaceVal
    }
    return decipherText
}