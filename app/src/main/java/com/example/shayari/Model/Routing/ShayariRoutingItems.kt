package com.example.shayari.Model.Routing

 sealed class ShayariRoutingItems(val route:String) {

     object  splashScreen : ShayariRoutingItems("splash")
     object  categoryScreen : ShayariRoutingItems("category")
     object  quoteScreen : ShayariRoutingItems("quote")
     object  shayriListScreen : ShayariRoutingItems("shayari")
     object  finalShayriScreen : ShayariRoutingItems("final_shayari")
     object shayariAndQuotes : ShayariRoutingItems("shayariAndQuote")
     object quoteListItem : ShayariRoutingItems("quote_list")

 }