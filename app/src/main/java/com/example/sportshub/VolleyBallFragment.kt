package com.example.sportshub

import VolleyUpcomingMatch
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VolleyBallFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_volley_ball, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView for upcoming volleyball matches
        val recyclerViewUpcoming = view.findViewById<RecyclerView>(R.id.recyclerViewUpcomingVolleyballMatches)
        recyclerViewUpcoming.layoutManager = LinearLayoutManager(requireContext())
        val upcomingMatches = getUpcomingVolleyballMatches()
        recyclerViewUpcoming.adapter = VolleyUpcomingMatch(requireContext(), upcomingMatches)

        // Initialize RecyclerView for recent volleyball matches
        val recyclerViewRecent = view.findViewById<RecyclerView>(R.id.recyclerViewRecentVolleyballMatches)
        recyclerViewRecent.layoutManager = LinearLayoutManager(requireContext())
        val recentMatches = getRecentVolleyballMatches()
        recyclerViewRecent.adapter = VolleyUpcomingMatch(requireContext(), recentMatches)
    }

    private fun getUpcomingVolleyballMatches(): List<VolleyballGame> {
        // Provide a list of upcoming volleyball matches
        return listOf(
            VolleyballGame("Umma Men Team", "East Africa Men's Team", "2023-04-01"),
            VolleyballGame("The 7s", "Worriors", "2023-04-05")
            // Add more upcoming matches as needed
        )
    }

    private fun getRecentVolleyballMatches(): List<VolleyballMatch> {
        // Provide a list of recent volleyball matches
        return listOf(
            VolleyballMatch("Nairobi Team", "St Patrick", "3-2", "2023-03-25"),
            VolleyballMatch("Kajido", "Scorpion", "2-3", "2023-03-20")
            // Add more recent matches as needed
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VolleyBallFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
