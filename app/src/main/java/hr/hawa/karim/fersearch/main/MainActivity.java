package hr.hawa.karim.fersearch.main;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import hr.hawa.karim.fersearch.R;
import hr.hawa.karim.fersearch.base.BaseActivity;
import hr.hawa.karim.fersearch.databinding.ActivityMainBinding;
import hr.hawa.karim.fersearch.main.NavLinkAdapter;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    @Override
    protected int defineLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new AsyncTask<Void, Void, Document>() {

            @Override
            protected Document doInBackground(Void... voids) {
                Document document = null;
                try {
                    document = Jsoup.connect("http://www.fer.unizg.hr/studiji/preddiplomski_studij/").get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return document;
            }

            @Override
            protected void onPostExecute(Document document) {
                super.onPostExecute(document);
                Elements elementList = document.getElementsByClass("nav_link");
                showElements(elementList);
            }
        }.execute();
    }

    private void showElements(Elements elementList) {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        NavLinkAdapter adapter = new NavLinkAdapter(activity, elementList);
        binding.recyclerView.setAdapter(adapter);
    }
}
