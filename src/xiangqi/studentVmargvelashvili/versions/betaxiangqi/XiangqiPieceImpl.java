/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.betaxiangqi;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;

/**
 * @author Vato
 *
 */
public class XiangqiPieceImpl implements XiangqiPiece {

	private XiangqiColor color;
	private XiangqiPieceType pieceType;
	

	public static XiangqiPieceImpl makePiece(XiangqiPieceType pieceType, XiangqiColor color){
		return new XiangqiPieceImpl(pieceType, color);
	}
	
	private XiangqiPieceImpl(XiangqiPieceType pieceType, XiangqiColor color){
		this.pieceType = pieceType;
		this.color = color;
	}
	
	/* (non-Javadoc)
	 * @see xiangqi.common.XiangqiPiece#getColor()
	 */
	@Override
	public XiangqiColor getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	/* (non-Javadoc)
	 * @see xiangqi.common.XiangqiPiece#getPieceType()
	 */
	@Override
	public XiangqiPieceType getPieceType() {
		// TODO Auto-generated method stub
		return pieceType;
	}

	public void changePiece(XiangqiPieceType pieceType, XiangqiColor color) {
		// TODO Auto-generated method stub
		this.pieceType = pieceType;
		this.color = color;
	}
	
	public void makePieceNone(){
		this.pieceType = XiangqiPieceType.NONE;
		this.color = XiangqiColor.NONE;
	}

}
