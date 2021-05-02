package com.samoilov.gamification.game.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
class ScoreCard(
  @Id
  @GeneratedValue
  var cardId: Long? = null,
  var userId: Long? = null,
  var scoreTimestamp: Long? = System.currentTimeMillis(),
  var score: Int? = DEFAULT_SCORE
) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as ScoreCard

    if (cardId != other.cardId) return false
    if (userId != other.userId) return false
    if (score != other.score) return false

    return true
  }

  override fun hashCode(): Int {
    var result = cardId?.hashCode() ?: 0
    result = 31 * result + (userId?.hashCode() ?: 0)
    result = 31 * result + (score ?: 0)
    return result
  }

  override fun toString(): String {
    return "ScoreCard(cardId=$cardId, userId=$userId, scoreTimestamp=$scoreTimestamp, score=$score)"
  }

}

const val DEFAULT_SCORE = 10
