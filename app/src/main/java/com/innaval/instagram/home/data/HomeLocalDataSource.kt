package com.innaval.instagram.home.data

import com.innaval.instagram.common.base.Cache
import com.innaval.instagram.common.base.RequestCallback
import com.innaval.instagram.common.model.Database
import com.innaval.instagram.common.model.Post
import com.innaval.instagram.common.model.UserAuth
import java.lang.RuntimeException

class HomeLocalDataSource (private val feedCache: Cache<List<Post>>) : HomeDataSource {

    override fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>) {
        val posts = feedCache.get(userUUID)
        if (posts != null) {
            callback.onSuccess(posts)
        } else {
            callback.onFailure("posts não existem")
        }
        callback.onComplete()
    }

    override fun fetchSession(): UserAuth {
        return Database.sessionAuth ?: throw RuntimeException("usuário não logado!!!")
    }

    override fun putFeed(response: List<Post>?) {
        feedCache.put(response)
    }

}