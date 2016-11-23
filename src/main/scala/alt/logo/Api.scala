package alt.logo

import alt.CommonTypes.{Degree, Position}
import cats.Monad

case class Api[M[_]: Monad](
   forward: (Position, Int) => M[Position],
   backward: (Position, Int) => M[Position],
   rotateRight: (Position, Degree) => M[Position],
   rotateLeft: (Position, Degree) => M[Position],
   showPosition: Position => M[Unit])
