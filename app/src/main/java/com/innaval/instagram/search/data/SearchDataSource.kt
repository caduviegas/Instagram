package com.innaval.instagram.search.data

import com.innaval.instagram.common.base.RequestCallback
import com.innaval.instagram.common.model.UserAuth

interface SearchDataSource {
    fun fetchUsers(name: String, callback: RequestCallback<List<UserAuth>>)
}