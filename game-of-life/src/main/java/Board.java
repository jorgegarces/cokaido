import java.util.*;

public class Board {
    public Map<Position, Cell> grid = new HashMap<>();

    public void addCell(Cell cell, Position position){
        if (!grid.containsKey(position))
            this.grid.put(position, cell);
    }

    List<Position> neighbors;
    public void checkGrid(){
        if (grid.size() <= 2) grid.clear();
        for(Position coord : grid.keySet()) {
            neighbors = coord.neighbors();
            if (algo.comparar.size() < 2) grid.coord.laborro()
        }
    }

    public List<Position> comparar(){
        List<Position> live = new ArrayList<>();
        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < neighbors.size(); j++) {
                if (neighbors.toArray()[j] = grid.keySet().toArray()[i]){
                    live.add(grid.keySet().toArray());
                }
            }
        }

        return live;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(grid, board.grid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grid);
    }
}