package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private GridView mGrid;
    private GridAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGrid = (GridView)findViewById(R.id.field);
        mGrid.setNumColumns(4);
        mGrid.setEnabled(true);

        mAdapter = new GridAdapter(this, 4, 4);
        mGrid.setAdapter(mAdapter);

        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,int position, long id){

                mAdapter.checkOpenCells ();
                mAdapter.openCell (position);

                if (mAdapter.checkGameOver())
                    Toast.makeText (getApplicationContext(), "Игра закончена", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
