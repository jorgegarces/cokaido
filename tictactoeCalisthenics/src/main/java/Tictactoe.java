enum Movement { X, O };
enum Response { NOTYOURTURN, TURNO, TURNX };

public class Tictactoe {

    public Response move(Movement movement) {

        if(movement != Movement.X) return Response.NOTYOURTURN;
        return Response.TURNO;
    }
}
