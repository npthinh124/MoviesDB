package net.vinid.moviedb.ui.common

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
open class EventWrapper<out T>(private val content: T) {
    private var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}