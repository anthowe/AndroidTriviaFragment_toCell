package com.example.android.navigation.ui.addJoke

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.android.navigation.R
import com.example.android.navigation.common.onClick
import com.example.android.navigation.model.Joke
import kotlinx.android.synthetic.main.item_joke.view.*


class JokeHolder(
        itemView: View,
        private inline val onFavoriteClickHandler: (Joke) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun displayData(joke: Joke) = with(itemView) {
        favoriteButton.onClick { onFavoriteClickHandler(joke) }

        jokeAuthor.text = joke.authorName
        jokeDescription.text = joke.text


        favoriteButton.setImageResource(if(joke.isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border)
    }
}