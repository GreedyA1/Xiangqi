/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.betaxiangqi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import xiangqi.XiangqiGameFactory;
//import xiangqi.XiangqiGameFactory.BetaXiangqiCoordinateImpl;
import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
/**
 * @author Vato
 *
 */
public class BetaXiangqiTestCase {
	
	private XiangqiGame game;
	
	@Before
	public void setup(){
		game = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.BETA_XQ);
	}
	
	@Test 
	public void test() {
		assertNotNull(XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.BETA_XQ));
	}

	@Test 
	public void redMakesValidFirstMove(){
		System.out.println("=========================================================");
		System.out.println("RED MAKES FIRST");
		assertEquals(MoveResult.OK, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(2, 3), BetaXiangqiCoordinateImpl.makeCoordinate(3, 3)));
		assertEquals(MoveResult.OK, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(2, 3), BetaXiangqiCoordinateImpl.makeCoordinate(2, 4)));
		assertEquals(MoveResult.BLACK_WINS, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(3, 3), BetaXiangqiCoordinateImpl.makeCoordinate(3, 4)));
		//System.out.println("Black MAKES Second");
		//assertEquals(MoveResult.RED_WINS, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(1, 1), BetaXiangqiCoordinateImpl.makeCoordinate(1, 2)));
	}
	
	@Test 
	public void testAdvisorMove(){
		System.out.println("=========================================================");
		assertEquals(MoveResult.OK, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(1, 2), BetaXiangqiCoordinateImpl.makeCoordinate(2, 1)));
		assertEquals(MoveResult.OK, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(1, 2), BetaXiangqiCoordinateImpl.makeCoordinate(2, 3)));
		assertEquals(MoveResult.OK, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(2, 1), BetaXiangqiCoordinateImpl.makeCoordinate(1, 2)));
		//assertEquals(MoveResult.BLACK_WINS, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(3, 3), BetaXiangqiCoordinateImpl.makeCoordinate(3, 4)));
		//System.out.println("Black MAKES Second");
		//assertEquals(MoveResult.RED_WINS, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(1, 1), BetaXiangqiCoordinateImpl.makeCoordinate(1, 2)));
	}
	
	@Test 
	public void testChariotMove(){
		System.out.println("=========================================================");
		assertEquals(MoveResult.OK, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(1, 1), BetaXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.OK, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(1, 1), BetaXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.OK, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(3, 1), BetaXiangqiCoordinateImpl.makeCoordinate(3, 5)));
		//System.out.println("Black MAKES Second");
		//assertEquals(MoveResult.RED_WINS, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(1, 1), BetaXiangqiCoordinateImpl.makeCoordinate(1, 2)));
	}
	
	@Test 
	public void testSoldierMove(){
		System.out.println("=========================================================");
		assertEquals(MoveResult.OK, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(2, 3), BetaXiangqiCoordinateImpl.makeCoordinate(3, 3)));
		assertEquals(MoveResult.OK, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(2, 3), BetaXiangqiCoordinateImpl.makeCoordinate(3, 3)));
		assertEquals(MoveResult.OK, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(3, 3), BetaXiangqiCoordinateImpl.makeCoordinate(4, 3)));
		//System.out.println("Black MAKES Second");
		//assertEquals(MoveResult.RED_WINS, game.makeMove(BetaXiangqiCoordinateImpl.makeCoordinate(1, 1), BetaXiangqiCoordinateImpl.makeCoordinate(1, 2)));
	}
}



