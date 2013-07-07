object Euler005 extends App {
  def gcd(a:Long, b:Long):Long = if( a % b == 0 ) b else gcd(b, a % b)
  val answer = (1L to 20L) reduce {(a,v) => a * v / gcd(a,v) }

  println(answer)
}
