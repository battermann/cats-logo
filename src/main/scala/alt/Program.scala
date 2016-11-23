package alt

import alt.CommonTypes.{Degree, Position}
import cats.Monad
import cats._
import cats.data._
import cats.implicits._
import scala.concurrent.ExecutionContext.Implicits.global

object Program extends App {

  def program[M[_] : Monad](logoApi: logo.Api[M], penApi: pen.Api[M])(start: Position): M[Unit] = {
    for {
      p1 <- logoApi.forward(start, 10)
      p2 <- logoApi.rotateRight(p1, Degree(90))
      _ <- penApi.pencilUp(p2)
      p3 <- logoApi.forward(p2, 10)
      _ <- penApi.pencilDown(p3)
      p4 <- logoApi.backward(p3, 20)
      _ <- logoApi.showPosition(p4)
    } yield ()
  }

  val startPosition = Position(0.0, 0.0, Degree(0))
  val (logoApi, penApi) = (logo.Implementations.idApi, pen.Implementations.idApi)
//  val (logoApi, penApi) = (logo.Implementations.futureEitherApi, pen.Implementations.futureEitherApi)

  program(logoApi, penApi)(startPosition)
}

