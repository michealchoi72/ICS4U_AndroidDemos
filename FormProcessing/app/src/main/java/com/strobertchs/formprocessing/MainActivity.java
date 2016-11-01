package com.strobertchs.formprocessing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import java.util.ArrayList;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //click event that gets data from form and makes the necessary method calls to process the similes
    public void simClick(View v){

        // get data from the text fields
        EditText txtAdjectives = (EditText)findViewById(R.id.mtextAdjectives);
        EditText txtNouns = (EditText)findViewById(R.id.mtxtNouns);

        //retrieve the TextView object
        TextView lblSimilations = (TextView)findViewById(R.id.similations);

        String strAdjectives = txtAdjectives.getText().toString();
        String strNouns = txtNouns.getText().toString();

        String adjList[] = strAdjectives.split("\\n");
        String nounList[] = strNouns.split("\\n");


        lblSimilations.setText(getSimilesStr(getSimiles(adjList, nounList)));
    }


    //Generate the list if similes based on the adjectives and nouns
    private ArrayList<String> getSimiles(String adjList[], String nounList[]){
        ArrayList<String> similations = new ArrayList<String>();

        for (String adj: adjList){
            for (String noun: nounList){
                similations.add(adj + " as " + noun);
            }
        }

        return similations;
    }//end getSimiles


    // Convert the list of similes into a string (with similes separated by new lines)
    private String getSimilesStr(ArrayList<String> simList){
        //Convert the list of similes

        String simStr = "";

        for (String sentence: simList){
            simStr = simStr + sentence + "\n";
        }
        return simStr;
    }
}
