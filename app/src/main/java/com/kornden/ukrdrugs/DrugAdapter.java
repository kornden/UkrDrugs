package com.kornden.ukrdrugs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Class for placing data into RecyclerView.
 */

class DrugAdapter extends RecyclerView.Adapter<DrugAdapter.DrugViewHolder> {

    final private DrugItemClickListener drugOnClickListener;

    private int mNumberOfItems;


    private ArrayList<String[]> listOfIdsNameInn;

     interface DrugItemClickListener{
        void onDrugItemClick(int clickedDrugIndex);
    }

     DrugAdapter(ArrayList<String[]> listOfId, DrugItemClickListener listener) {
        drugOnClickListener = listener;
        mNumberOfItems = listOfId.size();
        listOfIdsNameInn = listOfId;
    }

    @Override
    public DrugViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drug_list_item,
                parent,false);
        return new DrugViewHolder(view);

    }

    @Override
    public void onBindViewHolder(DrugViewHolder holder, int position){
        String name = listOfIdsNameInn.get(position)[1];
        String inn = listOfIdsNameInn.get(position)[2];
        String consistOf = listOfIdsNameInn.get(position)[3];
        holder.drugName.setText(name);
        holder.drugINN.setText(inn);
        holder.drugConsistOf.setText(consistOf);
    }

    @Override
    public int getItemCount() {
        return mNumberOfItems;
    }

    class DrugViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{

        TextView drugName;
        TextView drugINN;
        TextView drugConsistOf;


        DrugViewHolder(View itemView) {
            super(itemView);
            drugName =  itemView.findViewById(R.id.drug_name_list_item);
            drugINN = itemView.findViewById(R.id.drug_inn_list_item);
            drugConsistOf = itemView.findViewById(R.id.drug_consistof);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            drugOnClickListener.onDrugItemClick(position);
        }
    }
}
