package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0
    var wrongPosition = 0
    val secretLetters = secret.toCharArray()
    val guessLetters = guess.toCharArray()

    // Check for letters that are right and in the right position
    for (i in secretLetters.indices) {
        if (secretLetters[i] == guessLetters[i]) {
            rightPosition++
            secretLetters[i] = ' ' // Mark the letter as already matched
            guessLetters[i] = ' ' // Mark the letter as already matched
        }
    }

    // Check for letters that are right but in the wrong position
    for (i in secretLetters.indices) {
        val currentLetter = secretLetters[i]
        if (currentLetter != ' ' && guessLetters.contains(currentLetter)) {
            wrongPosition++
            secretLetters[i] = ' ' // Mark the letter as already matched
            guessLetters[guessLetters.indexOf(currentLetter)] = ' ' // Mark the letter as already matched
        }
    }

    return Evaluation(rightPosition, wrongPosition)
}
