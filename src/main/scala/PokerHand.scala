object PokerHand {

  def evaluate(hand: String): String = {
    val (_, maxChar) = hand
      .split(" ")
      .map(_.toList)
      .map {
        case List('J', _) => (11, 'J')
        case List(figure, color) => (figure.toString.toInt, figure)
      }
      .max
    "high card : " + maxChar
  }
}
