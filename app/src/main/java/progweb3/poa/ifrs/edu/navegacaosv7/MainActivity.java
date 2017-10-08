package progweb3.poa.ifrs.edu.navegacaosv7;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar); // Vincula a toolbar ao layout
        setSupportActionBar(toolbar);                   // quando carregar a atividade vai carregar essa toolbar

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // vincula o menu a toolbar com os itens definidos no layout menubarra
        getMenuInflater().inflate(R.menu.menubarra, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.pesquisa) {
            Intent intencao = new Intent(this, ListaRecycler.class);
            startActivity(intencao);
        }
        else if( id== R.id.informacao){
            mostraDialogo();
        }

        return super.onOptionsItemSelected(item);
    }
    private void mostraDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Titulo");
        builder.setMessage("Digite aqui sua mensagem!");
        //define um botão como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this, "Você clicou no botão Ok", Toast.LENGTH_SHORT).show();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this, "Você clicou no botão Cancelar", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alerta = builder.create();
        alerta.show();//mostra a janela
    }
}
