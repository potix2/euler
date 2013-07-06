object Euler001 extends App {
  def answer(n: Int): Int = (1 to (n - 1))
    .filter(x => (x % 5 == 0) || (x % 3 == 0))
    .foldLeft(0) { _ + _ }

  println(answer(1000))
}