package com.example.sportshub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FootballTeamAdapter(private val teams: List<FootBallTeam>) :
    RecyclerView.Adapter<FootballTeamAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTeamName: TextView = itemView.findViewById(R.id.textViewTeamName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_football_team, parent, false)
        return TeamViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val currentTeam = teams[position]
        holder.textViewTeamName.text = currentTeam.name
    }

    override fun getItemCount() = teams.size
}
