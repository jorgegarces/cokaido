enum Movement { X, O, NONE };
enum Response { NOTYOURTURN, TURNO, TURNX, INVALIDMOVE, YOUWIN };

public class Tictactoe {

    private Movement lastMove = Movement.O;
    private Board board = new Board();

    public Response move(Movement movement, Cell position) {

        if(movement == lastMove) return Response.NOTYOURTURN;
        board.addPosition(position, movement);
        lastMove = movement;
        return checkWinner();
    }

    public Response checkWinner() {
        if(board.getMovementFromGivenPosition(Cell.ZERO)==
        board.getMovementFromGivenPosition(Cell.ONE) && board.getMovementFromGivenPosition(Cell.ONE) ==
        board.getMovementFromGivenPosition(Cell.TWO)) return Response.YOUWIN;
        return Response.TURNO;
    }
}