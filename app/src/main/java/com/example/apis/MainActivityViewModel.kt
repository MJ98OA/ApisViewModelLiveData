package com.example.apis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import java.io.IOException

class MainActivityViewModel : ViewModel() {

    private val _responseText by lazy { MediatorLiveData<PlanetResponse>() }
    val responseText: LiveData<PlanetResponse>
        get() = _responseText

    suspend fun setResponseTextInMainThread(value: PlanetResponse) = withContext(Dispatchers.Main) {
        _responseText.value = value
    }

    fun getPlanet() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                val client = OkHttpClient()


                val request = Request.Builder()
                request.url("https://swapi.dev/api/planets/")


                val call = client.newCall(request.build())
                call.enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        println(e.toString())

                    }

                    override fun onResponse(call: Call, response: Response) {
                        println(response.toString())
                        response.body?.let { responseBody ->
                            val body = responseBody.string()
                            println(body)
                            val gson = Gson()

                            val planet = gson.fromJson(body, PlanetResponse::class.java)

                            CoroutineScope(Dispatchers.Main).launch {
                                setResponseTextInMainThread(planet)

                            }

                        }
                    }
                })
            }
        }
    }


}