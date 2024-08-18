package com.example.sportshub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FootballScoreAdapter(private val scores: List<FootballScore>) :
    RecyclerView.Adapter<FootballScoreAdapter.ScoreViewHolder>() {

    inner class ScoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTeam1: TextView = itemView.findViewById(R.id.textViewTeam1)
        val textViewScore: TextView = itemView.findViewById(R.id.textViewScore)
        val textViewTeam2: TextView = itemView.findViewById(R.id.textViewTeam2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_football_scores, parent, false)
        return ScoreViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val currentScore = scores[position]
        holder.textViewTeam1.text = currentScore.team1
        holder.textViewScore.text = "${currentScore.score1} - ${currentScore.score2}"
        holder.textViewTeam2.text = currentScore.team2
    }

    override fun getItemCount() = scores.size
}
