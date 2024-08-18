package com.example.sportshub
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class FootBallFragment : Fragment() {
    private lateinit var recyclerViewFootballScores: RecyclerView
    private lateinit var recyclerViewNews: RecyclerView
    private lateinit var recyclerViewUpcomingMatches: RecyclerView
    private lateinit var adapter: FootballScoreAdapter
    private lateinit var teamAdapter: FootballTeamAdapter
    private lateinit var upcomingMatchesAdapter: UpcomingMatchesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_foot_ball, container, false)
        recyclerViewFootballScores = view.findViewById(R.id.recyclerViewFootballScores)
        recyclerViewNews = view.findViewById(R.id.recyclerViewNews)
        recyclerViewUpcomingMatches = view.findViewById(R.id.recyclerViewUpcomingMatches)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView for Football Scores
        adapter = FootballScoreAdapter(getFootballScores())
        recyclerViewFootballScores.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewFootballScores.adapter = adapter

        // Initialize RecyclerView for Football Teams (News)
        teamAdapter = FootballTeamAdapter(getFootballTeams())
        recyclerViewNews.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewNews.adapter = teamAdapter

        // Initialize RecyclerView for Upcoming Matches
        upcomingMatchesAdapter = UpcomingMatchesAdapter(generateRandomUpcomingMatches())
        recyclerViewUpcomingMatches.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewUpcomingMatches.adapter = upcomingMatchesAdapter
    }

    private fun getFootballScores(): List<FootballScore> {
        // Populate football scores data
        return listOf(
            FootballScore("UmmaFc", 3, "KajiadoFc", 2),
            FootballScore("St Patricks", 1, "Kapsabet", 1),
            FootballScore("Kill Switch", 5, "Kill Crew", 4),
            // Add more football scores as needed
        )
    }

    private fun getFootballTeams(): List<FootBallTeam> {
        // Populate football teams data for news section
        return listOf(
            FootBallTeam("Umma Fc"),
            FootBallTeam("Kajiado Fc"),
            FootBallTeam("Sofapaka"),
            FootBallTeam("Gor Mahia"),
            FootBallTeam("Tusker"),
            FootBallTeam("Lions"),
            // Add more football teams as needed
        )
    }

    private fun generateRandomUpcomingMatches(): List<UpcomingMatch> {
        // Generate random upcoming matches for the next 2 weeks
        val upcomingMatches = mutableListOf<UpcomingMatch>()
        val calendar = Calendar.getInstance()
        val random = Random()
        val teams = getFootballTeams()
        for (i in 0 until 4) { // Generate matches for the next 2 weeks
            calendar.add(Calendar.DAY_OF_MONTH, 10) // Increment by 10 days
            val teamIndices = mutableListOf<Int>()
            while (teamIndices.size < 4) {
                val randomIndex = random.nextInt(teams.size)
                if (randomIndex !in teamIndices) {
                    teamIndices.add(randomIndex)
                }
            }
            val team1 = teams[teamIndices[0]].name
            val team2 = teams[teamIndices[1]].name
            val team3 = teams[teamIndices[2]].name
            val team4 = teams[teamIndices[3]].name
            val matchDate = calendar.time // Match date
            upcomingMatches.add(UpcomingMatch(team1, team2, team3, team4, matchDate))
        }
        return upcomingMatches
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FootBallFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
