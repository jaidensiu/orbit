package com.jaidensiu.orbit.catalog

import kotlin.js.JsExport
import kotlin.native.ObjCName

@JsExport
@ObjCName(name = "WorldIdTab", exact = true)
enum class WorldIdTab(val value: String) {
    @ObjCName(swiftName = "credentials")
    Credentials(value = "credentials"),

    @ObjCName(swiftName = "forHumans")
    ForHumans(value = "for_humans"),

    @ObjCName(swiftName = "notifications")
    Notifications(value = "notifications"),
}
