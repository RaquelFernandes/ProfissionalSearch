package br.iesb.profissionalsearch.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.iesb.profissionalsearch.R;

/**
 * Created by 1514290042 on 02/06/2017.
 */

public class AreaAtuacaoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView id;
    public TextView nome;

    public AreaAtuacaoViewHolder(View itemView) {
        super(itemView);

        this.nome = (TextView) itemView.findViewById(R.id.areaAtuacao_lista_txtNome);
        this.id = (TextView) itemView.findViewById(R.id.areaAtuacao_lista_txtId);

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) itemView.getLayoutParams();
        itemView.setLayoutParams(params);
    }

    @Override
    public void onClick(View v) {

    }
}
