// PastGamesAdapter.kt
package com.example.sportshub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PastGamesAdapter(private val games: List<PastGame>) :
    RecyclerView.Adapter<PastGamesAdapter.GameViewHolder>() {

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTeams: TextView = itemView.findViewById(R.id.textViewTeams)
        val textViewScores: TextView = itemView.findViewById(R.id.textViewScores)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_past_game, parent, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.textViewTeams.text = "${game.teamA} $game.scoreA - $game.scoreB ${game.teamB}"
        holder.textViewScores.text = "Final Score"
    }

    override fun getItemCount() = games.size
}
