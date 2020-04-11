object PokerHand {

  def evaluate(hand: String): String = {
    val max = hand
      .split(" ")
      .map(_.toList)
      .map {
        case List(figure, color) => figure.toString.toInt
      }
      .max
    "high card : " + max
  }
}
