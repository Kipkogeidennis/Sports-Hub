package com.example.sportshub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BasketballPlayerAdapter(private val players: List<BasketBallPlayer>) :
    RecyclerView.Adapter<BasketballPlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewPosition: TextView = itemView.findViewById(R.id.textViewPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_basketball_player, parent, false)
        return PlayerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.textViewName.text = player.name
        holder.textViewPosition.text = player.position
    }

    override fun getItemCount() = players.size
}
