package com.jaidensiu.orbit.catalog

import kotlin.test.Test
import kotlin.test.assertFailsWith

class AnalyticsEventTest {
    private class TestEvent(
        name: String,
        properties: Map<String, String> = emptyMap(),
    ) : AnalyticsEvent(name = name, properties = properties)

    @Test
    fun testAcceptsSnakeCaseNames() {
        listOf("a", "tab_clicked", "screen_2_viewed", "v2").forEach { name ->
            TestEvent(name = name)
        }
    }

    @Test
    fun testAcceptsSnakeCaseProperties() {
        TestEvent(
            name = "tab_clicked",
            properties = mapOf("tab" to "for_humans", "screen_2" to "v2"),
        )
    }

    @Test
    fun testRejectsBlankNames() {
        listOf("", " ", "   ").forEach { name ->
            assertFailsWith<IllegalArgumentException>(message = "expected \"$name\" to be rejected") {
                TestEvent(name = name)
            }
        }
    }

    @Test
    fun testRejectsNonSnakeCaseNames() {
        listOf(
            "Tab_Clicked",
            "tabClicked",
            "tab clicked",
            "_tab_clicked",
            "tab_clicked_",
            "tab__clicked",
            "2_tabs_clicked",
            " 3_tabs_clicked",
            "4_tabs_clicked ",
        ).forEach { name ->
            assertFailsWith<IllegalArgumentException>(message = "expected \"$name\" to be rejected") {
                TestEvent(name = name)
            }
        }
    }

    @Test
    fun testRejectsBlankPropertyKeys() {
        listOf("", " ").forEach { key ->
            assertFailsWith<IllegalArgumentException>(message = "expected key \"$key\" to be rejected") {
                TestEvent(name = "tab_clicked", properties = mapOf(key to "for_humans"))
            }
        }
    }

    @Test
    fun testRejectsBlankPropertyValues() {
        listOf("", " ").forEach { value ->
            assertFailsWith<IllegalArgumentException>(message = "expected value \"$value\" to be rejected") {
                TestEvent(name = "tab_clicked", properties = mapOf("tab" to value))
            }
        }
    }

    @Test
    fun testRejectsNonSnakeCasePropertyKeys() {
        listOf("Tab", "tabName", "tab name", "_tab", "tab_", "ta__b", "2_tab", " tab", "tab ").forEach { key ->
            assertFailsWith<IllegalArgumentException>(message = "expected key \"$key\" to be rejected") {
                TestEvent(name = "tab_clicked", properties = mapOf(key to "for_humans"))
            }
        }
    }

    @Test
    fun testRejectsNonSnakeCasePropertyValues() {
        listOf(
            "ForHumans",
            "forHumans",
            "for humans",
            "_for_humans",
            "for_humans_",
            "for__humans",
            "2_humans",
            " for_humans",
            "for_humans ",
        ).forEach { value ->
            assertFailsWith<IllegalArgumentException>(message = "expected value \"$value\" to be rejected") {
                TestEvent(name = "tab_clicked", properties = mapOf("tab" to value))
            }
        }
    }
}
