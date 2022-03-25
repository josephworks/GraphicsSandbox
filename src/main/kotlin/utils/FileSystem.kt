package utils

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

object FileSystem
{

    fun read(file: File): String
    {
        val stringBuilder = StringBuilder()
        val fileInputStream = FileInputStream(file)
        val bufferedReader = BufferedReader(InputStreamReader(fileInputStream))

        var line: String

        while (bufferedReader.readLine().also { line = it } != null) stringBuilder.append(line).append('\n')

        return stringBuilder.toString()
    }

}