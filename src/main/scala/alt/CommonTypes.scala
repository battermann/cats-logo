package alt

import cats._
import cats.data._
import cats.implicits._

import scala.concurrent.Future

object CommonTypes {
  type Error = String
  type FutureEither[A] = EitherT[Future, Error, A]

  case class Position(x: Double, y: Double, heading: Degree)
  case class Degree(private val d: Int) {
    val value = d % 360
  }
}
