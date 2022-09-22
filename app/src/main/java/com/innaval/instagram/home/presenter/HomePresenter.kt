package com.innaval.instagram.home.presenter

import com.innaval.instagram.common.base.RequestCallback
import com.innaval.instagram.common.model.Post
import com.innaval.instagram.home.Home
import com.innaval.instagram.home.data.HomeRepository

class HomePresenter(
    private var view: Home.View?,
    private val repository: HomeRepository
) : Home.Presenter {

    override fun clear() {
        repository.clearCache()
    }

    override fun fetchFeed() {
        view?.showProgress(true)
        repository.fetchFeed(object : RequestCallback<List<Post>> {
            override fun onSuccess(data: List<Post>) {
                if (data.isEmpty()) {
                    view?.displayEmptyPosts()
                } else {
                    view?.displayFullPosts(data)
                }
            }

            override fun onFailure(message: String) {
                view?.displayRequestFailure(message)
            }

            override fun onComplete() {
                view?.showProgress(false)
            }
        })
    }

    override fun onDestroy() {
        view = null
    }

}