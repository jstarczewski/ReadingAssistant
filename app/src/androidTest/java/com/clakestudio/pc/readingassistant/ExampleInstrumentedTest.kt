package com.clakestudio.pc.readingassistant

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.clakestudio.pc.readingassistant.addeditbook.AddEditBookActivity
import com.clakestudio.pc.readingassistant.books.BooksActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.clakestudio.pc.readingassistant", appContext.packageName)
    }

    @Rule
    @JvmField
    var booksActivityTestRule = ActivityTestRule(BooksActivity::class.java)

    @Test
    fun testFabInteraction() {
        Intents.init()
        onView(withId(R.id.fab_addBook)).perform(click())
        intended(hasComponent(AddEditBookActivity::class.java.name))
        Intents.release()
    }
}
