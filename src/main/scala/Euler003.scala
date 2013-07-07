import Helper.primes

object Euler003 extends App {
  def primeFactors(x:Long):List[Long] = {
    def p(x:Long, primes:Stream[Long]):List[Long] = x match {
      case 1 => Nil
      case x if ( x % primes.head == 0) => primes.head :: p(x / primes.head, primes)
      case _ => p(x, primes.tail)
    }
    p(x, primes)
  }

  primeFactors(600851475143L) foreach println
}
