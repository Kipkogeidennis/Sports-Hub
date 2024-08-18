import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportshub.R
import com.example.sportshub.VolleyballMatch
import com.example.sportshub.VolleyballGame

class VolleyUpcomingMatch(private val context: Context, private val matches: List<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_MATCH = 1
        private const val VIEW_TYPE_GAME = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_MATCH) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_upcoming_volleyball_match, parent, false)
            MatchViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_upcoming_volleyball_match, parent, false)
            GameViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MatchViewHolder -> {
                val match = matches[position] as VolleyballMatch
                holder.bind(match)
            }
            is GameViewHolder -> {
                val game = matches[position] as VolleyballGame
                holder.bind(game)
            }
        }
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (matches[position] is VolleyballMatch) {
            VIEW_TYPE_MATCH
        } else {
            VIEW_TYPE_GAME
        }
    }

    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val team1TextView: TextView = itemView.findViewById(R.id.textViewTeam1)
        private val team2TextView: TextView = itemView.findViewById(R.id.textViewTeam2)
        private val scoreTextView: TextView = itemView.findViewById(R.id.textViewScore)
        private val dateTextView: TextView = itemView.findViewById(R.id.textViewDate)

        fun bind(match: VolleyballMatch) {
            team1TextView.text = match.teamA
            team2TextView.text = match.teamB
            scoreTextView.text = match.score
            dateTextView.text = match.date
        }
    }

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val team1TextView: TextView = itemView.findViewById(R.id.textViewTeam1)
        private val team2TextView: TextView = itemView.findViewById(R.id.textViewTeam2)
        private val dateTextView: TextView = itemView.findViewById(R.id.textViewDate)

        fun bind(game: VolleyballGame) {
            team1TextView.text = game.teamA
            team2TextView.text = game.teamB
            dateTextView.text = game.date
        }
    }
}
