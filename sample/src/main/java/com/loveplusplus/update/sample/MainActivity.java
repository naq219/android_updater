package com.loveplusplus.update.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loveplusplus.update.AppUtils;
import com.loveplusplus.update.CheckUpdateTask;
import com.loveplusplus.update.UpdateChecker;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        String url="http://static.lemyde.com/updatecrm/updatecrm.json";
        UpdateChecker.setUrl(url,this);


        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //UpdateChecker.checkForDialog(MainActivity.this);
                UpdateChecker.checkListener(getBaseContext(), new CheckUpdateTask.CheckUpdateTaskListener() {
                    @Override
                    public void onChecked(boolean isHaveNewUpdate) {
                        Toast.makeText(MainActivity.this,"daco:"+isHaveNewUpdate,Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                UpdateChecker.checkForNotification(MainActivity.this);
            }
        });


        TextView textView = (TextView) findViewById(R.id.textView1);

        textView.setText("当前版本信息: versionName = " + AppUtils.getVersionName(this) + " versionCode = " + AppUtils.getVersionCode(this));
    }

}
