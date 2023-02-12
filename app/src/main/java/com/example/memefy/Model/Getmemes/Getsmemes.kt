package com.example.memefy.Model.Getmemes


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Getsmemes(
    val author: String?,
    val nsfw: Boolean?,
    val postLink: String?,
    val preview: List<String?>?,
    val spoiler: Boolean?,
    val subreddit: String?,
    val title: String?,
    val ups: Int?,
    val url: String?
)