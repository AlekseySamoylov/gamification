package com.samoilov.gamification.game

import com.samoilov.gamification.challenge.ChallengeSolvedDTO
import com.samoilov.gamification.game.domain.BadgeType
import org.springframework.stereotype.Service


interface GameService {
  fun newAttemptForUser(challenge: ChallengeSolvedDTO): GameResult
}

data class GameResult(val score: Int, val badges: List<BadgeType>)

@Service
class GameServiceImpl : GameService {
  val userIdToScoreMap = mutableMapOf<Long, Int>()
  override fun newAttemptForUser(challenge: ChallengeSolvedDTO): GameResult {
    val scoreToAdd = if (challenge.correct) { 1 } else { 0 }
    val currentScore = userIdToScoreMap[challenge.userId]
    val totalScore = if (currentScore != null) {
      currentScore + scoreToAdd
    } else {
      scoreToAdd
    }
    userIdToScoreMap[challenge.userId] = totalScore
    return GameResult(totalScore, emptyList())
  }

}
