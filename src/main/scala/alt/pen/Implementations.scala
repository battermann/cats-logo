package alt.pen

import alt.CommonTypes._
import cats._
import cats.data._
import cats.implicits._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Implementations {
  def idApi: Api[Id] = {
    val up: Position => Id[Unit] = p => println(s"start drawing at $p")
    val down: Position => Id[Unit] = p => println(s"stop drawing at $p")

    Api[Id](up, down)
  }

  def futureEitherApi: Api[FutureEither] = {
    val up: Position => FutureEither[Unit] = p => EitherT[Future, Error, Unit](Future.successful(Right(println(s"stop drawing at $p"))))
    val down: Position => FutureEither[Unit] = p => EitherT[Future, Error, Unit](Future.successful(Right(println(s"start drawing at $p"))))

    Api[FutureEither](up, down)
  }
}
