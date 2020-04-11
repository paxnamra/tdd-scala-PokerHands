object PokerHand {

  def evaluate(hand: String): String = {
    val (_, maxChar) = hand
      .split(" ")
      .map { card =>
        card.toList match {
          case List('J', _) => (11, 'J')
          case List(figure, _) => (figure.toString.toInt, figure)
        }
      }
      .max
    "high card : " + maxChar
  }
}
