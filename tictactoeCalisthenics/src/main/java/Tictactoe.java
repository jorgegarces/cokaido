enum Movement { X, O };
enum Response { NOTYOURTURN, TURNO, TURNX };

public class Tictactoe {

    private Movement lastMove = Movement.O;

    public Response move(Movement movement) {

        if(movement == lastMove) return Response.NOTYOURTURN;
        lastMove = movement;
        return Response.TURNO;
    }
}
