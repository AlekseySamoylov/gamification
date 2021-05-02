package com.samoilov.gamification.challenge


data class ChallengeSolvedDTO(
  val attemptId: Long,
  val correct: Boolean,
  val factorA: Int,
  val factorB: Int,
  val userId: Long,
  val userAlias: String
)
