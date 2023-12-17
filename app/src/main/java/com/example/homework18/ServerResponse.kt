package com.example.homework18

import com.squareup.moshi.Json

data class ServerResponse(@Json(name = "page")
                          val page:Int,
                          @Json(name = "per_page")
                          val perPage:Int,
                          @Json(name = "total")
                          val total:Int,
                          @Json(name = "total_pages")
                          val totalPages:Int,
                          @Json(name = "data")
                          val data:List<Person>,
                          @Json(name = "support")
                          val support:Support ) {
}

data class Support(@Json(name = "url")
                   val url:String,
                   @Json(name = "text")
                   val text:String)