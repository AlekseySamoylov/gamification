package com.samoilov.gamification.game.domain


data class LeaderBoardRow(val userId: Long, val totalSccore: Long, val badges: List<String>)
