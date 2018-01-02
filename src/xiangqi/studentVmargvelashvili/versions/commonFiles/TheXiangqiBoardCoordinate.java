/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.commonFiles;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;

/**
 * @author Vato
 *
 */
public class TheXiangqiBoardCoordinate {
	XiangqiCoordinate coordinate;
	XiangqiPieceImpl piece;

	private TheXiangqiBoardCoordinate(XiangqiCoordinate coordinate, XiangqiPieceImpl piece)
	{
		this.coordinate = coordinate;
		this.piece = piece;
	}
	
	public static TheXiangqiBoardCoordinate makeBoardCoordinate(int rank, int file, XiangqiPieceImpl piece){
		return new TheXiangqiBoardCoordinate(TheXiangqiCoordinateImpl.makeCoordinate(rank, file),piece);
	}
	
	public static TheXiangqiBoardCoordinate makeBoardCoordinate(XiangqiCoordinate coordinate, XiangqiPieceImpl piece){
		return new TheXiangqiBoardCoordinate(coordinate,piece);
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
