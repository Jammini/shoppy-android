package com.shoppy.app.ui.common

import androidx.lifecycle.Observer

class Event<T>(private val content: T) {

    private var hasBeanHandled = false

    fun getContentIfNotHandled(): T? {
        return if (hasBeanHandled) {
            null
        } else {
            hasBeanHandled = true
            content
        }
    }
}

class EventObserver<T>(private val onEventUnhandledUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let {
            onEventUnhandledUnhandledContent(it)
        }
    }
}