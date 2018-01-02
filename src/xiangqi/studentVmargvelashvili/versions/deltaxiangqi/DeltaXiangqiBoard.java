/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.deltaxiangqi;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentVmargvelashvili.versions.commonFiles.TheXiangqiBoardCoordinate;
import xiangqi.studentVmargvelashvili.versions.commonFiles.TheXiangqiCoordinateImpl;
import xiangqi.studentVmargvelashvili.versions.commonFiles.XiangqiPieceImpl;

/**
 * @author Vato
 *
 */
public class DeltaXiangqiBoard{

	TheXiangqiBoardCoordinate [][] board;
	int rankSize = 10;
	int fileSize = 9;
	String latestMessage = "";
	
	private DeltaXiangqiBoard()
	{
		board = new TheXiangqiBoardCoordinate [rankSize][fileSize];
		for(int i = 0;i<rankSize;i++){
			for(int j = 0;j<fileSize;j++){
				board[i][j] = TheXiangqiBoardCoordinate.makeBoardCoordinate(i, j, XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE));
			}
		}
		placePiecesOnBoard();
		//printBoard(); 											//ENABLE TO SEE THE MOVES
	}
	
	/**
	 * @return
	 */
	public static DeltaXiangqiBoard makeGameBoard(){
		return new DeltaXiangqiBoard();
	}
	
	private void placePiecesOnBoard(){
		board[0][0] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.RED));
		board[0][1] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.HORSE, XiangqiColor.RED));
		board[0][2] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.ELEPHANT, XiangqiColor.RED));
		board[0][3] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.RED));
		board[0][4] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.GENERAL, XiangqiColor.RED));
		board[0][5] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.RED));
		board[0][6] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.ELEPHANT, XiangqiColor.RED));
		board[0][7] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.HORSE, XiangqiColor.RED));
		board[0][8] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.RED));
		board[3][0] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED));
		board[3][2] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED));
		board[3][4] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED));
		board[3][6] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED));
		board[3][8] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED));
		board[2][1] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.CANNON, XiangqiColor.RED));
		board[2][7] = TheXiangqiBoardCoordinate.makeBoardCoordinate(0, 0, XiangqiPieceImpl.makePiece(XiangqiPieceType.CANNON, XiangqiColor.RED));
		board[9][0] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK));
		board[9][1] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.HORSE, XiangqiColor.BLACK));
		board[9][2] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.ELEPHANT, XiangqiColor.BLACK));
		board[9][3] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK));
		board[9][4] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.GENERAL, XiangqiColor.BLACK));
		board[9][5] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK));
		board[9][6] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.ELEPHANT, XiangqiColor.BLACK));
		board[9][7] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.HORSE, XiangqiColor.BLACK));
		board[9][8] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK));
		board[6][0] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK));
		board[6][2] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK));
		board[6][4] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK));
		board[6][6] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK));
		board[6][8] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK));
		board[7][1] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.CANNON, XiangqiColor.BLACK));
		board[7][7] = TheXiangqiBoardCoordinate.makeBoardCoordinate(2, 2, XiangqiPieceImpl.makePiece(XiangqiPieceType.CANNON, XiangqiColor.BLACK));
	}
	
	/**
	 * @param source
	 * @param destination 
	 * @param isMoving color that makes the move
	 * @return returns the move result string
	 */
	public String movePiece(XiangqiCoordinate source, XiangqiCoordinate destination, XiangqiColor isMoving){
		String message = "OK";
		XiangqiPiece tempPiece;
		XiangqiColor isAttacked = XiangqiColor.NONE; // Determining attacked side and attacking side
		if(isMoving == XiangqiColor.BLACK ){
			isAttacked = XiangqiColor.RED;
		}
		else if(isMoving == XiangqiColor.RED){
			isAttacked = XiangqiColor.BLACK;
		}
		if(checkOutsideBoard(source,destination) != "OK") return "Illegal";
				
		tempPiece = board[source.getRank()][source.getFile()].getPiece();
		
		///Checking if it's legal
		if(isLegal(source,destination,tempPiece) != "legal") return "Illegal";
		//check if General was killed
		if(findGeneral(isAttacked).getFile() == destination.getFile() && findGeneral(isAttacked).getRank() == destination.getRank()){
			return (isMoving == XiangqiColor.BLACK) ? "Black wins" : "RED wins"; 
		}
		
		///Moving
		board[destination.getRank()][destination.getFile()].moveToBoardCoordinate(tempPiece);
		board[source.getRank()][source.getFile()].moveFromBoardCoordinate();
		message = checkFlyingGeneral(isMoving,destination);
		
		//print board
		printBoard();
		return message;
	}
	

	/**
	 * @param color
	 * @return returns the coordintes for the General of the color 
	 */
	private XiangqiCoordinate findGeneral(XiangqiColor color){
		for(int i = 0;i<rankSize;i++){
			for(int j = 0;j<fileSize;j++){
				if(board[i][j].getPiece().getPieceType() == XiangqiPieceType.GENERAL && board[i][j].getPiece().getColor() == color){
					return TheXiangqiCoordinateImpl.makeCoordinate(i, j);
				}
			}
		}
		return null;
	}
	
	private String checkOutsideBoard(XiangqiCoordinate source,XiangqiCoordinate destination){
		if(source.getFile() > fileSize - 1 ||  // checks if coordinates are on board
				source.getRank() > rankSize - 1 ||
				destination .getRank() > rankSize - 1 || 
				destination.getFile() > fileSize - 1 || 
				source.getFile() < 0 || 
				source.getRank() < 0 || 
				destination .getRank() < 0 || 
				destination.getFile() < 0){
			latestMessage = "Illegal Coordinate";
			return "Illegal Coordinate";
		}
		else return "OK";
	}
	
	/**
	 * @param coordinate
	 * @return
	 */
	public TheXiangqiBoardCoordinate getBoardCoordinateAt(XiangqiCoordinate coordinate){
		return board[coordinate.getFile()][coordinate.getRank()];
	}
	
	/**
	 * @param coordinate
	 * @return returns getPiece() at given coordinate
	 */
	public XiangqiPiece getPieceAt(XiangqiCoordinate coordinate){
		return (XiangqiPiece) board[coordinate.getRank()][coordinate.getFile()].getPiece();
	}
	
	/**
	 * prints the board in console
	 */
	private void printBoard(){
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		for(int l = 0;l<rankSize;l++){
			for(int j = 0;j<fileSize;j++){
				if(board[l][j].getPiece().getPieceType() != XiangqiPieceType.NONE){
				System.out.print(" [ " + board[l][j].getPiece().getPieceType() + " ] ");
				}
				else System.out.print(" [ " + "   -   " + " ] ");
			}
			System.out.println("");
			if(l == 4) {
				System.out.println("------------------------------------------------------------------------------------------------------------------");
				System.out.println("------------------------------------------------RIVER-------------------------------------------------------------");
				System.out.println("------------------------------------------------------------------------------------------------------------------");
				
			}
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	
	/**
	 * @param source
	 * @param destination
	 * @param isMoving the XiangqiPiece that is making move
	 * @return Checks general legal rules and getPiece() rules and returns the message (legal or illegal)
	 */
	private String isLegal(XiangqiCoordinate source, XiangqiCoordinate destination, XiangqiPiece isMoving){
		if(board[source.getRank()][source.getFile()].getPiece().getPieceType() == XiangqiPieceType.NONE){// checks if the source coordinate is empty
			latestMessage = "empty source Coordinate";
			return "empty source Coordinate";
		}
		if(isMoving.getColor() == board[destination.getRank()][destination.getFile()].getPiece().getColor()){// checks if the own getPiece() is targeted
			latestMessage = "Can't kill own pieces";
			return "Can't kill own pieces";
		}
		

		switch(isMoving.getPieceType()){ // checks each getPiece() legal rules
			case CHARIOT:
				System.out.println("GOT HEREeee");
				if(isLegalForChariot(source, destination) != "OK") return "Illegal";
				break;
			case ADVISOR:
				if(isLegalForAdvisor(source, destination, isMoving.getColor()) != "OK") return "Illegal";
				break;
			case GENERAL:
				if(isLegalForGeneral(source, destination, isMoving.getColor()) != "OK") return "Illegal";
				break;
			case ELEPHANT:
				if(isLegalForElephant(source, destination, isMoving.getColor()) != "OK") return "Illegal";
				break;
			//case CANNON:
				//if(isLegalForCannon(source, destination) != "OK") return "Illegal";
				//break;
			case SOLDIER:
				if(isLegalForSoldier(source, destination, isMoving.getColor()) != "OK") return "Illegal";
				break;
			//case HORSE:
				//if(isLegalForHorse(source, destination) != "OK") return "Illegal";
				//break;
			case NONE:
				//if(isLegalForGeneral(source, destination) != "OK") return "Illegal";
				break;
		}
		latestMessage = "Move was legal";
		return "legal";
	}
	
	/**
	 * @param source
	 * @param destination
	 * @param color that made the move
	 * @return returns "OK" or reason for not being legal
	 */
	private String isLegalForGeneral(XiangqiCoordinate source, XiangqiCoordinate destination, XiangqiColor color){
		if(color == XiangqiColor.RED){ //checks if in castle coordinates
			if(destination.getFile() > 5 || destination.getFile() < 3 || destination.getRank() > 2){
				latestMessage = "not in the castle";
				return "not in the castle";
			}
		}
		if(color == XiangqiColor.BLACK){ //checks if in castle coordinates
			if(destination.getFile() > 5 || destination.getFile() < 3 || destination.getRank() < 7){
				latestMessage = "not in the castle";
				return "not in the castle";
			}
		} //checks if general makes correct move 
		if(java.lang.Math.abs(destination.getFile()-source.getFile()) + java.lang.Math.abs(destination.getRank()-source.getRank()) != 1){
			latestMessage = "TOO MUCH DISTANCE";
			return "Too much distance!";
		}
		return "OK";
	}
	
	/**
	 * @param source
	 * @param destination
	 * @param color that made the move
	 * @return returns "OK" or reason for not being legal
	 */
	private String isLegalForAdvisor(XiangqiCoordinate source, XiangqiCoordinate destination, XiangqiColor color){
		if(color == XiangqiColor.RED){//checks if in castle coordinates
			if(destination.getFile() > 5 || destination.getFile() < 3 || destination.getRank() > 2){
				latestMessage = "not in the castle";
				return "not in the castle";
			}
		}
		if(color == XiangqiColor.BLACK){//checks if in castle coordinates
			if(destination.getFile() > 5 || destination.getFile() < 3 || destination.getRank() < 7){
				latestMessage = "not in the castle";
				return "not in the castle";
			}
		}
		if(java.lang.Math.abs(destination.getFile()-source.getFile()) == 1 && java.lang.Math.abs(destination.getRank()-source.getRank()) == 1){ // checks if its making correct move
			return "OK";
		}
		
		latestMessage = "Wrong Advisor move";
		return "Wrong Advisor move";
	}
	
	/**
	 * @param source
	 * @param destination
	 * @param color that made the move
	 * @return returns "OK" or reason for not being legal
	 */
	private String isLegalForElephant(XiangqiCoordinate source, XiangqiCoordinate destination, XiangqiColor color){
		if(color == XiangqiColor.RED && destination.getRank() > 4){ // checks that move is not over river
			latestMessage = "can't move over the river";
			return "can't move over the river";
		}
		else if(color == XiangqiColor.BLACK && destination.getRank() < 5){
			latestMessage = "can't move over the river";
			return "can't move over the river";
		}
		//gets the direction of the move
		int rankDirection = getDirection(source,destination)[0];
		int fileDirection = getDirection(source,destination)[1];

		//checks if the route is empty
		if(java.lang.Math.abs(destination.getFile()-source.getFile()) == 2 && java.lang.Math.abs(destination.getRank()-source.getRank()) == 2){
			if(board[source.getRank()+rankDirection][source.getFile()+fileDirection].getPiece().getPieceType() == XiangqiPieceType.NONE) return "OK";
			else { latestMessage = "Something in the way"; return "Something in the way";}
		}
		latestMessage = "Wrong Advisor move";
		return "Wrong Advisor move";
	}
	
	private int[] getDirection(XiangqiCoordinate source, XiangqiCoordinate destination){
		int rankDirection = 0;
		int fileDirection = 0;
		int[] result = new int[2];
		
		if(destination.getRank()-source.getRank() > 0){
			rankDirection = 1;
		}
		else rankDirection = -1;
		if(destination.getFile()-source.getFile() > 0){
			fileDirection = 1;
		}
		else fileDirection = -1;
		
		result[0] = rankDirection;
		result[1] = fileDirection;
		
		return result;
	}
	
	/**
	 * @param source
	 * @param destination
	 * @return returns "OK" or reason for not being legal
	 */
	private String isLegalForChariot(XiangqiCoordinate source, XiangqiCoordinate destination){
		System.out.println("GOT HERE");
		if(rankFileDifference(source,destination)[0] == 0){// finds the direction Rank or File
			System.out.println("GOT HERE1");
			if(piecesInFileBetween(source,destination) == 0) return "OK";
		}
		if(rankFileDifference(source,destination)[1] == 0){// finds the direction Rank or File
			System.out.println("GOT HERE2");
			if(piecesInRankBetween(source,destination) == 0) return "OK";
		}
		System.out.println("GOT HERE");
		return "Illegal";
	}
	
	/**
	 * @param source
	 * @param destination
	 * @return returns "OK" or reason for not being legal
	 */
	private String isLegalForCannon(XiangqiCoordinate source, XiangqiCoordinate destination){
		int distance;
		int jumpCounter = 0;
		boolean isKilling = false;
		if((board[destination.getRank()][destination.getFile()].getPiece().getColor() != board[source.getRank()][source.getFile()].getPiece().getColor()) &&
				(board[destination.getRank()][destination.getFile()].getPiece().getColor() != XiangqiColor.NONE)){
			isKilling = true;
		}
		if(rankFileDifference(source,destination)[0] == 0){// finds the direction Rank or File
			if(isKilling){
				//latestMessage = "Cannot move Cannon";
				if(piecesInFileBetween(source,destination) == 1) return "OK";
			}
			if(piecesInFileBetween(source,destination) == 0) return "OK";
		}
		if(rankFileDifference(source,destination)[1] == 0){// finds the direction Rank or File
			if(isKilling){
				//latestMessage = "Cannot move Cannon";
				if(piecesInRankBetween(source,destination) == 1) return "OK";
			}
			if(piecesInRankBetween(source,destination) == 0) return "OK";
		}
		latestMessage = "Cannon moved";
		return "illegal";
	}
	
	
	private String isLegalForHorse(XiangqiCoordinate source, XiangqiCoordinate destination){
		int rankDirection = getDirection(source,destination)[0];
		int fileDirection = getDirection(source,destination)[1];
		System.out.println(rankDirection + "RANK BETWEEN" + fileDirection);
		if(rankFileDifference(source,destination)[0] == 1 && rankFileDifference(source,destination)[1] == 2){
				return piecesInFileBetween(source,TheXiangqiCoordinateImpl.makeCoordinate(destination.getRank(), destination.getFile()+fileDirection)) == 0 ? "OK": "Illegal";
		}else if(rankFileDifference(source,destination)[0] == 2 && rankFileDifference(source,destination)[1] == 1){
			return piecesInRankBetween(source,TheXiangqiCoordinateImpl.makeCoordinate(destination.getRank()+rankDirection, destination.getFile())) == 0 ? "OK": "Illegal";
		}
		return "Illegal";
	}

	private int difference(int a, int b){
		return java.lang.Math.abs(a-b);
	}
	
	private int[] rankFileDifference(XiangqiCoordinate source, XiangqiCoordinate destination){
		int result[] = new int[2];
		result[0] = difference(source.getRank(),destination.getRank());
		result[1] = difference(source.getFile(),destination.getFile());
		return result;
	}
	
	private int piecesInRankBetween(XiangqiCoordinate source, XiangqiCoordinate destination){
		int distance = difference(source.getRank(),destination.getRank());
		int counter = 0;
		if(source.getRank() > destination.getRank()){
			System.out.println(counter);
			for(int i = 1; i < distance; i++){
				if(board[destination.getRank() + i][destination.getFile()].getPiece().getPieceType() != XiangqiPieceType.NONE){
					System.out.println(counter);
					counter++;
				}
			}
		}
		if(source.getRank() < destination.getRank()){
			for(int i = 1; i < distance; i++){	
				if(board[source.getRank() + i][source.getFile()].getPiece().getPieceType() != XiangqiPieceType.NONE){
					System.out.println(counter);
					counter++;
				}
			}
		}
		return counter;
	}
	
	private int piecesInFileBetween(XiangqiCoordinate source, XiangqiCoordinate destination){
		int distance = difference(source.getFile(),destination.getFile());
		int counter = 0;
		if(source.getFile() > destination.getFile()){
			for(int i = 1; i < distance; i++){
				if(board[destination.getRank()][destination.getFile() + i].getPiece().getPieceType() != XiangqiPieceType.NONE){
					System.out.println(counter);
					counter++;
				}
			}
		}
		if(source.getFile() < destination.getFile()){
			for(int i = 1; i < distance; i++){
				if(board[source.getRank()][source.getFile() + i].getPiece().getPieceType() != XiangqiPieceType.NONE){
					System.out.println(counter);
					counter++;
				}
			}
		}
		return counter;
	}
	
	
	
	
	/**
	 * @param source
	 * @param destination
	 * @param color that made the move
	 * @return returns "OK" or reason for not being legal
	 */
	private String isLegalForSoldier(XiangqiCoordinate source, XiangqiCoordinate destination, XiangqiColor color){
		if(java.lang.Math.abs(destination.getFile()-source.getFile()) + java.lang.Math.abs(destination.getRank()-source.getRank()) == 1){
			latestMessage = "Soldier Moved";
			if(color == XiangqiColor.RED && source.getRank() > 4){
				return "OK";
			}
			else if(color == XiangqiColor.BLACK && source.getRank() < 5){
				return "OK";
			}
			else{
				if(source.getFile() == destination.getFile()){
					return "OK";
				}
			}
		}
		latestMessage = "wrong Soldier move";
		return "wrong Soldier move";
	}
	
	/**
	 * @param isMoving
	 * @param toHere destination to where the latest move is made
	 * @return returns OK if there is no flyingGeneral returns winning side if there is
	 */ 
	private String checkFlyingGeneral(XiangqiColor isMoving, XiangqiCoordinate toHere){
		int redFile = findGeneral(XiangqiColor.RED).getFile();
		int blackFile = findGeneral(XiangqiColor.BLACK).getFile();
		int redRank = findGeneral(XiangqiColor.RED).getRank();
		int blackRank = findGeneral(XiangqiColor.BLACK).getRank();
		int distance;
		
		if(redFile == blackFile){
			//determines the positions of generals and checks coordinates between them to be clear
			if(redRank > blackRank){
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