object Euler002 extends App {
  lazy val fibs = {
    def f(a:Long, b:Long):Stream[Long] = a #:: f(b, a+b)
    f(0,1)
  }

  def even(x:Long) = x % 2 == 0

  val evenFibs = fibs filter even
  println(evenFibs takeWhile (_ < 4000000) sum)
}
