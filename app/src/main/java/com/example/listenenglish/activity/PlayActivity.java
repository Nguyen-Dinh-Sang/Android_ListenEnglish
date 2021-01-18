package com.example.listenenglish.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listenenglish.R;
import com.example.listenenglish.adapter.ViewPagerPlayAdapter;
import com.example.listenenglish.fragment.FragmentDiaNhac;
import com.example.listenenglish.fragment.FragmentPlayDanhSachFile;
import com.example.listenenglish.model.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView textViewTimeSong, textViewTotalTime;
    SeekBar seekBar;
    ImageButton imageButtonPlay, imageButtonRepeat, imageButtonNext, imageButtonPre, imageButtonRandom;
    ViewPager viewPager;
    public static ArrayList<File> fileArrayList = new ArrayList<>();
    public static ViewPagerPlayAdapter adapter;
    FragmentDiaNhac fragmentDiaNhac;
    FragmentPlayDanhSachFile fragmentPlayDanhSachFile;
    MediaPlayer mediaPlayer;

    int position = 0;
    boolean repeat = false;
    boolean checkradom = false;
    boolean next = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        //tránh tình trạng phát sinh khi sử dụng mạng
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        dataIntent();
        initview();
        initEvent();
    }

    private void initEvent() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (adapter.getItem(1) != null) {
                    if (fileArrayList.size() > 0) {
                        fragmentDiaNhac.play(fileArrayList.get(0).getIconFile());
                        handler.removeCallbacks(this);
                    } else {
                        handler.postDelayed(this, 300);
                    }
                }
            }
        }, 500);

        imageButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    imageButtonPlay.setImageResource(R.drawable.ic_play);
                    fragmentDiaNhac.objectAnimatorPause();
                } else {
                    mediaPlayer.start();
                    imageButtonPlay.setImageResource(R.drawable.ic_signs);
                    fragmentDiaNhac.objectAnimatorStart();
                }
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                mediaPlayer.stop();
                fileArrayList.clear();
            }
        });

        imageButtonRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (repeat == false) {
                    if (checkradom == true) {
                        checkradom = false;
                        imageButtonRandom.setBackgroundColor(Color.TRANSPARENT);
                    }
                    imageButtonRepeat.setBackgroundColor(Color.WHITE);
                    repeat = true;
                } else {
                    imageButtonRepeat.setBackgroundColor(Color.TRANSPARENT);
                    repeat = false;
                }
            }
        });

        imageButtonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkradom == false) {
                    if (repeat == true) {
                        repeat = false;
                        imageButtonRepeat.setBackgroundColor(Color.TRANSPARENT);
                    }
                    imageButtonRandom.setBackgroundColor(Color.WHITE);
                    checkradom = true;
                } else {
                    imageButtonRandom.setBackgroundColor(Color.TRANSPARENT);
                    checkradom = false;
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });

        imageButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fileArrayList.size() > 0) {
                    if (mediaPlayer.isPlaying() || mediaPlayer != null) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }

                    if (position < fileArrayList.size()) {
                        imageButtonPlay.setImageResource(R.drawable.ic_signs);
                        position++;
                        if (repeat == true) {
                            if (position == 0) {
                                position = fileArrayList.size();
                            }
                            position -= 1;
                        }
                        if (checkradom == true) {
                            Random random = new Random();
                            int index = random.nextInt(fileArrayList.size());
                            if (index == position) {
                                position = index -1;
                            }
                            position = index;
                        }
                        if (position > (fileArrayList.size() - 1)) {
                            position = 0;
                        }
                        new Play().execute(fileArrayList.get(position).getMp3());
                        fragmentDiaNhac.play(fileArrayList.get(position).getIconFile());
                        getSupportActionBar().setTitle(fileArrayList.get(position).getTenFile());

                    }
                }
                imageButtonNext.setClickable(false);
                imageButtonPre.setClickable(false);
                Handler handler1 = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageButtonNext.setClickable(true);
                        imageButtonPre.setClickable(true);
                    }
                }, 5000);
            }
        });

        imageButtonPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fileArrayList.size() > 0) {
                    if (mediaPlayer.isPlaying() || mediaPlayer != null) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }

                    if (position < fileArrayList.size()) {
                        imageButtonPlay.setImageResource(R.drawable.ic_signs);
                        position--;
                        if (position < 0) {
                            position = fileArrayList.size() - 1;
                        }
                        if (repeat == true) {
                            position += 1;
                        }
                        if (checkradom == true) {
                            Random random = new Random();
                            int index = random.nextInt(fileArrayList.size());
                            if (index == position) {
                                position = index -1;
                            }
                            position = index;
                        }
                        new Play().execute(fileArrayList.get(position).getMp3());
                        fragmentDiaNhac.play(fileArrayList.get(position).getIconFile());
                        getSupportActionBar().setTitle(fileArrayList.get(position).getTenFile());

                    }
                }
                imageButtonNext.setClickable(false);
                imageButtonPre.setClickable(false);
                Handler handler1 = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageButtonNext.setClickable(true);
                        imageButtonPre.setClickable(true);
                    }
                }, 5000);
            }
        });
    }

    private void initview() {
        toolbar = findViewById(R.id.tb_play);
        textViewTimeSong = findViewById(R.id.tv_time_song);
        textViewTotalTime = findViewById(R.id.tv_total_time_song);
        seekBar = findViewById(R.id.sb_play);
        imageButtonPlay = findViewById(R.id.ib_play);
        imageButtonRepeat = findViewById(R.id.ib_repeat);
        imageButtonNext = findViewById(R.id.ib_next);
        imageButtonPre = findViewById(R.id.ib_review);
        imageButtonRandom = findViewById(R.id.ib_suffle);
        viewPager = findViewById(R.id.vp_play);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                mediaPlayer.stop();
                fileArrayList.clear();
            }
        });
        toolbar.setTitleTextColor(Color.WHITE);

        fragmentDiaNhac = new FragmentDiaNhac();
        fragmentPlayDanhSachFile = new FragmentPlayDanhSachFile();
        adapter = new ViewPagerPlayAdapter(getSupportFragmentManager());
        adapter.addFragment(fragmentPlayDanhSachFile);
        adapter.addFragment(fragmentDiaNhac);
        viewPager.setAdapter(adapter);

        fragmentDiaNhac = (FragmentDiaNhac) adapter.getItem(1);
        if (fileArrayList.size() > 0) {
            getSupportActionBar().setTitle(fileArrayList.get(0).getTenFile());
            new Play().execute(fileArrayList.get(0).getMp3());
            imageButtonPlay.setImageResource(R.drawable.ic_signs);
        }
    }

    private void dataIntent() {
        fileArrayList.clear();
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("file")) {
                File file = intent.getParcelableExtra("file");
                fileArrayList.add(file);
                Log.d("Sang OK", "FilePlay OK " + file.getNoiDung());
            }

            if (intent.hasExtra("danhsachfile")) {
                ArrayList<File> fileArrayListIntent = intent.getParcelableArrayListExtra("danhsachfile");
                fileArrayList = fileArrayListIntent;
                Log.d("Sang OK", "DanhSach_FilePlay OK " + fileArrayList.size());
            }
        }
    }

    class Play extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }
                });

                mediaPlayer.setDataSource(s);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            timeSong();
        }
    }

    private void timeSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mmm:ss");
        textViewTotalTime.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        seekBar.setMax(mediaPlayer.getDuration());
    }
}
