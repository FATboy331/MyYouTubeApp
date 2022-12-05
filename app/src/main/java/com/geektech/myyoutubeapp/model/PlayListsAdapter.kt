package com.geektech.myyoutubeapp.model

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PlayListsAdapter : RecyclerView.Adapter<PlayListsAdapter.PlayListsHolder> {

   inner class PlayListsHolder(item: View) : RecyclerView.ViewHolder(item) {
fun bind(playLists: PlayLists)
    }

}