package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
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
    public List<Neighbour> getNeighboursFavorite() {
        List<Neighbour> neighboursFavoriteList = new ArrayList<Neighbour>();

        for (int i = 0; i< neighbours.size(); i++) {
            neighbours.get(i);
            if (neighbours.get(i).isFavorite()) {
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



    public Neighbour getNeighbourById(long userId){

        for (int i = 0; i< neighbours.size(); i++){
            if (neighbours.get(i).getId() == userId) {
                return neighbours.get(i);
            }
        }
        return null;
    }
}
