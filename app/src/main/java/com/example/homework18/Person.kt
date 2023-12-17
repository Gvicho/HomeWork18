package com.example.homework18

import com.squareup.moshi.Json

data class Person(@Json(name = "id")
                  val id:Int,
                  @Json(name = "email")
                  val email:String?,
                  @Json(name = "first_name")
                  val fName:String?,
                  @Json(name = "last_name")
                  val lName:String?,
                  @Json(name = "avatar")
                  val avatar:String?) {
}