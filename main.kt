import kotlin.system.exitProcess
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.Scanner

class Math(var int1: Int, var int2: Int) {
    fun add() : Int {
        var sum = int1 + int2
        return sum
    }

    fun subtract() : Int {
        var difference = int1 - int2
        return difference
    }

    fun multiply() : Int{
        var product = int1 * int2
        return product
    }

    fun divide() : Double {
        var quotient: Double = int1.toDouble() / int2.toDouble()

        // https://www.techiedelight.com/round-up-a-float-or-a-double-with-2-decimal-places-in-kotlin/
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        quotient = df.format(quotient).toDouble()
        //

        return quotient
    }
}

fun clear() {
    // https://stackoverflow.com/a/46436390
    print("\u001b[H\u001b[2J")
}

fun main() {
    /*
    val math = Math(1, 3)
    println(math.divide())
    
    
    // Creates an instance which takes input from standard input (keyboard)
    
    print("Enter a number: ")

    // nextInt() reads the next integer from the keyboard
    var integer:Int = reader.nextInt()
    println(integer)
    */
    clear()
    print("""
Choose an operation:
    Add (+)
    Subtract (-)
    Multiply (*)
    Divide (/)

Operation>>> """)
    // https://www.programiz.com/kotlin-programming/input-output
    var operation = readLine()!!

    /*
    val mon = "Sunday"
    val month = when(mon) {
    "Jan", "Feb", "Mar" -> "First Quarter"
    "Apr", "May", "June" -> "Second half"
    else -> "Half quarter end"
    }
    Println ("mon is $month")
    */
    
    // https://www.educba.com/kotlin-when-multiple-conditions/
    var valid: Boolean = when(operation) {
        "+", "-", "*", "/" -> true
        else -> false
    }
    if (valid == false) {
        println("Invalid operation, \"$operation\"")

        // https://programming-idioms.org/idiom/87/stop-program/4789/kotlin
        exitProcess(0)
    }

    clear()
    println("You selected, $operation")
    print("What is the 1st Int? >>> ")

    val reader = Scanner(System.`in`)
    var int1: Int = reader.nextInt()

    print("What is the 2nd Int? >>> ")
    var int2: Int = reader.nextInt()

    val math = Math(int1, int2)
    clear()
    
    if (operation == "+") {
        println("$int1 + $int2 = ${math.add()}")
    } else if (operation == "-") {
        println("$int1 - $int2 = ${math.subtract()}")
    } else if (operation == "*") {
        println("$int1 * $int2 = ${math.multiply()}")
    } else if (operation == "/") {
        println("$int1 / $int2 = ${math.divide()}")
    } else {
        println("Something went wrong!")
    }
}