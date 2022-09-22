package com.innaval.instagram.home.data

import android.os.Handler
import android.os.Looper
import com.innaval.instagram.common.base.RequestCallback
import com.innaval.instagram.common.model.Database
import com.innaval.instagram.common.model.Post

class HomeFakeRemoteDataSource : HomeDataSource {

    override fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>) {
        Handler(Looper.getMainLooper()).postDelayed({

            val feed = Database.feeds[userUUID]

            callback.onSuccess(feed?.toList() ?: emptyList())

            callback.onComplete()
        }, 2000)
    }

}