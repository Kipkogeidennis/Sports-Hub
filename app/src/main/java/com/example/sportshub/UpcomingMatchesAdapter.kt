package com.example.sportshub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class UpcomingMatchesAdapter(private val upcomingMatches: List<UpcomingMatch>) :
    RecyclerView.Adapter<UpcomingMatchesAdapter.UpcomingMatchViewHolder>() {

    inner class UpcomingMatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTeams: TextView = itemView.findViewById(R.id.textViewTeams)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMatchViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_upcoming_footballmatch, parent, false)
        return UpcomingMatchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UpcomingMatchViewHolder, position: Int) {
        val upcomingMatch = upcomingMatches[position]
        holder.textViewTeams.text = "${upcomingMatch.team1} vs ${upcomingMatch.team2}"
        val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        holder.textViewDate.text = dateFormat.format(upcomingMatch.matchDate)
    }

    override fun getItemCount() = upcomingMatches.size
}
