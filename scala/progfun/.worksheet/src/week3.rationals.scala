package week3

object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  val x = new Rational(1, 3);System.out.println("""x  : week3.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : week3.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : week3.Rational = """ + $show(z ));$skip(9); val res$0 = 

  x + y;System.out.println("""res0: week3.Rational = """ + $show(res$0));$skip(13); val res$1 = 

  x - y - z;System.out.println("""res1: week3.Rational = """ + $show(res$1));$skip(9); val res$2 = 

  y + y;System.out.println("""res2: week3.Rational = """ + $show(res$2));$skip(9); val res$3 = 

  x < y;System.out.println("""res3: Boolean = """ + $show(res$3));$skip(11); val res$4 = 

  x max y;System.out.println("""res4: week3.Rational = """ + $show(res$4));$skip(19); val res$5 = 

  new Rational(2);System.out.println("""res5: week3.Rational = """ + $show(res$5))}
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be positive")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)

  def numer = x / g
  def denom = y / g

  def <(that: Rational) = this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) = if (this < that) that else this

  def +(that: Rational) = new Rational(this.numer * that.denom + that.numer * this.denom, this.denom * that.denom)

  def unary_- : Rational = new Rational(-this.numer, this.denom)

  def -(that: Rational) = this + -that

  override def toString = this.numer + "/" + this.denom
}
