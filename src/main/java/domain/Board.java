package domain;

import java.util.Arrays;

import static Util.Valid.checkPlayers;

public class Board {

    private static final String VERTICAL = "|";


    private final String[][] frame;
    private final Line line;

    public Board(int players, int height) {
        checkPlayers(players);
        frame = new String[height][(players*2)-1];
        line = new Line();
    }

    public int countPlayers() {
        return frame[0].length/2+1;
    }

    public int getLadderHeight() {
        return frame.length;
    }

    public void generateFrame() {
        for (int row = 0; row < frame.length ; row++) {
            draw(row);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String[] strings : frame) {
            stringBuilder.append(Arrays.toString(strings).replaceAll("\\[|\\]|,","")).append('\n');
        }
        return stringBuilder.toString();
    }

    private void draw(int row) {
        for (int col = 0; col < getLadderHeight() ; col++) {
            frame[row][col] = drawLine(col);
        }
    }

    private String drawLine(int col) {
        if(col % 2 == 0) {
            return VERTICAL;
        }
        return line.generateRandomLine();
    }
}

