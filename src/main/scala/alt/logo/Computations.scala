package alt.logo

import alt.CommonTypes.{Degree, Position}

import scala.math.{cos, sin}

object Computations {
  def forward(pos: Position, l: Int): Position = pos.copy(
    x = pos.x + l * cos(pos.heading.value * math.Pi / 180.0),
    y = pos.y + l * sin(pos.heading.value * math.Pi / 180.0))

  def backward(pos: Position, l: Int): Position = pos.copy(
    x = pos.x - l * cos(pos.heading.value * math.Pi / 180.0),
    y = pos.y - l * sin(pos.heading.value * math.Pi / 180.0))

  def left(pos: Position, d: Degree): Position = pos.copy(
    heading = Degree(pos.heading.value + d.value))

  def right(pos: Position, d: Degree): Position = pos.copy(
    heading = Degree(pos.heading.value - d.value))
}
