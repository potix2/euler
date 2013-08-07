object Euler009 extends App {
  //a + b + c = 1000 and a < b < c
  val triplets = for {
    a <- 1 to 1000
    b <- a to 1000
    c <- b to 1000
    if (a + b + c == 1000) && (a * a + b * b == c * c)
  } yield a * b * c

  println(triplets)
}
