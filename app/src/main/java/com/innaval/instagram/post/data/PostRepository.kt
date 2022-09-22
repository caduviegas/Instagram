package com.innaval.instagram.post.data

class PostRepository(private val dataSource: PostDataSource) {

    suspend fun fetchPictures() = dataSource.fetchPictures()

}