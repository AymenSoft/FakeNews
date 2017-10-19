package com.test.fakenews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

import java.util.List;

public class ListNews extends AppCompatActivity {

    ListView lvData;

    private FakeNewsAdapter fakeNewsAdapter;
    private List<FakeNews> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);

        lvData=(ListView)findViewById(R.id.lv_data);

        arrayList=FakeNewsList.all;

        fakeNewsAdapter=new FakeNewsAdapter(ListNews.this, R.layout.listview_news, arrayList);

        lvData.setAdapter(fakeNewsAdapter);

        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent webview = new Intent(ListNews.this, WebViewShow.class);
                webview.putExtra("htmlContent", arrayList.get(position).htmlContent);
                startActivity(webview);
            }
        });

    }

}
