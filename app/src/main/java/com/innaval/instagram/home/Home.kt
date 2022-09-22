package com.innaval.instagram.home

import com.innaval.instagram.common.base.BasePresenter
import com.innaval.instagram.common.base.BaseView
import com.innaval.instagram.common.model.Post

interface Home {

    interface Presenter : BasePresenter {
        fun fetchFeed()
        fun clear()
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayRequestFailure(message: String)
        fun displayEmptyPosts()
        fun displayFullPosts(posts: List<Post>)
    }

}