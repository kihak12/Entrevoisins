
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
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
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
    public void AddFavoriteWithSuccess() {
        ViewInteraction tabView = onView(
                allOf(withContentDescription("Favorites"),
                        childAtPosition(
                                childAtPosition(
                                        allOf(withId(R.id.tabs),
                                                childAtPosition(
                                                        allOf(withId(R.id.appbar),
                                                                childAtPosition(
                                                                        withId(R.id.main_content),
                                                                        0)),
                                                        1)),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction viewPager = onView(
                allOf(withId(R.id.container),
                        childAtPosition(
                                allOf(withId(R.id.main_content),
                                        childAtPosition(
                                                allOf(withId(android.R.id.content),
                                                        childAtPosition(
                                                                allOf(withId(R.id.action_bar_root),
                                                                        childAtPosition(
                                                                                withClassName(is("android.widget.FrameLayout")),
                                                                                0)),
                                                                1)),
                                                0)),
                                1),
                        isDisplayed()));
        viewPager.perform(swipeLeft());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.list_neighbours),
                        withParent(allOf(withId(R.id.container),
                                childAtPosition(
                                        allOf(withId(R.id.main_content),
                                                childAtPosition(
                                                        allOf(withId(android.R.id.content),
                                                                childAtPosition(
                                                                        withId(R.id.list_neighbours),
                                                                        0)),
                                                        0)),
                                        1))),
                        isDisplayed()));
        recyclerView.check(doesNotExist());

        ViewInteraction tabView2 = onView(
                allOf(withContentDescription("My neighbours"),
                        childAtPosition(
                                childAtPosition(
                                        allOf(withId(R.id.tabs),
                                                childAtPosition(
                                                        allOf(withId(R.id.appbar),
                                                                childAtPosition(
                                                                        withId(R.id.main_content),
                                                                        0)),
                                                        1)),
                                        0),
                                0),
                        isDisplayed()));
        tabView2.perform(click());

        ViewInteraction viewPager2 = onView(
                allOf(withId(R.id.container),
                        childAtPosition(
                                allOf(withId(R.id.main_content),
                                        childAtPosition(
                                                allOf(withId(android.R.id.content),
                                                        childAtPosition(
                                                                allOf(withId(R.id.action_bar_root),
                                                                        childAtPosition(
                                                                                withClassName(is("android.widget.FrameLayout")),
                                                                                0)),
                                                                1)),
                                                0)),
                                1),
                        isDisplayed()));
        viewPager2.perform(swipeRight());

        ViewInteraction recyclerView2 =
                onView(allOf(withId(R.id.item_list_name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.list_neighbours),
                                        0),
                                1),
                        isDisplayed())).perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.action_favorite),
                        childAtPosition(
                                childAtPosition(
                                        allOf(withId(android.R.id.content),
                                                childAtPosition(
                                                        allOf(withId(R.id.decor_content_parent),
                                                                childAtPosition(
                                                                        withClassName(is("android.widget.FrameLayout")),
                                                                        0)),
                                                        0)),
                                        0),
                                7),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.mainMenu),
                        childAtPosition(
                                childAtPosition(
                                        allOf(withId(android.R.id.content),
                                                childAtPosition(
                                                        allOf(withId(R.id.decor_content_parent),
                                                                childAtPosition(
                                                                        withClassName(is("android.widget.FrameLayout")),
                                                                        0)),
                                                        0)),
                                        0),
                                2),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction tabView3 = onView(
                allOf(withContentDescription("Favorites"),
                        childAtPosition(
                                childAtPosition(
                                        allOf(withId(R.id.tabs),
                                                childAtPosition(
                                                        allOf(withId(R.id.appbar),
                                                                childAtPosition(
                                                                        withId(R.id.main_content),
                                                                        0)),
                                                        1)),
                                        0),
                                1),
                        isDisplayed()));
        tabView3.perform(click());

        ViewInteraction viewPager3 = onView(
                allOf(withId(R.id.container),
                        childAtPosition(
                                allOf(withId(R.id.main_content),
                                        childAtPosition(
                                                allOf(withId(android.R.id.content),
                                                        childAtPosition(
                                                                allOf(withId(R.id.action_bar_root),
                                                                        childAtPosition(
                                                                                withClassName(is("android.widget.FrameLayout")),
                                                                                0)),
                                                                1)),
                                                0)),
                                1),
                        isDisplayed()));
        viewPager3.perform(swipeLeft());

        ViewInteraction viewGroup = onView(
                allOf(withId(R.id.item_user_info),
                        childAtPosition(
                                allOf(withId(R.id.list_neighbours),
                                        withParent(allOf(withId(R.id.container),
                                                childAtPosition(
                                                        allOf(withId(R.id.main_content),
                                                                childAtPosition(
                                                                        withId(android.R.id.content),
                                                                        0)),
                                                        1)))),
                                0),
                        isDisplayed()));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction viewGroup2 = onView(
                allOf(withId(R.id.item_user_info),
                        childAtPosition(
                                allOf(withId(R.id.list_neighbours),
                                        withParent(allOf(withId(R.id.container),
                                                childAtPosition(
                                                        allOf(withId(R.id.main_content),
                                                                childAtPosition(
                                                                        withId(android.R.id.content),
                                                                        0)),
                                                        1)))),
                                0),
                        isDisplayed()));
        viewGroup2.check(matches(isDisplayed()));
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

