object Helper {
  def from(n:Long):Stream[Long] = n #:: from(n + 1)
  lazy val primes: Stream[Long] = 2L #:: from(3L).filter(i =>
    primes.takeWhile {j => j * j <= i }.forall {k => i % k > 0})
}
