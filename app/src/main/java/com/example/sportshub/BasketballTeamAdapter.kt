// BasketballTeamAdapter.kt
package com.example.sportshub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BasketballTeamAdapter(private val basketballTeams: List<BasketballTeam>) : RecyclerView.Adapter<BasketballTeamAdapter.BasketballTeamViewHolder>() {

    inner class BasketballTeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val teamNameTextView: TextView = itemView.findViewById(R.id.textViewTeamName)

        fun bind(team: BasketballTeam) {
            teamNameTextView.text = team.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketballTeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_basketball_team, parent, false)
        return BasketballTeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: BasketballTeamViewHolder, position: Int) {
        holder.bind(basketballTeams[position])
    }

    override fun getItemCount(): Int {
        return basketballTeams.size
    }
}
