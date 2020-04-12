object PokerHand {
  val figuresIndex: Map[Char, Int] = List('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A')
    .zipWithIndex
    .toMap

  case class Card(figure: Char, power: Int)
  case class CardOccurrence(occurrence: Int, cardPower: Int, figure: Char)

  implicit val cardOccurrenceOrdering: Ordering[CardOccurrence] =
  Ordering.by[CardOccurrence, (Int, Int)](co => (co.occurrence, co.cardPower)).reverse

  def evaluate(hand: String): String = {
    val cardOccurrences: List[CardOccurrence] = hand
      .split(" ")
      .map { card =>
        card.toList match {
          case List(figure, _) => Card(figure, figuresIndex(figure))
        }
      }
      .groupBy(_.figure)
      .map {
        case (figure, cards) => CardOccurrence(cards.size, cards.head.power, figure)
      }
      .toList
      .sorted


    val maxCardOccurrence = cardOccurrences.head
    if (maxCardOccurrence.occurrence == 2) {
      "pair of : " + maxCardOccurrence.figure
    } else {
      "high card : " + maxCardOccurrence.figure
    }
  }
}
