package org.kata

class PrimesIterator: Iterator<Int> {
    private var current = 1

    override fun hasNext(): Boolean {
        current++

        while (!Primes.isPrime(current)) current++

        return true
    }

    override fun next(): Int = current
}

class Primes: Iterable<Int> {
    companion object {
        fun isPrime(n: Int): Boolean {
            if (n <= 1) return false
            if (n <= 3) return true

            // This is checked so that we can skip
            // middle five numbers in below loop
            if (n % 2 == 0 || n % 3 == 0) return false

            var i = 5
            while (i * i <= n) {
                if (n % i == 0 || n % (i + 2) == 0) return false
                i += 6
            }

            return true
        }
    }

    override fun iterator(): Iterator<Int> = PrimesIterator()
}

class PrimesInNumbers {
    companion object {
        fun decompose(input: Int): Map<Int, Int> {
            val factorized = mutableMapOf<Int, Int>()

            var current = input
            for (prime in Primes()) {
                if (current == 1) break

                var factor = 0

                while (current % prime == 0) {
                    factor++
                    current /= prime
                }

                if (factor != 0) {
                    factorized[prime] = factorized.getOrDefault(prime, 0) + factor
                }
            }

            return factorized
        }
    }

}
