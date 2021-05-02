package com.samoilov.gamification.game.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class BadgeCard(
  @Id
  @GeneratedValue
  val badgeId: Long? = null,
  val userId: Long? = null,
  val badgeTimestamp: Long = System.currentTimeMillis(),
  val badgeType: BadgeType? = null
) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as BadgeCard

    if (badgeId != other.badgeId) return false
    if (userId != other.userId) return false
    if (badgeType != other.badgeType) return false

    return true
  }

  override fun hashCode(): Int {
    var result = badgeId?.hashCode() ?: 0
    result = 31 * result + (userId?.hashCode() ?: 0)
    result = 31 * result + (badgeType?.hashCode() ?: 0)
    return result
  }

  override fun toString(): String {
    return "BadgeCard(badgeId=$badgeId, userId=$userId, badgeTimestamp=$badgeTimestamp, badgeType=$badgeType)"
  }

}
