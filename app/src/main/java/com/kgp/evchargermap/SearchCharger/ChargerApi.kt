package com.example.myapplication

import com.kgp.evchargermap.data.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

class ChargerApi {
    interface GithubApiImpl{
        @GET("service/EvInfoServiceV2/getEvSearchList")
        fun getRepoList(@Query("ServiceKey") ServiceKey:String,
                        @Query("numOfRows")  numOfRows: Int,
                        @Query("pageNo") pageNo: Int,
                        @Query("addr") addr: String? = null) : Observable<Response>
    }

    companion object{
        val ServiceKey="NdpzcKQjQikAi/2cpUczluQvMs57Kk1Q0tMeaWPjHJ8C2xWByb4YE0LmEr9zFJ57p/KD+Om2JSgryfbDN2ELdQ=="
        fun getRepoList(numOfRows:Int, pageNo:Int, addr : String? = null ): Observable<Response>{
            return RetrofitCreator.create(GithubApiImpl::class.java).getRepoList(ServiceKey, numOfRows, pageNo, addr)
        }
    }

}