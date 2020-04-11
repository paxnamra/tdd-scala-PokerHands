object PokerHand {

  def evaluate(hand: String): String = {
    val (_, maxChar) = hand
      .split(" ")
      .map { card =>
        card.toList match {
          case List('T', _) => (10, 'T')
          case List('J', _) => (11, 'J')
          case List('Q', _) => (12, 'Q')
          case List(figure, _) => (figure.toString.toInt, figure)
        }
      }
      .max
    "high card : " + maxChar
  }
}
