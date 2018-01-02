/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.alphaxiangqi;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;

/**
 * @author Vato
 *
 */
public class AlphaXiangqiBoardCoordinate {
	XiangqiCoordinate coordinate;
	XiangqiPieceImpl piece;

	private AlphaXiangqiBoardCoordinate(XiangqiCoordinate coordinate, XiangqiPieceImpl piece)
	{
		this.coordinate = coordinate;
		this.piece = piece;
	}
	
	public static AlphaXiangqiBoardCoordinate makeBoardCoordinate(int rank, int file, XiangqiPieceImpl piece){
		return new AlphaXiangqiBoardCoordinate(AlphaXiangqiCoordinateImpl.makeCoordinate(rank, file),piece);
	}
	
	public static AlphaXiangqiBoardCoordinate makeBoardCoordinate(XiangqiCoordinate coordinate, XiangqiPieceImpl piece){
		return new AlphaXiangqiBoardCoordinate(coordinate,piece);
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
