package progweb3.poa.ifrs.edu.navegacaosv7;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListaRecycler extends AppCompatActivity implements ClickRecycler {
    private RecyclerView recyclerView;
    MyAdapter adapter;
    private List<Pessoa> listaPessoas = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recycler);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        for(int i=0; i<5; i++)
            listaPessoas.add(Pessoa.carrega());

        adapter = new MyAdapter(this, listaPessoas, this);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria uma nova pessoa - adiciona a pessoa e avisa o adapter que o conteúdo da lista foi alterado
                listaPessoas.add(Pessoa.carrega());
                adapter.notifyDataSetChanged();

            }
        });
    }
    @Override
    public void onCustomClick(Object object) {
        Log.d("ListaRecycler", "chamou método onCustomClick");
        Pessoa p = (Pessoa) object;
        Log.d("ListaRecycler", "PEssoa = " + p.toString());
        //mostra o nome do objeto quando é selecionado na lista
        String msg = getResources().getString(R.string.mensagemClick)+ " " + p.getNome();
        Snackbar.make(findViewById(R.id.recycler_view), msg, Snackbar.LENGTH_SHORT).show();

    }
}