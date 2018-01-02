/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.gammaxiangqi;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiPiece;
import xiangqi.studentVmargvelashvili.versions.commonFiles.TheXiangqiCoordinateImpl;

/**
 * @author Vato
 *
 */
public class GammaXiangqiGame implements XiangqiGame {


	boolean redTurn = true; // it's red's turn
	int rankSize = 10;
	int fileSize = 9;
	GammaXiangqiBoard gameBoard;
	String latestMoveMessage;

	
	public GammaXiangqiGame(){
		gameBoard = GammaXiangqiBoard.makeGameBoard();
	}
	/* (non-Javadoc)
	 * @see xiangqi.common.XiangqiGame#makeMove(xiangqi.common.XiangqiCoordinate, xiangqi.common.XiangqiCoordinate)
	 */
	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		latestMoveMessage = gameBoard.movePiece(changeToBoardCoordinates(source), changeToBoardCoordinates(destination),redTurn ? XiangqiColor.RED : XiangqiColor.BLACK);
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
		return redTurn ? "RED " + gameBoard.latestMessage : "BLACK " + gameBoard.latestMessage;
		
	}

	/* (non-Javadoc)
	 * @see xiangqi.common.XiangqiGame#getPieceAt(xiangqi.common.XiangqiCoordinate, xiangqi.common.XiangqiColor)
	 */
	@Override
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect) {
		return (XiangqiPiece) gameBoard.getPieceAt(changeToBoardCoordinates(where,aspect));
	}
	
	
	//changes coordinates for the board array [][]
	private XiangqiCoordinate changeToBoardCoordinates(XiangqiCoordinate coordinate){
		if(redTurn){
			return TheXiangqiCoordinateImpl.makeCoordinate(coordinate.getRank() - 1, coordinate.getFile() - 1);
		}else{
			return TheXiangqiCoordinateImpl.makeCoordinate(rankSize - coordinate.getRank() , fileSize - coordinate.getFile());
		}
	}
	
	//changes coordinates for the board array [][]
	private XiangqiCoordinate changeToBoardCoordinates(XiangqiCoordinate coordinate, XiangqiColor aspect){
		if(aspect == XiangqiColor.RED){
			return TheXiangqiCoordinateImpl.makeCoordinate(coordinate.getRank() - 1, coordinate.getFile() - 1);
		}else if(aspect == XiangqiColor.BLACK){
			return TheXiangqiCoordinateImpl.makeCoordinate(rankSize - coordinate.getRank(), fileSize - coordinate.getFile());
		}
		else return TheXiangqiCoordinateImpl.makeCoordinate(0,0);
	}

}
