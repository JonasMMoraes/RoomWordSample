package com.example.roomwordsample.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.roomwordsample.WordRoomDatabase;
import com.example.roomwordsample.dao.WordDao;
import com.example.roomwordsample.entity.Word;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizeWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        WordRoomDatabase.databaseWriterExecutor.execute(() -> mWordDao.insert(word));
    }
}
