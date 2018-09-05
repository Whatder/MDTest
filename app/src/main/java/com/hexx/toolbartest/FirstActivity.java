package com.hexx.toolbartest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hexx on 2018/9/5 14:39
 * Desc：
 */
public class FirstActivity extends AppCompatActivity {
    @BindView(R.id.fl)
    FrameLayout mFl;
    @BindView(R.id.rv)
    RecyclerView mRv;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static void start(Context context) {
        Intent starter = new Intent(context, FirstActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ListActivity");

        Adapter adapter = new Adapter(this);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(adapter);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        private Context mContext;

        public Adapter(Context context) {
            mContext = context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_first_list, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(itemView);
            }
        }
    }

}
