package com.example.bezenassignment

import com.google.firebase.database.PropertyName

data class recipe(var Title:String="",
                  var SubmittedBy:String="",
                  var SubmitID:String="",
                  var Serves:String="",
                  var PrepTime:String="",
                  @get:PropertyName("Image") @set:PropertyName("Image") var Image:String?="",
                  var Ingredients: List<String>?=listOf(),
                  var Instructions: List<String>?=listOf()
)
