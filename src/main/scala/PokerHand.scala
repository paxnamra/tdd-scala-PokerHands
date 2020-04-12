object PokerHand {
  val figuresIndex: Map[Char, Int] = List('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A')
    .zipWithIndex
    .toMap

  def evaluate(hand: String): String = {
    val value: List[(Char, Int)] = hand
      .split(" ")
      .map { card =>
        card.toList match {
          case List(figure, _) => (figuresIndex(figure), figure)
        }
      }
      .groupBy(_._2)
      .map(t => (t._1, t._2.length))
      .toList
      .sortBy(_._2)(Ordering[Int].reverse)

    val (figure, occurrences) = value.head
    if (occurrences == 2) {
      "pair of : " + figure
    } else {
      val (_, maxChar) = value.max
      "high card : " + maxChar
    }
  }
}
