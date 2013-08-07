import Helper.primes

object Euler010 extends App {
  println(primes.takeWhile(_ < 2000000).sum)
}
