package com.example.bezenassignment
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecipesAdaptor(private val context: Context, private val recipes: List<recipe>) :
    RecyclerView.Adapter<RecipesAdaptor.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(recipe: recipe) {
            title.text=recipe?.Title
            prepTime.text=recipe.PrepTime
            Glide.with(context).load (recipe.Image).into(imageRecipe)
        }

        val title: TextView
        val prepTime: TextView
        val imageRecipe: ImageView
        init {
            // Define click listener for the ViewHolder's View.
            title = view.findViewById(R.id.recipeName)
            prepTime = view.findViewById(R.id.recipePrepTime)
            imageRecipe=view.findViewById(R.id.recipeImage)
        }
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_recipe, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.bind(recipes[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = recipes.size

}