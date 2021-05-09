package com.samoilov.gamification.game

import com.samoilov.gamification.challenge.ChallengeSolvedDTO
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class GameServiceTest {

  @Test
  fun `Should increase a score if correct`() {
    // Given
    val service = GameServiceImpl()
    val challendgeSolved = ChallengeSolvedDTO(1, true, 10, 20, 1, "Vasilii")

    // When
    val result = service.newAttemptForUser(challendgeSolved)

    // Then
    assertThat(result.score).isEqualTo(1)
  }

  @Test
  fun `Should not increase a score if incorrect`() {
    // Given
    val service = GameServiceImpl()
    val challendgeSolved = ChallengeSolvedDTO(1, false, 10, 20, 1, "Vasilii")

    // When
    val result = service.newAttemptForUser(challendgeSolved)

    // Then
    assertThat(result.score).isEqualTo(0)
  }
}
