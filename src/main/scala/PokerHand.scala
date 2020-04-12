object PokerHand {

  def evaluate(hand: String): String = {
    val figuresIndex: Map[Char, Int] = List('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K')
      .zipWithIndex
      .toMap
    val (_, maxChar) = hand
      .split(" ")
      .map { card =>
        card.toList match {
          case List(figure, _) => (figuresIndex(figure), figure)
        }
      }
      .max
    "high card : " + maxChar
  }
}
