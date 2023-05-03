package com.example.eventerplanner.domain.entity

import io.grpc.ClientStreamTracer.StreamInfo

data class Messages(
    val myMessage: String,
    val otherMessage: String
)
