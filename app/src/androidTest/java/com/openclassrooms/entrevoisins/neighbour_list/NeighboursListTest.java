
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.INotificationSideChannel;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowId;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;
import com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;


/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule = new ActivityTestRule<>(ListNeighbourActivity.class);


    @Test
    public void listNeighbourActivityTest() {
        onView(allOf(withId(R.id.item_list_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.list_neighbours),
                                0),
                        1),
                isDisplayed())).perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.textView1), withText("Caroline"),
                        childAtPosition(
                                childAtPosition(
                                        allOf(withId(android.R.id.content),
                                                childAtPosition(
                                                        allOf(withId(R.id.decor_content_parent),
                                                                childAtPosition(
                                                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                                                        0)),
                                                        0)),
                                        0),
                                3),
                        isDisplayed()));
        textView.check(matches(withText("Caroline")));
    }

    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(allOf(withId(R.id.item_list_delete_button),
                childAtPosition(
                        childAtPosition(withId
                                        (R.id.list_neighbours),
                                0),
                        2),
                isDisplayed()))
                .perform(click());
    }

    @Test
    public void listNeighbourDeleteFavorite() {
        onView(allOf(withId(R.id.item_list_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.list_neighbours),
                                0),
                        1),
                isDisplayed())).perform(click());

        onView(allOf(withId(R.id.action_favorite))).perform(click());
    }


        private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

