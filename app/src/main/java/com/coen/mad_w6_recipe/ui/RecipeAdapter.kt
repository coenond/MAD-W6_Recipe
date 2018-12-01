package com.coen.mad_w6_recipe.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.coen.mad_w6_recipe.model.Recipe

class RecipeAdapter(fm: FragmentManager, val recipes: ArrayList<Recipe>) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int { return recipes.size }

    override fun getItem(position: Int): Fragment {
        return RecipeFragment.newInstance(recipes[position])
    }
}