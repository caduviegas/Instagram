package com.innaval.instagram.home.data

import com.innaval.instagram.common.base.Cache
import com.innaval.instagram.common.model.Post

class HomeDataSourceFactory (
    private val feedCache: Cache<List<Post>>,
) {

    fun createLocalDataSource(): HomeDataSource {
        return HomeLocalDataSource(feedCache)
    }

    fun createFromFeed(): HomeDataSource {
        if (feedCache.isCached()) {
            return HomeLocalDataSource(feedCache)
        }
        return HomeFakeRemoteDataSource()
    }

}