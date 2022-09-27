package com.example.roomwordsample.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.example.roomwordsample.entity.Word;
import com.example.roomwordsample.viewModel.WordViewHolder;
import org.jetbrains.annotations.NotNull;

public class WordListAdapter extends ListAdapter<Word, WordViewHolder> {

    public WordListAdapter(DiffUtil.ItemCallback<Word> diffCallback) {
        super(diffCallback);
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return WordViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        Word current = getItem(position);
        holder.bind(current.getWord());
    }

    public static class WordDiff extends DiffUtil.ItemCallback<Word> {

        @Override
        public boolean areItemsTheSame(@NonNull @NotNull Word oldItem, @NonNull @NotNull Word newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull Word oldItem, @NonNull @NotNull Word newItem) {
            return oldItem.getWord().equals(newItem.getWord());
        }
    }

}
