object Euler005 extends App {
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

  def primeFactors(x:Long):Map[Long, Long] = {
    def p(x:Long, primes:Stream[Long]):List[Long] = x match {
      case 1 => Nil
      case x if ( x % primes.head == 0) => primes.head :: p(x / primes.head, primes)
      case _ => p(x, primes.tail)
    }
    p(x, primes) groupBy(p => p) mapValues(_.size)
  }

  def mergeMap(m1:Map[Long, Long], m2:Map[Long, Long]) = m1 ++ m2.map { case (k,v) => k -> math.max(v, m1.getOrElse(k, 0L)) }
  def pow(a:Long, b:Long):Long = if(b == 0) 1L else a * pow(a, b - 1)

  val factorizingNumbers = (2L to 20L) map primeFactors
  val maxFactorMap = (Map[Long, Long]() /: factorizingNumbers) (mergeMap(_,_))
  println((1L /: maxFactorMap) ( (a,b) => a * pow(b._1, b._2)))
}
