enum Movement { X, O };
enum Response { NOTYOURTURN, TURNO, TURNX, INVALIDMOVE };

public class Tictactoe {

    private Movement lastMove = Movement.O;
    private Board board = new Board();

    public Response move(Movement movement, Cell position) {

        if(movement == lastMove) return Response.NOTYOURTURN;
        board.addPosition(position);
        lastMove = movement;
        return Response.TURNO;
    }
}