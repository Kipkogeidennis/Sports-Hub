package com.example.sportshub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.sportshub.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using view binding
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        // Initialize ViewPager
        viewPager = binding.viewPager
        val adapter = ImageAdapter(requireContext(), getImageList())
        viewPager.adapter = adapter

        return view
    }

    private fun getImageList(): List<Pair<Int, String>> {
        // Provide a list of image resources and corresponding texts to display in the ViewPager
        return listOf(
            Pair(R.drawable.signingn,"Gor Mahia confirm signing of exciting left-back after luring him from rivals Tusker FC"),
            Pair(R.drawable.rooney, "    FOOTBALL Gor Mahia defender Rooney Onyango opens up about playing in an unfamiliar role at Harambee Stars"),
            Pair(R.drawable.joel, "Timberwolves look to run roughshod over reeling Raptors\n" +
                    "The Minnesota Timberwolves will go for their second win in as many nights when they tip off against the Toronto Raptors on Wednesday in Minneapolis."),
            Pair(R.drawable.cavs, "Cavs pin Jazz with 10th straight loss"),
            Pair(R.drawable.volley, "Winning bronze at the Tokyo Olympics, in 2021, was the biggest result obtained by the Argentinean men’s national team in over three decades.\n" +
                    " This year, the South Americans could have an opportunity to repeat or even improve from that result at the Paris 2024 Games."),
            // Add more image resources and corresponding texts as needed
        )
    }
}

