package com.example.sportshub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecentVolleyballMatchesAdapter(private val matches: List<VolleyballMatch>) :
    RecyclerView.Adapter<RecentVolleyballMatchesAdapter.MatchViewHolder>() {

    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTeams: TextView = itemView.findViewById(R.id.textViewTeams)
        val textViewResult: TextView = itemView.findViewById(R.id.textViewResult)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recent_volleyball_match, parent, false)
        return MatchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = matches[position]
        holder.textViewTeams.text = "${match.teamA} vs ${match.teamB}"
        holder.textViewResult.text = "Result: ${match.score}"
        holder.textViewDate.text = "Match Date: ${match.date}"
    }

    override fun getItemCount() = matches.size
}
