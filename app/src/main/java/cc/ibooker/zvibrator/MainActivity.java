package cc.ibooker.zvibrator;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * 振动器实例
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView startTv = (TextView) findViewById(R.id.tv_start);
        startTv.setOnClickListener(this);
        TextView stopTv = (TextView) findViewById(R.id.tv_stop);
        stopTv.setOnClickListener(this);

        initVibrator();
    }

    // 初始化Vibrator
    private void initVibrator() {
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

//        /**
//         * 创建一次性振动
//         *
//         * @param milliseconds 震动时长（ms）
//         * @param amplitude 振动强度。这必须是1到255之间的值，或者DEFAULT_AMPLITUDE
//         */
//        VibrationEffect vibrationEffect = VibrationEffect.createOneShot(long milliseconds, int amplitude);

//        /**
//         * 创建波形振动
//         *
//         * @param timings 交替开关定时的模式，从关闭开始。0的定时值将导致定时/振幅对被忽略。
//         * @param repeat 振动重复的模式，如果您不想重复，则将索引放入计时数组中重复，或者-1。
//         *               -1 为不重复
//         *               0 为一直重复振动
//         *               1 则是指从数组中下标为1的地方开始重复振动，重复振动之后结束
//         *               2 从数组中下标为2的地方开始重复振动，重复振动之后结束
//         */
//        VibrationEffect vibrationEffect = VibrationEffect.createWaveform(long[] timings, int repeat);

//        /**
//         * 创建波形振动
//         *
//         * @param timings 振幅值中的定时值。定时值为0振幅可忽视的。
//         * @param amplitudes 振幅值中的振幅值。振幅值必须为0和255之间，或为DEFAULT_AMPLITUDE。振幅值为0意味着断开。
//         * @param repeat 振动重复的模式，如果您不想重复，则将索引放入计时数组中重复，或者-1。
//         */
//        VibrationEffect vibrationEffect = VibrationEffect.createWaveform(long[] timings, int[] amplitudes, int repeat);
    }

    // 点击事件监听
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_start:// 开始振动
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createWaveform(new long[]{100L, 2000L, 1000L, 1000L, 3000L}, 0));
                } else {
                    vibrator.vibrate(new long[]{100L, 2000L, 1000L, 1000L, 3000L}, 0);
                }
                break;
            case R.id.tv_stop:// 停止振动
                vibrator.cancel();
                break;
        }
    }
}
