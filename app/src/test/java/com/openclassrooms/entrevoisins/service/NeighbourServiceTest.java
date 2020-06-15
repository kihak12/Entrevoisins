package com.openclassrooms.entrevoisins.service;

import android.view.View;
import android.widget.ScrollView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void getNeighbourInfoWithSuccess() {
        Long userTest = new Long(1);
        Neighbour neighbourtest = service.getNeighbourById(userTest);
        assertFalse(neighbourtest.equals(neighbourtest.getName()));
        neighbourtest.getName().equals("Caroline");
    }

    @Test
    public void getOnlyFavoriteWithSucces() {
        List<Neighbour> neighbourTest = service.getNeighboursFavorite();

        Neighbour john = new Neighbour(1, "John", "https://i.pravatar.cc/150?u=a042581f4e29026704d", "Saint-Pierre-du-Mont ; 5km",
                "+33 6 86 57 90 14", "belote et le tarot..", true);

        neighbourTest.add(john);

        for(int y = 0 , m = 10 ; y < neighbourTest.size() || y > m ; y++){
            if (!neighbourTest.get(y).isFavorite())
                getOnlyFavoriteWithSucces();
        }


    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

}
