package com.innaval.instagram.add.data

import android.net.Uri
import com.innaval.instagram.common.base.RequestCallback
import com.innaval.instagram.common.model.UserAuth
import java.lang.UnsupportedOperationException

interface AddDataSource {

    fun createPost(userUUID: String, uri: Uri, caption: String, callback: RequestCallback<Boolean>){
        throw UnsupportedOperationException()
    }

    fun fetchSession(): UserAuth{
        throw UnsupportedOperationException()
    }
}