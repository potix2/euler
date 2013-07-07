object Euler001 extends App {
  val answer = 1 to 999 filter(x => (x % 5 == 0) || (x % 3 == 0)) sum

  println(answer)
}