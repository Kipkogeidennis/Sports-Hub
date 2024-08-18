package com.example.sportshub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sportshub.databinding.ActivityDashBoardUserBinding
import com.google.firebase.auth.FirebaseAuth

class DashBoardUser : AppCompatActivity() {
    private lateinit var binding: ActivityDashBoardUserBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.logoutBtn.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(this, MainScreen::class.java))
            finish()
        }

        // Set listener for navigation items
        binding.navBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.football -> {
                    replaceFragment(FootBallFragment())
                    true
                }
                R.id.basketball -> {
                    replaceFragment(BasketBallFragment())
                    true
                }
                R.id.volleyball -> {
                    replaceFragment(VolleyBallFragment())
                    true
                }
                else -> false
            }
        }

        // Set default fragment
        replaceFragment(HomeFragment())
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            // Not logged in, go to the main screen
            binding.subTitleTv.text = "Not Logged In"
        } else {
            // Logged in, get and show user info
            val email = firebaseUser.email
            // Set to the TextView in the toolbar
            binding.subTitleTv.text = email
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
