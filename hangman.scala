import scala.util.Random, scala.io.StdIn.readLine, scala.collection.mutable.ArrayBuffer

object Main:
  def pick_word: String =
    val words = Vector[String]("scala", "java", "python", "programming", "computer")
    words(Random.nextInt(words.size))

  def main(args: Array[String]): Unit = 
    val correct_word = pick_word
    var user_word = ArrayBuffer.fill(correct_word.size)("_")
    def user_joined: String = user_word.mkString(" ")
    def is_wrong(g: Char) = !correct_word.contains(g)
    var wrong_counter = 0

    println("Welcome to terminal-hangman!")
    while wrong_counter < 10 && user_word.mkString("") != correct_word do
      val user_guess = readLine("Make a guess! ").head.toChar

      if !is_wrong(user_guess) then
        for i <- 0 until correct_word.size do
          if correct_word(i) == user_guess then
            user_word(i) = user_guess.toString
      else
        wrong_counter += 1
        
      println(user_joined)

    if !(wrong_counter < 10) then
      println("You lost! The man got hanged.")
    else
      println("You won!")