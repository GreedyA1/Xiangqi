/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.alphaxiangqi;

import static org.junit.Assert.assertEquals;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;

/**
 * @author Vato
 *
 */
public class AlphaXiangqiBoard{

	AlphaXiangqiBoardCoordinate [][] board;
	
	private AlphaXiangqiBoard()
	{
		board = new AlphaXiangqiBoardCoordinate [3][3];
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				board[i][j] = AlphaXiangqiBoardCoordinate.makeBoardCoordinate(i, j, XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE));
			}
		}
		placePiecesOnBoard();
	}
	
	public static AlphaXiangqiBoard makeGameBoard(){
		return new AlphaXiangqiBoard();
	}
	
	private void placePiecesOnBoard(){
		board[0][0] = AlphaXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.GENERAL, XiangqiColor.RED));
		board[2][2] = AlphaXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.GENERAL, XiangqiColor.BLACK));
	}
	
	public String movePiece(XiangqiCoordinate source, XiangqiCoordinate destination){
		String message = "OK";
		XiangqiPiece tempPiece = board[source.getRank()][source.getFile()].piece;
		printBoard();
		System.out.println("destination is " + destination.getRank() + destination.getFile() + "source is " + source.getRank()+ source.getFile() );
		
		///Checking if it's legal
		if(isLegal(source,destination) != "legal") return "Illegal";
		
		if(tempPiece.getColor() == XiangqiColor.RED){
			if(destination.getFile() == findGeneral(XiangqiColor.BLACK).getFile() || destination.getRank() == findGeneral(XiangqiColor.BLACK).getRank()){
				message = "Black wins";
			}
		}
		else if(tempPiece.getColor() == XiangqiColor.BLACK){
			System.out.println("destination is "+ destination.getRank() + destination.getFile() + "findGeneral is " + findGeneral(XiangqiColor.RED).getRank() + findGeneral(XiangqiColor.RED).getFile());
			System.out.println("");
			if(destination.getFile() == findGeneral(XiangqiColor.RED).getFile() || destination.getRank() == findGeneral(XiangqiColor.RED).getRank()){
				message = "RED wins";
			}
		}
		
		///Moving
		board[destination.getRank()][destination.getFile()].moveToBoardCoordinate(tempPiece);
		board[source.getRank()][source.getFile()].moveFromBoardCoordinate();

		
		printBoard();
		return message;
	}
	
	private XiangqiCoordinate findGeneral(XiangqiColor color){
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				if(board[i][j].piece.getPieceType() == XiangqiPieceType.GENERAL && board[i][j].piece.getColor() == color){
					System.out.println(color + "[" + i +  "]" +"["+ j + "]");
					return AlphaXiangqiCoordinateImpl.makeCoordinate(i, j);
				}
			}
		}
		return null;
	}
	
	public AlphaXiangqiBoardCoordinate getBoardCoordinateAt(XiangqiCoordinate coordinate){
		return board[coordinate.getFile()][coordinate.getRank()];
	}
	
	public XiangqiPiece getPieceAt(XiangqiCoordinate coordinate){
		return board[coordinate.getFile()][coordinate.getRank()].getPiece();
	}
	
	public void printBoard(){
		for(int l = 0;l<3;l++){
			for(int j = 0;j<3;j++){
				System.out.print(" [ " + board[l][j].piece.getColor() + " ] ");
			}
			System.out.println("");
		}
		System.out.println("--------------------");
	}
	
	
	public String isLegal(XiangqiCoordinate source, XiangqiCoordinate destination){
		if(java.lang.Math.abs(destination.getFile()-source.getFile()) + java.lang.Math.abs(destination.getRank()-source.getRank()) != 1){
			System.out.println(java.lang.Math.abs(destination.getFile()-source.getFile()) + java.lang.Math.abs(destination.getRank()-source.getRank()));
			System.out.println("TOO MUCH DISTANCE");
			return "Too much distance!";
		}
		else if(source.getFile() > 2 || source.getRank() > 2 || destination .getRank() > 2 || destination.getFile() > 2
				|| source.getFile() < 0 || source.getRank() < 0 || destination .getRank() < 0 || destination.getFile() < 0){
			System.out.println("Illegal Coordinate");
			return "Illegal Coordinate";
		}
		return "legal";
	}
}