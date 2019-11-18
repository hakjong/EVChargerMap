package com.kgp.evchargermap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.ChargerApi
import com.kgp.evchargermap.data.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    lateinit var compositeDisposable : CompositeDisposable
    val TAG = "MainActivity kgp"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            ChargerApi.getRepoList(3, 1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe({r: Response ->

                for(item in r.body!!.items!!.itemList){
                    Log.d(TAG, item.addr)
                }

            },
                {error :Throwable ->

                    Log.d(TAG, "\u0073\u0065\u0078")
                    Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
                }
            ))
    }
    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}
