/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.betaxiangqi;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;

/**
 * @author Vato
 *
 */
public class BetaXiangqiBoardCoordinate {
	XiangqiCoordinate coordinate;
	XiangqiPieceImpl piece;

	private BetaXiangqiBoardCoordinate(XiangqiCoordinate coordinate, XiangqiPieceImpl piece)
	{
		this.coordinate = coordinate;
		this.piece = piece;
	}
	
	public static BetaXiangqiBoardCoordinate makeBoardCoordinate(int rank, int file, XiangqiPieceImpl piece){
		return new BetaXiangqiBoardCoordinate(BetaXiangqiCoordinateImpl.makeCoordinate(rank, file),piece);
	}
	
	public static BetaXiangqiBoardCoordinate makeBoardCoordinate(XiangqiCoordinate coordinate, XiangqiPieceImpl piece){
		return new BetaXiangqiBoardCoordinate(coordinate,piece);
	}
	
	public void moveFromBoardCoordinate(){
		this.piece.makePieceNone();
	}
	
	public void moveToBoardCoordinate(XiangqiPiece piece){
		this.piece.changePiece(piece.getPieceType(), piece.getColor());
	}
	
	public XiangqiPieceImpl getPiece(){
		return piece;
	}
	
	public XiangqiCoordinate getCoordinate(){
		return coordinate;
	}
	
}
