// UpcomingGamesAdapter.kt
package com.example.sportshub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UpcomingGamesAdapter(private val games: List<UpcomingGame>) :
    RecyclerView.Adapter<UpcomingGamesAdapter.GameViewHolder>() {

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTeams: TextView = itemView.findViewById(R.id.textViewTeams)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_upcoming_game, parent, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.textViewTeams.text = "${game.teamA} vs ${game.teamB}"
        holder.textViewDate.text = "Match Date: ${game.date}"
    }

    override fun getItemCount() = games.size
}
