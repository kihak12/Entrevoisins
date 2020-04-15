package com.openclassrooms.entrevoisins.service;

import android.content.Context;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourFavoriteFragment;

import java.util.Currency;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    public List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    public void setNeighbours(List<Neighbour> neighbours) {
        this.neighbours = neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }


    @Override
    public List getNeighboursFavorite() {
        List<Neighbour> neighboursFavoriteList = new List<Neighbour>;


        for (int i = 0; i< neighbours.size(); i++)
        {
            neighbours.get(i);

            if(neighbours.get(i).isFavorite())
            {
                neighboursFavoriteList.add(neighbours.get(i));
            }

        }

        return neighboursFavoriteList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }
}
