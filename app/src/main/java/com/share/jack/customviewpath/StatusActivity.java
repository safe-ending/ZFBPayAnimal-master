package com.share.jack.customviewpath;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.share.jack.customviewpath.widget.CustomPathView;
import com.share.jack.customviewpath.widget.CustomShapeView;
import com.share.jack.customviewpath.widget.CustomStatusView;
import com.share.jack.customviewpath.widget.WaterWaveProgress;

/**
 *
 */

public class StatusActivity extends Activity implements View.OnClickListener {
    private CustomPathView customShapeView;
    private CustomStatusView customStatusView;
    private WaterWaveProgress waterWaveProgress;
    private Button btnSuccess;
    private Button btnFailure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        customShapeView = (CustomPathView) findViewById(R.id.as_shape);
        customStatusView = (CustomStatusView) findViewById(R.id.as_status);
        waterWaveProgress = (WaterWaveProgress) findViewById(R.id.as_progress);
        btnSuccess = (Button) findViewById(R.id.as_btn_success);
        btnFailure = (Button) findViewById(R.id.as_btn_failure);

        btnSuccess.setOnClickListener(this);
        btnFailure.setOnClickListener(this);
        waterWaveProgress.animateWave();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.as_btn_success:
                customStatusView.loadLoading();
                customStatusView.initPath();
                btnSuccess.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        customStatusView.loadSuccess();
                    }
                },3000);
                break;
            case R.id.as_btn_failure:
                customStatusView.loadLoading();
                customStatusView.initPath();
                btnFailure.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        customStatusView.loadFailure();
                    }
                },3000);
                break;
        }
    }
}