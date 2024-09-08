package com.example.shayari.Model.Routing

import android.media.Image
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shayari.Catagory
import com.example.shayari.FinalShayriView
import com.example.shayari.QuoteListItem
import com.example.shayari.QuoteScreen
import com.example.shayari.ShayariAndQuotes
import com.example.shayari.ShayariListItem
import com.example.shayari.SplashScreen

@Composable
fun ShayariRouting(navHostController: NavHostController){


  NavHost(navController = navHostController, startDestination = ShayariRoutingItems.splashScreen.route){
      composable(ShayariRoutingItems.shayariAndQuotes.route){
          ShayariAndQuotes(navHostController)
      }
      composable(ShayariRoutingItems.categoryScreen.route){
          Catagory(navHostController)
      }
      composable(ShayariRoutingItems.quoteScreen.route){
          QuoteScreen(navHostController)
      }
      composable(ShayariRoutingItems.splashScreen.route)
      {
          SplashScreen(navHostController)
      }
      composable(ShayariRoutingItems.shayriListScreen.route + "/{title}")
      {
          val title = it.arguments?.getString("title")

              ShayariListItem(navHostController,title)
      }
      composable(ShayariRoutingItems.quoteListItem.route + "/{title}")
      {
          val title = it.arguments?.getString("title")

          QuoteListItem(navHostController,title)
      }
      composable(ShayariRoutingItems.finalShayriScreen.route + "/{item}"){
         val value = it.arguments?.getString("item").toString()
          FinalShayriView(value)
      }
  }
}