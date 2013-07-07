object Euler003 extends App {
  lazy val nats = {
    def succ(n:Long):Stream[Long] = n #:: succ(n+1)
    succ(2)
  }

  lazy val primes = {
    def sieve(ls:Stream[Long]):Stream[Long] = {
      lazy val h = ls.head
      h #:: sieve(ls filter (_ % h > 0))
    }
    sieve(nats)
  }

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
