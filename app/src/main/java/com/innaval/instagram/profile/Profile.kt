package com.innaval.instagram.profile

import com.innaval.instagram.common.base.BasePresenter
import com.innaval.instagram.common.base.BaseView
import com.innaval.instagram.common.model.Post
import com.innaval.instagram.common.model.UserAuth


interface Profile {

    interface Presenter : BasePresenter {
        fun fetchUserProfile(uuid: String?)
        fun fetchUserPosts(uuid: String?)
        fun followUser(uuid: String?, follow: Boolean)
        fun clear()
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayUserProfile(user: Pair<UserAuth, Boolean?>)
        fun displayRequestFailure(message: String)
        fun displayEmptyPosts()
        fun displayFullPosts(posts: List<Post>)
    }

}