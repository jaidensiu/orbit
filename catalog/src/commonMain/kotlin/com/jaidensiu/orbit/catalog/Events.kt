package com.jaidensiu.orbit.catalog

import kotlin.js.JsExport
import kotlin.native.ObjCName

@JsExport
@ObjCName(name = "TabClicked", exact = true)
data class TabClicked(
    val tab: WorldIdTab,
) : AnalyticsEvent(
    name = "tab_clicked",
    properties = mapOf("tab" to tab.value),
)
