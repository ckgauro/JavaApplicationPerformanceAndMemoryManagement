import java.util.*
import kotlin.math.sqrt

fun isPrime(testNumber : Int) : Boolean {
    val maxToCheck = sqrt(testNumber.toDouble()).toInt()
    for (i in 2..maxToCheck) {
        if (testNumber % i == 0) return false
    }
    return true
}

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val start = System.currentTimeMillis()

            //generate 500k random UUIDs
            val uuids = mutableListOf<UUID>()
            for (i in 0 until 500000) {
                uuids.add(UUID.randomUUID())
            }

            println("UUIDs generated")

            //extract the integer parts - using a set to avoid duplicates
            val numbersFromUUIDs = mutableSetOf<Int>()
            for (uuid in uuids) {
                var numberFromUuid = uuid.toString().replace(Regex("[^0-9]"), "")
                if (numberFromUuid.length > 9) {
                    numberFromUuid = numberFromUuid.substring(0, 9)
                }

                numbersFromUUIDs.add(Integer.parseInt(numberFromUuid))
            }

            println("Integers generated")

            //find the primes
            val primes = mutableListOf<Int>()
            for (i in numbersFromUUIDs) {
                if (isPrime(i)) {
                    primes.add(i)
                }
            }

            println("${primes.size} primes found.");

            println("The largest prime was ${primes.max()}")

            val stop = System.currentTimeMillis()
            System.out.println("time taken : ${stop - start}  ms.")
        }
    }
}