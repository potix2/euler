object Euler004 extends App {
  def isPalindrome(n:Int):Boolean = {
    val s:String = n.toString()
    s.take(s.length() / 2) == s.takeRight(s.length() / 2).reverse
  }

  assert(isPalindrome(1221))
  assert(isPalindrome(1))
  assert(!isPalindrome(1234))
  assert(isPalindrome(12321))

  def threeDigitsNumberProducts():Seq[Int] = for {
    i <- 100 to 999
    j <- 100 to 999
  } yield i * j

  threeDigitsNumberProducts filter isPalindrome sortWith(_ > _) foreach println
}
