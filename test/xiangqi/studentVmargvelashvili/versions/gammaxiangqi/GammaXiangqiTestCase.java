/**
 * 
 */
package xiangqi.studentVmargvelashvili.versions.gammaxiangqi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import xiangqi.XiangqiGameFactory;
//import xiangqi.XiangqiGameFactory.GammaXiangqiCoordinateImpl;
import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentVmargvelashvili.versions.commonFiles.TheXiangqiCoordinateImpl;
/**
 * @author Vato
 *
 */
public class GammaXiangqiTestCase {
	
	private XiangqiGame game;
	
	@Before
	public void setup(){
		game = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.GAMMA_XQ);
	}
	
	@Test 
	public void test() {
		assertNotNull(XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.GAMMA_XQ));
	}

	
	//@Test 
	public void testElephantMove(){
		System.out.println("==========================================================================================================================");
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 1), TheXiangqiCoordinateImpl.makeCoordinate(5, 3)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 1), TheXiangqiCoordinateImpl.makeCoordinate(5, 3)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(5, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 5)));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(5, 3), TheXiangqiCoordinateImpl.makeCoordinate(7, 5))); // trying to get over the river
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(5, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 5))); //retrying the move with correct coordinates
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 5), TheXiangqiCoordinateImpl.makeCoordinate(1, 3)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 5), TheXiangqiCoordinateImpl.makeCoordinate(1, 3)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 3), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(XiangqiPieceType.ADVISOR, game.getPieceAt(TheXiangqiCoordinateImpl.makeCoordinate(1, 4), XiangqiColor.RED).getPieceType());
		assertEquals(XiangqiColor.RED, game.getPieceAt(TheXiangqiCoordinateImpl.makeCoordinate(1, 4), XiangqiColor.RED).getColor());
	}
	
	@Test 
	public void testAdvisorMove(){
		System.out.println("=========================================================testAdvisorMove");
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 4), TheXiangqiCoordinateImpl.makeCoordinate(2, 5)));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 4), TheXiangqiCoordinateImpl.makeCoordinate(2, 3)));
		System.out.println(game.getMoveMessage());
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 4), TheXiangqiCoordinateImpl.makeCoordinate(2, 5)));
		System.out.println(game.getMoveMessage());
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 5), TheXiangqiCoordinateImpl.makeCoordinate(3, 6)));
		System.out.println(game.getMoveMessage());
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 5), TheXiangqiCoordinateImpl.makeCoordinate(3, 6)));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 6), TheXiangqiCoordinateImpl.makeCoordinate(4, 7)));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 6), TheXiangqiCoordinateImpl.makeCoordinate(2, 7)));
	}
	
	@Test 
	public void testChariotMove(){
		System.out.println("=========================================================testChariotMove");
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 1), TheXiangqiCoordinateImpl.makeCoordinate(3, 1)));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 1), TheXiangqiCoordinateImpl.makeCoordinate(8, 1)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 1), TheXiangqiCoordinateImpl.makeCoordinate(2, 1)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 1), TheXiangqiCoordinateImpl.makeCoordinate(2, 1)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 1), TheXiangqiCoordinateImpl.makeCoordinate(2, 6)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 1), TheXiangqiCoordinateImpl.makeCoordinate(2, 2)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 6), TheXiangqiCoordinateImpl.makeCoordinate(8, 6)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 2), TheXiangqiCoordinateImpl.makeCoordinate(2, 4)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(8, 6), TheXiangqiCoordinateImpl.makeCoordinate(8, 3)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 4), TheXiangqiCoordinateImpl.makeCoordinate(6, 4)));
	}
	
	@Test 
	public void testGeneralMove(){
		System.out.println("=========================================================testGeneralMove");
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 5), TheXiangqiCoordinateImpl.makeCoordinate(3, 5)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 5), TheXiangqiCoordinateImpl.makeCoordinate(2, 5)));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 5), TheXiangqiCoordinateImpl.makeCoordinate(1, 6)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(1, 5), TheXiangqiCoordinateImpl.makeCoordinate(2, 5)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 5), TheXiangqiCoordinateImpl.makeCoordinate(2, 4)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 5), TheXiangqiCoordinateImpl.makeCoordinate(3, 5)));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 4), TheXiangqiCoordinateImpl.makeCoordinate(2, 3)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(2, 4), TheXiangqiCoordinateImpl.makeCoordinate(3, 4)));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 5), TheXiangqiCoordinateImpl.makeCoordinate(4, 5)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 5), TheXiangqiCoordinateImpl.makeCoordinate(2, 5)));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 4), TheXiangqiCoordinateImpl.makeCoordinate(3, 2)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(3, 4), TheXiangqiCoordinateImpl.makeCoordinate(2, 4)));
	}
	
	@Test 
	public void testSoldierMove(){
		System.out.println("=========================================================testSoldierMove");
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(4, 5), TheXiangqiCoordinateImpl.makeCoordinate(5, 5)));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(4, 1), TheXiangqiCoordinateImpl.makeCoordinate(4, 2)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(4, 1), TheXiangqiCoordinateImpl.makeCoordinate(5, 1)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(5, 5), TheXiangqiCoordinateImpl.makeCoordinate(6, 5)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(5, 1), TheXiangqiCoordinateImpl.makeCoordinate(6, 1)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(6, 5), TheXiangqiCoordinateImpl.makeCoordinate(7, 5)));
		assertEquals(MoveResult.OK, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(6, 1), TheXiangqiCoordinateImpl.makeCoordinate(7, 1)));
		assertEquals(MoveResult.BLACK_WINS, game.makeMove(TheXiangqiCoordinateImpl.makeCoordinate(7, 5), TheXiangqiCoordinateImpl.makeCoordinate(7, 4)));
	}
}



