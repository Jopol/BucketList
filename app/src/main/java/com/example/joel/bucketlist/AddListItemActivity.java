package com.example.joel.bucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddListItemActivity extends AppCompatActivity {

    private MainViewModel mMainViewModel;
    private EditText title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlistitem);

        title = findViewById(R.id.editText);
        mMainViewModel = new MainViewModel(getApplicationContext());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newListItem();
            }
        });
    }

    private void newListItem(){
        String titleText = title.getText().toString();
        ListItem listItem = new ListItem(false,titleText);
        mMainViewModel.insert(listItem);
        Intent intent = new Intent(AddListItemActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
