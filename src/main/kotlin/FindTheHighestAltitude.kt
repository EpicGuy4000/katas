package org.kata

class FindTheHighestAltitude {
    companion object {
        fun findTheHighestAltitude(gain: List<Int>): Int  {
            var currentAltitude = gain[0]
            var currentMax = gain[0]

            for (i in 1..gain.lastIndex) {
                currentAltitude += gain[i]
                if (currentAltitude > currentMax)
                    currentMax = currentAltitude
            }

            return currentMax
        }
    }
}