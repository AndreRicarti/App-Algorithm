package com.br.algorithm;

/**
 * Created by a.ricarti on 09/12/2016.
 */

import android.content.Context;
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

        public MyViewHolder(View view) {
            super(view);
            algorithm = (TextView) view.findViewById(R.id.tv_algorithm);
            tipoAlgorithm = (TextView) view.findViewById(R.id.tv_tipo_algorithm);
            linguagem = (TextView) view.findViewById(R.id.tv_linguagem);
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
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Algorithm algorithm = algorithms.get(position);
        holder.algorithm.setText(algorithm.getAlgorithm());
        holder.tipoAlgorithm.setText(algorithm.getTipoAlgorithm());
        holder.linguagem.setText(algorithm.getLinguagem());
    }

    @Override
    public int getItemCount() {
        return algorithms.size();
    }
}
