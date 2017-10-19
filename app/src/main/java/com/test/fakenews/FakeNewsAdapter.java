package com.test.fakenews;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.oc.rss.fake.FakeNews;

import java.util.List;

public class FakeNewsAdapter extends ArrayAdapter<FakeNews> {

    Context context;
    int resource;

    private List<FakeNews>items;
    private FakeNews fakeNews;

    public FakeNewsAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<FakeNews> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.items=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        Holder holder = new Holder();
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource, parent, false);
            holder.tvTitle=(TextView)view.findViewById(R.id.title);
            view.setTag(holder);
        }else {
            holder=(Holder)view.getTag();
        }

        fakeNews=items.get(position);

        holder.tvTitle.setText(fakeNews.title);

        return view;
    }

    private class Holder{
        TextView tvTitle;
    }
}
