package com.coen.mad_w6_recipe.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentActivity
import com.coen.mad_w6_recipe.R
import com.coen.mad_w6_recipe.api.FoodAPI
import com.coen.mad_w6_recipe.api.FoodAPIService
import com.coen.mad_w6_recipe.model.APISearchResponse
import com.coen.mad_w6_recipe.model.Recipe
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity  : FragmentActivity() {

    private lateinit var recipeAdapter: RecipeAdapter
    private var recipes = ArrayList<Recipe>()
    private lateinit var foodAPIService: FoodAPIService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create Pager Adatper
        recipeAdapter = RecipeAdapter(supportFragmentManager, recipes)
        pager.adapter = recipeAdapter

        // Start API Service
        foodAPIService = FoodAPI.start()
        getRecepices()
    }

    override fun onBackPressed() {
        if (pager.currentItem == 0) super.onBackPressed()
        else pager.currentItem = pager.currentItem - 1
    }



    /**
     * Get the Top Rated Recipes from the Food2Fork Api. If the recipes were retrieved successfully
     * add the recipes to the viewpager.
     */
    fun getRecepices() {
        foodAPIService.get()
            .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : SingleObserver<APISearchResponse> {
                    override fun onSuccess(response: APISearchResponse) {
                        response.recipes?.let {
                            recipes.addAll(it)
                            recipeAdapter.notifyDataSetChanged()
                        }
                    }
                    override fun onError(e: Throwable) { sbMsg("error: " + e.message) }
                    override fun onSubscribe(d: Disposable) { sbMsg("OnSubscribe.") }
                })
    }

    fun sbMsg(msg: String) {  Snackbar.make(pager, msg, Snackbar.LENGTH_LONG).show() }
}
