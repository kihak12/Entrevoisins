package com.openclassrooms.entrevoisins.service;

import android.widget.ScrollView;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
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

        neighbourtest.getName();
        neighbourtest.getAvatarUrl();
        neighbourtest.isFavorite();
        neighbourtest.getId();
        neighbourtest.getAboutMe();
        neighbourtest.getAddress();
        neighbourtest.getPhoneNumber();

    }

    @Test
    public void getOnlyFavorite() {
        List<Neighbour> neighboursTest = service.getNeighboursFavorite();
        List<Neighbour> neighbourF = new ArrayList<Neighbour>();

        for (int i = 0; i < neighboursTest.size(); i++) {
            neighboursTest.get(i);
            if (neighboursTest.get(i).isFavorite()) {
                neighbourF.add(neighboursTest.get(i));
            }
        }
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete))
        ;
    }
}
