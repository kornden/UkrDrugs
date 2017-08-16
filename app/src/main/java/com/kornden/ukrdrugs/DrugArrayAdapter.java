package com.kornden.ukrdrugs;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kornd on 16-Aug-17.
 */

public class DrugArrayAdapter extends ArrayAdapter<Drug> {
    public DrugArrayAdapter(@NonNull Context context, @NonNull List<Drug> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Drug currentDrug = getItem(position);
        TextView drug_text = (TextView) listItemView.findViewById(R.id.drug_name);
        drug_text.setText(currentDrug.getName());
        return listItemView;
    }
}
