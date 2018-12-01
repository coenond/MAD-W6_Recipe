package com.coen.mad_w6_recipe.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.coen.mad_w6_recipe.R
import com.coen.mad_w6_recipe.model.Recipe
import kotlinx.android.synthetic.main.fragment_recipe.*

class RecipeFragment : Fragment() {

    companion object {
        fun newInstance(recipe: Recipe): RecipeFragment {
            val myFragment = RecipeFragment()

            val args = Bundle()
            args.putParcelable("RECIPE_INTENT_EXTRA", recipe)
            myFragment.arguments = args

            return myFragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_recipe, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipe = arguments!!.get("RECIPE_INTENT_EXTRA") as Recipe
        tvTitle.text = recipe.title
        Glide.with(this@RecipeFragment).load(recipe.imageUrl).into(ivRecipe)
    }
}