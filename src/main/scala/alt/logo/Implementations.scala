package alt.logo

import alt.CommonTypes.{Degree, FutureEither, Position, Error}
import cats.Id
import cats.data.EitherT
import cats._
import cats.data._
import cats.implicits._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Implementations {

  def idApi: Api[Id] = {
    val forward: (Position, Int) => Id[Position] = (p, l) => Computations.forward(p, l)
    val backward: (Position, Int) => Id[Position] = (p, l) => Computations.backward(p, l)
    val rotateRight: (Position, Degree) => Id[Position] = (p, d) => Computations.right(p, d)
    val rotateLeft: (Position, Degree) => Id[Position] = (p, d) => Computations.left(p, d)
    val showPosition: (Position) => Id[Unit] = p => println(s"showing position $p")

    Api[Id](forward, backward, rotateRight, rotateLeft, showPosition)
  }

  def futureEitherApi: Api[FutureEither] = {
    val forward: (Position, Int) => FutureEither[Position] = (p, l) => EitherT[Future, Error, Position](Future.successful(Right(Computations.forward(p, l))))
    val backward: (Position, Int) => FutureEither[Position] = (p, l) => EitherT[Future, Error, Position](Future.successful(Right(Computations.backward(p, l))))
    val rotateRight: (Position, Degree) => FutureEither[Position] = (p, d) => EitherT[Future, Error, Position](Future.successful(Right(Computations.right(p, d))))
    val rotateLeft: (Position, Degree) => FutureEither[Position] = (p, d) => EitherT[Future, Error, Position](Future.successful(Right(Computations.left(p, d))))
    val showPosition: (Position) => FutureEither[Unit] = p => EitherT[Future, Error, Unit](Future.successful(Right(println(s"showing position $p"))))

    Api[FutureEither](forward, backward, rotateRight, rotateLeft, showPosition)
  }
}
