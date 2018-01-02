/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.betaxiangqi;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;

/**
 * @author Vato
 *
 */
public class BetaXiangqiBoard{

	BetaXiangqiBoardCoordinate [][] board;
	int rankSize = 5;
	int fileSize = 5;
	
	private BetaXiangqiBoard()
	{
		board = new BetaXiangqiBoardCoordinate [rankSize][fileSize];
		for(int i = 0;i<rankSize;i++){
			for(int j = 0;j<fileSize;j++){
				board[i][j] = BetaXiangqiBoardCoordinate.makeBoardCoordinate(i, j, XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE));
			}
		}
		placePiecesOnBoard();
		printBoard();
	}
	
	public static BetaXiangqiBoard makeGameBoard(){
		return new BetaXiangqiBoard();
	}
	
	private void placePiecesOnBoard(){
		board[0][0] = BetaXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.RED));
		board[0][1] = BetaXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.RED));
		board[0][2] = BetaXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.GENERAL, XiangqiColor.RED));
		board[0][3] = BetaXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.RED));
		board[0][4] = BetaXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.RED));
		board[1][2] = BetaXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED));
		board[4][0] = BetaXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK));
		board[4][1] = BetaXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK));
		board[4][2] = BetaXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.GENERAL, XiangqiColor.BLACK));
		board[4][3] = BetaXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK));
		board[4][4] = BetaXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK));
		board[3][2] = BetaXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK));
	}
	
	public String movePiece(XiangqiCoordinate source, XiangqiCoordinate destination, XiangqiColor isMoving){
		String message = "OK";
		XiangqiPiece tempPiece = board[source.getRank()][source.getFile()].piece;
		
		///Checking if it's legal
		if(isLegal(source,destination) != "legal") return "Illegal";
		
		
		
		///Moving
		board[destination.getRank()][destination.getFile()].moveToBoardCoordinate(tempPiece);
		board[source.getRank()][source.getFile()].moveFromBoardCoordinate();
		message = checkFlyingGeneral(isMoving,destination);
		
		printBoard();
		return message;
	}
	
	private XiangqiCoordinate findGeneral(XiangqiColor color){
		for(int i = 0;i<rankSize;i++){
			for(int j = 0;j<fileSize;j++){
				if(board[i][j].piece.getPieceType() == XiangqiPieceType.GENERAL && board[i][j].piece.getColor() == color){
					return BetaXiangqiCoordinateImpl.makeCoordinate(i, j);
				}
			}
		}
		return null;
	}
	
	public BetaXiangqiBoardCoordinate getBoardCoordinateAt(XiangqiCoordinate coordinate){
		return board[coordinate.getFile()][coordinate.getRank()];
	}
	
	public XiangqiPiece getPieceAt(XiangqiCoordinate coordinate){
		return board[coordinate.getFile()][coordinate.getRank()].getPiece();
	}
	
	public void printBoard(){
		for(int l = 0;l<rankSize;l++){
			for(int j = 0;j<fileSize;j++){
				System.out.print(" [ " + board[l][j].piece.getPieceType() + " ] ");
			}
			System.out.println("");
		}
		System.out.println("--------------------");
	}
	
	
	public String isLegal(XiangqiCoordinate source, XiangqiCoordinate destination){
		if(board[source.getRank()][source.getFile()].getPiece().getPieceType() == XiangqiPieceType.NONE){
			System.out.println("empty source Coordinate");
			return "empty source Coordinate";
		}
		if(source.getFile() > fileSize - 1 || 
				source.getRank() > fileSize - 1 ||
				destination .getRank() > fileSize - 1 || 
				destination.getFile() > fileSize - 1 || 
				source.getFile() < 0 || 
				source.getRank() < 0 || 
				destination .getRank() < 0 || 
				destination.getFile() < 0){
			System.out.println("Illegal Coordinate");
			return "Illegal Coordinate";
		}
		
		return "legal";
	}
	
	public String isLegalForGeneral(XiangqiCoordinate source, XiangqiCoordinate destination){
		if(java.lang.Math.abs(destination.getFile()-source.getFile()) + java.lang.Math.abs(destination.getRank()-source.getRank()) != 1){
			System.out.println("TOO MUCH DISTANCE");
			return "Too much distance!";
		}
		return "OK";
	}
	
	public String isLegalForAdvisor(XiangqiCoordinate source, XiangqiCoordinate destination){
		if(java.lang.Math.abs(destination.getFile()-source.getFile()) == 1 && java.lang.Math.abs(destination.getRank()-source.getRank()) == 1){
			return "OK";
		}
		return "Wrong Advisor move";
	}
	
	public String isLegalForChariot(XiangqiCoordinate source, XiangqiCoordinate destination){
		int distance;
		if(source.getRank() == destination.getRank()){
			distance = java.lang.Math.abs(destination.getFile() - source.getFile());
			if(source.getFile() > destination.getFile()){
				for(int i = 1; i < distance; i++){
					if(board[destination.getRank()][destination.getFile() + i].getPiece().getPieceType() != XiangqiPieceType.NONE){
						return "OK";
					}
				}
			}
			if(source.getFile() < destination.getFile()){
				for(int i = 1; i < distance; i++){
					if(board[source.getRank()][source.getFile() + i].getPiece().getPieceType() != XiangqiPieceType.NONE){
						return "OK";
					}
				}
			}
		}
		if(source.getFile() == destination.getFile()){
			distance = java.lang.Math.abs(source.getRank() - destination.getRank());
			if(source.getRank() > destination.getRank()){
				System.out.println("red more");
				for(int i = 1; i < distance; i++){
					if(board[destination.getRank() + i][destination.getFile()].getPiece().getPieceType() != XiangqiPieceType.NONE){
						return "OK";
					}
				}
			}
			if(source.getRank() < destination.getRank()){
				for(int i = 1; i < distance; i++){
					if(board[source.getRank() + i][source.getFile()].getPiece().getPieceType() != XiangqiPieceType.NONE){
						return "OK";
					}
				}
			}
		}
		return "Illegal";
	}
	
	public String isLegalForSoldier(XiangqiCoordinate source, XiangqiCoordinate destination){
		if(source.getFile() == destination.getFile()){
			if(java.lang.Math.abs(destination.getRank()-source.getRank()) == 1){
				System.out.println("TOO MUCH DISTANCE");
				return "Too much distance!";
			}
		}
		return "wrong Soldier move";
	}
	
	public String checkFlyingGeneral(XiangqiColor isMoving, XiangqiCoordinate toHere){
		int redFile = findGeneral(XiangqiColor.RED).getFile();
		int blackFile = findGeneral(XiangqiColor.BLACK).getFile();
		int redRank = findGeneral(XiangqiColor.RED).getRank();
		int blackRank = findGeneral(XiangqiColor.BLACK).getRank();
		int distance;
		if(redRank == blackRank){
			if(redFile > blackFile){
				distance = java.lang.Math.abs(blackRank - redRank);
				for(int i = 1; i < distance; i++){
					if(board[blackRank][blackFile + i].getPiece().getPieceType() != XiangqiPieceType.NONE){
						return "OK";
					}
				}
				
			}
			if(redFile < blackFile){
				distance = java.lang.Math.abs(redRank - blackRank);
				for(int i = 1; i < distance; i++){
					if(board[redRank][redFile + i].getPiece().getPieceType() != XiangqiPieceType.NONE){
						return "OK";
					}
				}
				
			}
			return isMoving == XiangqiColor.RED ? "Black wins" :"RED wins";
		}
		if(redFile == blackFile){
			if(redRank > blackRank){
				System.out.println("red more");
				distance = java.lang.Math.abs(blackRank - redRank);
				for(int i = 1; i < distance; i++){
					if(board[blackRank + i][blackFile].getPiece().getPieceType() != XiangqiPieceType.NONE){
						return "OK";
					}
				}
			}
			if(redRank < blackRank){
				distance = java.lang.Math.abs(blackRank - redRank);
				for(int i = 1; i < distance; i++){
					if(board[redRank + i][redFile].getPiece().getPieceType() != XiangqiPieceType.NONE){
						return "OK";
					}
				}
			}
			System.out.println(isMoving);
			return isMoving == XiangqiColor.RED ? "Black wins" :"RED wins";
		}
		return "OK";
	}
}