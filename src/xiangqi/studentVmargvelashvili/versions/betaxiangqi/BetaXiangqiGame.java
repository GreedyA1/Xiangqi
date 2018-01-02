/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.betaxiangqi;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiPiece;

/**
 * @author Vato
 *
 */
public class BetaXiangqiGame implements XiangqiGame {


	boolean redTurn = true; // it's red's turn
	int boardsize = 5;
	BetaXiangqiBoard gameBoard;
	String latestMoveMessage;

	
	public BetaXiangqiGame(){
		gameBoard = BetaXiangqiBoard.makeGameBoard();
	}
	/* (non-Javadoc)
	 * @see xiangqi.common.XiangqiGame#makeMove(xiangqi.common.XiangqiCoordinate, xiangqi.common.XiangqiCoordinate)
	 */
	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		latestMoveMessage = gameBoard.movePiece(changeToBoardCoordinates(source), changeToBoardCoordinates(destination),redTurn ? XiangqiColor.RED : XiangqiColor.BLACK);
		System.out.println(latestMoveMessage);
		switch(latestMoveMessage){
		case "Illegal":
			return MoveResult.ILLEGAL;
		case "Black wins":
			redTurn = !redTurn;
			return MoveResult.BLACK_WINS;
		case "RED wins":
			redTurn = !redTurn;
			return MoveResult.RED_WINS;
		default :
			redTurn = !redTurn;
			return MoveResult.OK;
		}
	}

	/* (non-Javadoc)
	 * @see xiangqi.common.XiangqiGame#getMoveMessage()
	 */
	@Override
	public String getMoveMessage() {
		// TODO Auto-generated method stub
		return "message";
	}

	/* (non-Javadoc)
	 * @see xiangqi.common.XiangqiGame#getPieceAt(xiangqi.common.XiangqiCoordinate, xiangqi.common.XiangqiColor)
	 */
	@Override
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect) {
		return gameBoard.getPieceAt(changeToBoardCoordinates(where));
	}
	
	
	//changes coordinates for the board array [][]
	private XiangqiCoordinate changeToBoardCoordinates(XiangqiCoordinate coordinate){
		if(redTurn){
			return BetaXiangqiCoordinateImpl.makeCoordinate(coordinate.getRank() - 1, coordinate.getFile() - 1);
		}else{
			return BetaXiangqiCoordinateImpl.makeCoordinate(boardsize - coordinate.getRank(), boardsize - coordinate.getFile());
		}
	}

}
