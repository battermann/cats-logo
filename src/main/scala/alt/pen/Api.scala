package alt.pen

import alt.CommonTypes.Position
import cats.Monad

case class Api[M[_]: Monad](
   pencilUp: Position => M[Unit],
   pencilDown: Position => M[Unit])
