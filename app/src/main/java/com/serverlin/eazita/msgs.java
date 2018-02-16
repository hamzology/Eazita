package com.serverlin.eazita;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class msgs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        ListView mListView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msgs);
        mListView = (ListView) findViewById(R.id.list);
        ArrayList<String> recipeList = new ArrayList<String>();
        recipeList.add("F");
        recipeList.add("C");
        recipeList.add("S");
        recipeList.add("F");
        recipeList.add("F");
        recipeList.add("C");
        recipeList.add("S");
        recipeList.add("F");
        recipeList.add("F");
        recipeList.add("C");
        recipeList.add("S");
        recipeList.add("F");
        recipeList.add("F");
        recipeList.add("C");
        recipeList.add("S");
        recipeList.add("F");
        recipeList.add("F");
        recipeList.add("C");
        recipeList.add("S");
        recipeList.add("F");

        ChatAdapter adapter = new ChatAdapter(this, recipeList);
        mListView.setAdapter(adapter);

    }
}