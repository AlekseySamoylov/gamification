package com.samoilov.gamification.game

import com.samoilov.gamification.challenge.ChallengeSolvedDTO
import com.samoilov.gamification.game.domain.BadgeType


interface GameService {
  fun newAttemptForUser(challenge: ChallengeSolvedDTO): GameResult
}

data class GameResult(val score: Int, val badges: List<BadgeType>)
