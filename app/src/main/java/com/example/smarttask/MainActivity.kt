package com.example.smarttask
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smarttask.adapter.TarefaAdapter
import com.example.smarttask.model.Tarefa
import com.example.smarttask.utils.Prefs
class MainActivity : AppCompatActivity() {
    private lateinit var recycler: RecyclerView
    private lateinit var editTarefa: EditText
    private lateinit var btnAdicionar: Button
    private lateinit var adapter: TarefaAdapter
    private lateinit var prefs: Prefs
    private var lista = mutableListOf<Tarefa>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recyclerTarefas)
        editTarefa = findViewById(R.id.editTarefa)
        btnAdicionar = findViewById(R.id.btnAdicionar)
        prefs = Prefs(this)
        lista = prefs.carregar()
        adapter = TarefaAdapter(lista) { position ->
            lista.removeAt(position)
            prefs.salvar(lista)
            adapter.notifyDataSetChanged()
        }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        btnAdicionar.setOnClickListener {
            val texto = editTarefa.text.toString()
            if (texto.isNotEmpty()) {
                lista.add(Tarefa(texto))
                prefs.salvar(lista)
                adapter.notifyDataSetChanged()
                editTarefa.text.clear()
            }
        }
    }
}