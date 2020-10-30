/*
 * Copyright 2014-2020 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package io.ktor.client.utils

import io.ktor.util.*
import io.ktor.util.collections.*

internal fun <K : Any, V : Any> sharedMap(): MutableMap<K, V> {
    if (PlatformUtils.IS_NATIVE) {
        return ConcurrentMap()
    }

    return mutableMapOf()
}

internal fun <V> sharedList(): MutableList<V> {
    if (PlatformUtils.IS_NATIVE) {
        @Suppress("DEPRECATION")
        return ConcurrentList()
    }

    return mutableListOf()
}
