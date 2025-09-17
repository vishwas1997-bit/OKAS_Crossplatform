package com.okas.cross_platform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform