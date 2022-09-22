package com.innaval.instagram.search

import com.innaval.instagram.common.base.BasePresenter
import com.innaval.instagram.common.base.BaseView
import com.innaval.instagram.common.model.UserAuth

interface Search {

    interface Presenter : BasePresenter {
        fun fetchUsers(name: String)
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayFullUsers(users: List<UserAuth>)
        fun displayEmptyUsers()
    }
}