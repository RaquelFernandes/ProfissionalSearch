package br.iesb.profissionalsearch.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import br.iesb.profissionalsearch.Models.AreaAtuacao;
import br.iesb.profissionalsearch.R;

/**
 * Created by 1514290042 on 02/06/2017.
 */

public class AreaAtuacaoRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<AreaAtuacao> lstAtuacao;

    public AreaAtuacaoRecycleViewAdapter(){

    }

    public void atualizarDados(List<AreaAtuacao> lista) {
        this.lstAtuacao = lista;
        notifyDataSetChanged();
    }

    public AreaAtuacaoRecycleViewAdapter(Context context, List<AreaAtuacao> lst) {
        this.context = context;
        this.lstAtuacao = lst;
    }

    @Override
    public AreaAtuacaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.celula_lista_nome, parent, false);
        return new AreaAtuacaoViewHolder(view);
    }


    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        AreaAtuacao areaAtuacao = lstAtuacao.get(position);
        AreaAtuacaoViewHolder viewHolder = (AreaAtuacaoViewHolder) holder;
        viewHolder.id.setText(areaAtuacao.getNome());
        viewHolder.nome.setText(areaAtuacao.getNome());
    }

    @Override
    public int getItemCount() {
        return lstAtuacao.size();
    }
}
