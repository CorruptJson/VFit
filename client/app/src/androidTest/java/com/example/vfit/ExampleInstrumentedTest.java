package com.example.vfit;

import android.content.Context;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingPolicies;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingPolicies;
import androidx.test.espresso.IdlingResource;
import android.text.format.DateUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringContains.containsString;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    String planName = "My Routine";

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.vfit", appContext.getPackageName());
    }

    @Rule
    public ActivityScenarioRule<MyFitnessPlansActivity> myPlanRule
            = new ActivityScenarioRule<>(MyFitnessPlansActivity.class);

    @Before
    public void initCreatePlan(){
        Intents.init();
    }

    @After
    public void endCreatePlan(){
        Intents.release();
    }

    @Test
    public void createPlan() {
        onView(withId(R.id.addButton)).perform(click());
        intended(hasComponent(CreateFitnessPlan.class.getName()));
        onView(withId(R.id.routine_name)).perform(typeText(planName), closeSoftKeyboard());
        onView(withId(R.id.Rmonday)).perform(typeText("Legs Routine"), closeSoftKeyboard());
        onView(withId(R.id.Rtuesday)).perform(typeText("Core Routine"), closeSoftKeyboard());
        onView(withId(R.id.Rwednesday)).perform(typeText("Arms Routine"), closeSoftKeyboard());
        onView(withId(R.id.Rthursday)).perform(typeText("Shoulders Routine"), closeSoftKeyboard());
        onView(withId(R.id.Rfriday)).perform(typeText("Back Routine"), closeSoftKeyboard());
        onView(withId(R.id.Mmonday)).perform(typeText("Protein"), closeSoftKeyboard());
        onView(withId(R.id.Mtuesday)).perform(typeText("Carbs"), closeSoftKeyboard());
        onView(withId(R.id.Mwednesday)).perform(typeText("Vegeterian"), closeSoftKeyboard());
        onView(withId(R.id.Mthursday)).perform(typeText("Protein"), closeSoftKeyboard());
        onView(withId(R.id.Mfriday)).perform(typeText("Cheat Day"), closeSoftKeyboard());
        onView(withId(R.id.create)).perform(click());
        onView(withText(planName)).perform(click());
        intended(hasComponent(UserFitnessPlans.class.getName()));
        onView((withId(R.id.returnButton))).perform(click());
    }

//    @Rule
//    public ActivityScenarioRule<MainActivity> loginRule
//            = new ActivityScenarioRule<>(MainActivity.class);
//
//    @Test
//    public void login() {
//        onView(withId(R.id.loginHeading)).check(matches(withText("Login")));
//        onView(withId(R.id.userInput)).perform(typeText("test"));
//        onView(withId(R.id.passwordInput)).perform(typeText("test"));
//        onView(withId(R.id.loginBtn)).perform(click());
//    }
}
