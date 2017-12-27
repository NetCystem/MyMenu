package com.example.macbook.mymenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnContext;
    private Button btnPopup;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnContext = findViewById(R.id.btnContext);
        registerForContextMenu(btnContext);
        btnPopup = findViewById(R.id.btnPopup);
        btnPopup.setOnClickListener(this::showPopupMenu);
        text = findViewById(R.id.txt);
    }

    //Context Menu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, 1, 0, "RED");
        menu.add(0, 2, 0, "GREEN");
        menu.add(0, 3, 0, "BLUE");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                text.setBackgroundColor(Color.parseColor("#FF0000"));
                break;
            case 2:
                text.setBackgroundColor(Color.parseColor("#228b22"));
                break;

            case 3:
                text.setBackgroundColor(Color.parseColor("#0000ee"));
                break;
        }

        return true;
    }

//Popup Menu
    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.second_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.big:
                    text.setTextSize(70);
                    break;
                case R.id.medium:
                    text.setTextSize(20);
                    break;
                case R.id.small:
                    text.setTextSize(15);
                    break;
            }
            return true;
        });
        popupMenu.show();
    }
}




