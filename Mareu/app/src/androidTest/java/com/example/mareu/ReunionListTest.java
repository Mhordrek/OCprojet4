package com.example.mareu;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;

import android.content.Context;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static com.example.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;


import static org.junit.Assert.*;

import com.example.mareu.Features.Reunions.Mareu;
import com.example.mareu.Features.Reunions.ReunionActivityList;
import com.example.mareu.utils.DeleteViewAction;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ReunionListTest {



    @Rule
    public ActivityScenarioRule<ReunionActivityList> mActivityRule =
            new ActivityScenarioRule<>(ReunionActivityList.class);



    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.mareu", appContext.getPackageName());
    }

    @Test
    public void myReunionsListShouldNotBeEmpty(){
        onView(ViewMatchers.withId(R.id.list)).check(matches(hasMinimumChildCount(1)));
    }

    @Test
    public void myReunionsListShouldRemoveItem(){

        onView(ViewMatchers.withId(R.id.list)).check(withItemCount(10));
        onView(ViewMatchers.withId(R.id.list)).perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteViewAction()));
        onView(ViewMatchers.withId(R.id.list)).check(withItemCount(-1));
    }

    @Test
    public void myReunionsAddButtonShouldAddANewReunion(){

        onView(ViewMatchers.withId(R.id.floatingActionButton)).perform(click());
        onView(ViewMatchers.withId(R.id.rSubject)).perform(click()).perform(typeText("Reunion test"));
        onView(ViewMatchers.withId(R.id.multiAutoCompleteTextView)).perform(click()).perform(typeText("Amandine@lamzone.com"));
        onView(ViewMatchers.withId(R.id.validationbutton)).perform(click());

    }

    @Test
    public void myReunionFilterDateButtonIsFilteringReunions(){

        onView(ViewMatchers.withId(R.menu.filter_button)).perform(click());
        onView(ViewMatchers.withId(R.id.filter_button_date)).perform(click());
        onView(ViewMatchers.withId(R.id.date_calendar)).perform(click());



    }

    @Test
    public void myReunionFilterLocationButtonIsFilteringReunion(){



    }
}