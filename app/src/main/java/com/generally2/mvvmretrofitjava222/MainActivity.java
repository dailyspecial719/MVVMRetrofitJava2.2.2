package com.generally2.mvvmretrofitjava222;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    MainActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewModel();
        Button createButton = findViewById(R.id.createButton);
        //EditText etName = findViewById(R.id.etName);
        //EditText etEmail = findViewById(R.id.etEmail);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewUser();
            }
        });

    }

    private void createNewUser(){
        String name = ((EditText) findViewById(R.id.etName)).getText().toString();;
        String email = ((EditText) findViewById(R.id.etEmail)).getText().toString();
        User user = new User("", name, email, "Active", "Male");
        viewModel.createNewUser(user);

    }
    private void initViewModel(){
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getCreateUserObserver().observe(this, new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse userResponse) {
                if (userResponse == null){
                    Toast.makeText(MainActivity.this, "Failed to create a new user", Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(MainActivity.this, "Successfully created a new user", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}