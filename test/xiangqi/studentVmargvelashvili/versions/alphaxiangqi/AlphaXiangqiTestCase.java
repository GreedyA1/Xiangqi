/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.alphaxiangqi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import xiangqi.XiangqiGameFactory;
//import xiangqi.XiangqiGameFactory.AlphaXiangqiCoordinateImpl;
import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
/**
 * @author Vato
 *
 */
public class AlphaXiangqiTestCase {
	
	private XiangqiGame game;
	
	@Before
	public void setup(){
		game = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.ALPHA_XQ);
	}
	
	@Test 
	public void test() {
		assertNotNull(XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.ALPHA_XQ));
	}

	@Test 
	public void redMakesValidFirstMove(){
		System.out.println("=========================================================");
		System.out.println("RED MAKES FIRST");
		assertEquals(MoveResult.OK, game.makeMove(AlphaXiangqiCoordinateImpl.makeCoordinate(1, 1), AlphaXiangqiCoordinateImpl.makeCoordinate(1, 2)));
		System.out.println("Black MAKES Second");
		assertEquals(MoveResult.RED_WINS, game.makeMove(AlphaXiangqiCoordinateImpl.makeCoordinate(1, 1), AlphaXiangqiCoordinateImpl.makeCoordinate(1, 2)));
		assertEquals(MoveResult.OK, game.makeMove(AlphaXiangqiCoordinateImpl.makeCoordinate(1, 2), AlphaXiangqiCoordinateImpl.makeCoordinate(1, 3)));
		System.out.println("Black MAKES Second");
		assertEquals(MoveResult.RED_WINS, game.makeMove(AlphaXiangqiCoordinateImpl.makeCoordinate(1, 2), AlphaXiangqiCoordinateImpl.makeCoordinate(1, 1)));
		System.out.println("=========================================================");
	}
	
	
	@Test
	public void tryToMoveToInvalidLocation(){
		System.out.println("=========================================================");
		System.out.println("11 to 22");
		assertEquals(MoveResult.ILLEGAL, game.makeMove(AlphaXiangqiCoordinateImpl.makeCoordinate(1, 1), AlphaXiangqiCoordinateImpl.makeCoordinate(2, 2)));
		assertTrue(game.getMoveMessage().length() >= 1);
	}
	
	@Test
	public void tryToMoveFromInvalidLocation(){
		System.out.println("=========================================================");
		System.out.println("21 to 12");
		assertEquals(MoveResult.ILLEGAL, game.makeMove(AlphaXiangqiCoordinateImpl.makeCoordinate(2, 1), AlphaXiangqiCoordinateImpl.makeCoordinate(1, 2)));
		assertTrue(game.getMoveMessage().length() >= 1);
	}
	
	@Test
	public void getPieceAtReturnsNoneNone(){
		System.out.println("=========================================================");
		System.out.println("get piece at");
		final XiangqiPiece p = game.getPieceAt(AlphaXiangqiCoordinateImpl.makeCoordinate(1,1),XiangqiColor.RED);
		assertEquals(MoveResult.OK, game.makeMove(AlphaXiangqiCoordinateImpl.makeCoordinate(1, 1), AlphaXiangqiCoordinateImpl.makeCoordinate(1, 2)));
	}

}
