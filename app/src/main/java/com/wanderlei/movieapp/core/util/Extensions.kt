package com.wanderlei.movieapp.core.util

import com.wanderlei.movieapp.BuildConfig

fun String?.toPostUrl() = "${BuildConfig.BASE_URL_IMAGE}$this"
fun String?.toBackdropUrl() = "${BuildConfig.BASE_URL_IMAGE}$this"