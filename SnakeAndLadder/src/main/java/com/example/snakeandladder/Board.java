package com.example.snakeandladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer,Integer>> positionCoordinates;
    ArrayList<Integer> snakeAndLadderPosition;

    public Board(){
        positionCoordinates = new ArrayList<>();
        populationPositionCoordinates();
        populateSnakeLadder();
    }

    private void populationPositionCoordinates(){
        positionCoordinates.add(new Pair<>(0,0)); //dummy value
        for (int i = 0; i < SnakeAndLadder.height; i++) {
            for(int j=0; j<SnakeAndLadder.width;j++){
                //x co-ordinates
                int xCord = 0;
                if(i%2==0){
                    xCord = j*SnakeAndLadder.tileSize + SnakeAndLadder.tileSize/2;
                }
                else{
                    xCord = SnakeAndLadder.tileSize * SnakeAndLadder.height - (j*SnakeAndLadder.tileSize)-SnakeAndLadder.tileSize/2;
                }
                //y co-ordinates
                int yCord = SnakeAndLadder.tileSize * SnakeAndLadder.height - (i*SnakeAndLadder.tileSize)-SnakeAndLadder.tileSize/2;
                positionCoordinates.add(new Pair<>(xCord,yCord));
            }
        }
    }

    private  void populateSnakeLadder(){
        snakeAndLadderPosition=new ArrayList<>();
        for (int i = 0; i < 101 ; i++) {
            snakeAndLadderPosition.add(i);
        }
        snakeAndLadderPosition.set(4,25);
        snakeAndLadderPosition.set(21,39);
        snakeAndLadderPosition.set(29,74);
        snakeAndLadderPosition.set(30,7);
        snakeAndLadderPosition.set(43,76);
        snakeAndLadderPosition.set(47,15);

        snakeAndLadderPosition.set(56,19);
        snakeAndLadderPosition.set(63,80);
        snakeAndLadderPosition.set(71,89);
        snakeAndLadderPosition.set(73,51);
        snakeAndLadderPosition.set(82,42);
        snakeAndLadderPosition.set(92,75);
        snakeAndLadderPosition.set(98,55);

    }

    public int getNewPosition(int currentPosition){
        if(currentPosition>0 && currentPosition<=100){
            return snakeAndLadderPosition.get(currentPosition);
        }
        return -1;
    }

    int getXCoordinate(int position){
        if(position>=1 && position <=100)
            return positionCoordinates.get(position).getKey();
        return -1;
    }

    int getYCoordinate(int position){
        if(position>=1 && position <=100)
            return positionCoordinates.get(position).getValue();
        return -1;
    }
}
