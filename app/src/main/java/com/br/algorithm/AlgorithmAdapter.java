package com.br.algorithm;

/**
 * Created by a.ricarti on 09/12/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class AlgorithmAdapter extends RecyclerView.Adapter<AlgorithmAdapter.MyViewHolder> {

    private Context mContext;
    private List<Algorithm> algorithms;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView algorithm, tipoAlgorithm, linguagem;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card);
            algorithm = (TextView) view.findViewById(R.id.tv_algorithm);
            tipoAlgorithm = (TextView) view.findViewById(R.id.tv_tipo_algorithm);
            linguagem = (TextView) view.findViewById(R.id.tv_linguagem);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), Integer.toString(view.getId()), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public AlgorithmAdapter(Context mContext, List<Algorithm> algorithms) {
        this.mContext = mContext;
        this.algorithms = algorithms;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Algorithm algorithm = algorithms.get(position);
        holder.algorithm.setText(algorithm.getAlgorithm());
        holder.tipoAlgorithm.setText(algorithm.getTipoAlgorithm());
        holder.linguagem.setText(algorithm.getLinguagem());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(view.getContext(), MainActivity.class);
                        view.getContext().startActivity(intent);
                        //getActionBar().setTitle("Test");
                }
            }
        });
    }

    /*Album album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getNumOfSongs() + " songs");

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });*/

    @Override
    public int getItemCount() {
        return algorithms.size();
    }
}
