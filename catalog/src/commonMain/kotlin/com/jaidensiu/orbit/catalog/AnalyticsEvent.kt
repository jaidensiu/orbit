package com.jaidensiu.orbit.catalog

import kotlin.js.JsExport
import kotlin.native.ObjCName

@JsExport
@ObjCName(name = "AnalyticsEvent", exact = true)
abstract class AnalyticsEvent internal constructor(
    val name: String,
    val properties: Map<String, String> = emptyMap(),
) {
    init {
        require(value = name.isNotBlank()) {
            "event name must not be blank"
        }
        require(value = name.isSnakeCase()) {
            "event name must be snake_case, got \"$name\""
        }
        properties.forEach { (key, value) ->
            require(value = key.isNotBlank()) {
                "property key must not be blank"
            }
            require(value = key.isSnakeCase()) {
                "property key must be snake_case, got \"$key\""
            }
            require(value = value.isNotBlank()) {
                "property value for key \"$key\" must not be blank"
            }
            require(value = value.isSnakeCase()) {
                "property value for key \"$key\" must be snake_case, got \"$value\""
            }
        }
    }

    @JsExport.Ignore
    private companion object {
        val SNAKE_CASE = Regex(pattern = "^[a-z][a-z0-9]*(_[a-z0-9]+)*$")

        fun String.isSnakeCase(): Boolean {
            return matches(regex = SNAKE_CASE)
        }
    }
}
