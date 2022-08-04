package com.example.bezenassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

private const val TAG = "RecipeActivity"
class HomeScreen : AppCompatActivity() {

    private lateinit var firestoreDB: FirebaseFirestore
    private lateinit var recipes: MutableList<recipe>
    private lateinit var adapter: RecipesAdaptor
    private lateinit var recipeRecyler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        recipeRecyler=findViewById(R.id.recipeRecycler)
        recipes=mutableListOf()
        adapter= RecipesAdaptor(this,recipes)
        recipeRecyler.adapter=adapter
        recipeRecyler.layoutManager= LinearLayoutManager(this)


        firestoreDB = FirebaseFirestore.getInstance()
        val recipeReference = firestoreDB.collection("recipes")
        recipeReference.addSnapshotListener{ snapshot, exception ->
            if (exception != null || snapshot ==null){
                Log.e(TAG,"Exception occurred", exception)
                return@addSnapshotListener
            }
            val recipeList=snapshot.toObjects(recipe::class.java)
            recipes.clear()
            recipes.addAll(recipeList)
            adapter.notifyDataSetChanged()
            for (posts in recipeList){
                Log.i(TAG,"Recipe $posts")
            }

        }
    }
}