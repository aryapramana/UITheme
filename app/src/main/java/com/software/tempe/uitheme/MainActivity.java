package com.software.tempe.uitheme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Switch action_theme;
    private MenuItem toggle_theme;

    private ApplicationState state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        state = new ApplicationState(this);

        if(state.getThemeState()) {
            setTheme(R.style.AppThemeDark);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        toggle_theme = menu.findItem(R.id.toggle_theme);
        action_theme = (Switch) toggle_theme.getActionView();

        if(state.getThemeState()) {
            action_theme.setChecked(true);
        }

        action_theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    state.setThemeState(true);
                    reboot();
                } else {
                    state.setThemeState(false);
                    reboot();
                }
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void reboot() {
        Intent rebootIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(rebootIntent);
        finish();
    }
}
