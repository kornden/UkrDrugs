package com.kornden.ukrdrugs;

import android.content.Context;
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
    /** resource ID for layout is set to 0, because we'll define our own layout in getView method
     *
     * @param context use YOUR_ACTIVITY.this
     * @param objects Must be List of Drug Objects
     */
    public DrugArrayAdapter(@NonNull Context context, @NonNull List<Drug> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    /**
     *
     * @param position - this is current position of your layout;
     * @param convertView - this is View, where your single Drug object will be displayed;
     * @param parent - parent of your converView;
     */
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.drug_item, parent, false);
        }
        Drug currentDrug = getItem(position);
        TextView drug_text = (TextView) listItemView.findViewById(R.id.drug_name);
        drug_text.setText(currentDrug.getName());
        TextView drug_latin = (TextView) listItemView.findViewById(R.id.drug_latin);
        drug_latin.setText(currentDrug.getLatinName());
        TextView drug_dozes = (TextView) listItemView.findViewById(R.id.drug_dozes);
        drug_dozes.setText(currentDrug.getDozes());
        return listItemView;
    }
}
