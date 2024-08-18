package com.example.sportshub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class BasketBallFragment : Fragment() {
    private lateinit var recyclerViewBasketballPlayers: RecyclerView
    private lateinit var recyclerViewUpcomingGames: RecyclerView
    private lateinit var recyclerViewPastGames: RecyclerView
    private lateinit var playerAdapter: BasketballPlayerAdapter
    private lateinit var upcomingGamesAdapter: UpcomingGamesAdapter
    private lateinit var pastGamesAdapter: PastGamesAdapter


    private val basketballTeams = listOf(
        BasketballTeam("Worrior"),
        BasketballTeam("Umma WC"),
        BasketballTeam("Falcons"),
        BasketballTeam("Blazers"),
        BasketballTeam("Iconics"),
        BasketballTeam("Kajiado"),
        BasketballTeam("Lancers"),
        BasketballTeam("Knights"),
        // Add more teams as needed
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_basket_ball, container, false)
        recyclerViewBasketballPlayers = view.findViewById(R.id.recyclerViewBasketballPlayers)
        recyclerViewUpcomingGames = view.findViewById(R.id.recyclerViewUpcomingGames)
        recyclerViewPastGames = view.findViewById(R.id.recyclerViewPastGames)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView for Basketball Players
        playerAdapter = BasketballPlayerAdapter(getBasketballPlayers())
        recyclerViewBasketballPlayers.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewBasketballPlayers.adapter = playerAdapter

        // Initialize RecyclerView for Upcoming Games
        upcomingGamesAdapter = UpcomingGamesAdapter(getUpcomingGames())
        recyclerViewUpcomingGames.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewUpcomingGames.adapter = upcomingGamesAdapter

        // Initialize RecyclerView for Past Games
        pastGamesAdapter = PastGamesAdapter(getPastGames())
        recyclerViewPastGames.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewPastGames.adapter = pastGamesAdapter
    }

    private fun getBasketballPlayers(): List<BasketBallPlayer> {
        // Populate basketball players data
        return listOf(
            BasketBallPlayer("Holy Icon", "Forward"),
            BasketBallPlayer("Junior", "Guard"),
            BasketBallPlayer("Aksam", "Guard"),
            BasketBallPlayer("Dave", "Guard"),
            // Add more players as needed
        )
    }

    private fun getUpcomingGames(): List<UpcomingGame> {
        // Populate upcoming games data with randomly selected teams
        val upcomingGames = mutableListOf<UpcomingGame>()
        val calendar = Calendar.getInstance()
        val random = Random()
        for (i in 0 until 4) { // Generate matches for the next 2 weeks
            calendar.add(Calendar.DAY_OF_MONTH, 10) // Increment by 10 days
            val team1 = basketballTeams[random.nextInt(basketballTeams.size)].name
            val team2 = basketballTeams[random.nextInt(basketballTeams.size)].name
            val matchDate = calendar.time // Match date
            upcomingGames.add(UpcomingGame(team1, team2, matchDate.toString()))
        }
        return upcomingGames
    }

    private fun getPastGames(): List<PastGame> {
        // Populate past games data
        return listOf(
            PastGame("Sky Hawks", 80, "Pioneers", 75),
            PastGame("Fantas", 90, "Rapters", 85),
            // Add more past games as needed
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BasketBallFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}

