object Euler006 extends App {
  def sumSquareDifference(n:Int) = {
    val squareSum = (1 to n) map(x => x * x) sum
    val s = (1 to n) sum

    s * s - squareSum
  }

  println(sumSquareDifference(100))
}
