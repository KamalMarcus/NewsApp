package com.kamal.myawesomenewsapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.kamal.myawesomenewsapp.R;
import com.kamal.myawesomenewsapp.databinding.ActivityMainBinding;
import com.kamal.myawesomenewsapp.ui.news.NewsActivity;
import com.kamal.myawesomenewsapp.utils.Constants;
import com.kamal.myawesomenewsapp.utils.SharedPrefManager;

public class MainActivity extends AppCompatActivity {

    private BatteryBroadcastReceiver batteryBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        SharedPrefManager sharedPrefManager = SharedPrefManager.getInstance(this);
        binding.etSearch.setText(sharedPrefManager.getSearchWord());
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchWord = binding.etSearch.getText().toString();
                if (TextUtils.isEmpty(searchWord))
                    Toast.makeText(MainActivity.this, "Please enter search word", Toast.LENGTH_LONG).show();
                else {
                    sharedPrefManager.saveSearchWord(searchWord);
                    Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                    intent.putExtra(Constants.INTENT_SEARCH_WORD, searchWord);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        batteryBroadcastReceiver = new BatteryBroadcastReceiver();
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryBroadcastReceiver, ifilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(batteryBroadcastReceiver);
    }

    class BatteryBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int status = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            if (status <= 20)
                Toast.makeText(context, "Battery low! " + status + "%", Toast.LENGTH_LONG).show();

        }
    }
}
